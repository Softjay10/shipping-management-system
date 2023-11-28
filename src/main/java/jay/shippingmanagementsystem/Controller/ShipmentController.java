package jay.shippingmanagementsystem.Controller;

import jay.shippingmanagementsystem.Model.Customer.CustomerService;
import jay.shippingmanagementsystem.Model.Shipment.Shipment;
import jay.shippingmanagementsystem.Model.Shipment.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/shipments")
    public String listShipment(Model model, Shipment shipment) {
        model.addAttribute("shipments", shipmentService.getShipmentList());
        model.addAttribute("customers", customerService.getCustomerList());

        return "views/backend/shipment/index";
    }

    @GetMapping(value = "/delivered")
    public String listDelivered(Model model) {
        model.addAttribute("delivered", shipmentService.getDeliveredList());
        return "views/backend/delivered/index";
    }

    @GetMapping(value = "/pending")
    public String listPending(Model model) {
        model.addAttribute("pending", shipmentService.getPendingList());
        return "views/backend/pending/index";
    }

    @RequestMapping(value = "/shipments/findById")
    @ResponseBody
    public Optional<Shipment> findById(Long id){
        return shipmentService.getShipmentById(id);
    }

    @PostMapping(value = "/create-shipments")
    public String addShipment(Shipment shipment) {
        shipmentService.createShipment(shipment);
        return "redirect:/shipments";
    }

    @RequestMapping(value = "/update-shipments", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Shipment shipment) {
        shipmentService.createShipment(shipment);
        return "redirect:/shipments";
    }

    @RequestMapping(value = "/delete-shipments", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        shipmentService.deleteShipment(id);
        return "redirect:/shipments";
    }
}
