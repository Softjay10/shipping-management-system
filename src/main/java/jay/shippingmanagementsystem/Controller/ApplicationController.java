package jay.shippingmanagementsystem.Controller;

import jay.shippingmanagementsystem.Model.Customer.CustomerDao;
import jay.shippingmanagementsystem.Model.Payment.PaymentDao;
import jay.shippingmanagementsystem.Model.Personnel.Personnel;
import jay.shippingmanagementsystem.Model.Personnel.PersonnelDao;
import jay.shippingmanagementsystem.Model.Shipment.ShipmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    PaymentDao paymentDao;

    @Autowired
    ShipmentDao shipmentDao;

    @Autowired
    PersonnelDao personnelDao;

    @GetMapping(value = "/")
    public String getDashboard(Model model){
        model.addAttribute("customers", customerDao.getCustomerByCount());
        model.addAttribute("payment", paymentDao.getTotalAmount());
        model.addAttribute("shipment", shipmentDao.getDeliveredShip());
        model.addAttribute("personnel", personnelDao.getPersonnelBy());
        return "views/backend/dashboard/index";
    }
}
