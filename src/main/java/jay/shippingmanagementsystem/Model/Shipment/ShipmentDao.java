package jay.shippingmanagementsystem.Model.Shipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentDao extends JpaRepository<Shipment, Long> {

    @Query(value = "SELECT s FROM Shipment s WHERE s.status = 'delivered' OR s.status = 'pending'")
    List<Shipment> getShipmentAll();

    @Query(value = "SELECT s FROM Shipment s WHERE s.status = 'delivered'")
    List<Shipment> getShipmentDelivered();

    @Query(value = "SELECT s FROM Shipment s WHERE s.status = 'pending'")
    List<Shipment> getShipmentPending();

    @Query(value = "SELECT COUNT(s.status) FROM Shipment s")
    Long getDeliveredShip();
}
