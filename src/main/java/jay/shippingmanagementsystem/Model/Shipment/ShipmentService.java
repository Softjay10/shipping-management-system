package jay.shippingmanagementsystem.Model.Shipment;

import jay.shippingmanagementsystem.Model.Personnel.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentDao shipmentDao;

    public List<Shipment> getShipmentList() {
        return shipmentDao.getShipmentAll();
    }

    public List<Shipment> getDeliveredList(){
        return shipmentDao.getShipmentDelivered();
    }

    public List<Shipment> getPendingList() {
        return shipmentDao.getShipmentPending();
    }

    public Optional<Shipment> getShipmentById(Long id){
        return shipmentDao.findById(id);
    }

    public void createShipment(Shipment shipment){
        shipmentDao.save(shipment);
    }

    public void deleteShipment(Long id){
        shipmentDao.deleteById(id);
    }
}
