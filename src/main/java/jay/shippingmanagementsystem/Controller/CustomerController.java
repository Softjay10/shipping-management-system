package jay.shippingmanagementsystem.Controller;

import jay.shippingmanagementsystem.Model.Customer.Customer;
import jay.shippingmanagementsystem.Model.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customers")
    public String listCustomer(Model model) {
        model.addAttribute("customers", customerService.getCustomerList());
        return "views/backend/customer/index";
    }

    @GetMapping(value = "/add-customer")
    public String addCustomer(Model model, Customer customer){
        model.addAttribute("customers",customer);
        return "views/backend/customer/create";
    }

    @PostMapping(value = "/create-customer")
    public String createCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @RequestMapping(value = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(name = "id") long id){
        customerService.delete(id);
        return "redirect:/customers";
    }

    @GetMapping(value = "/edit-customer/{id}")
    public String updateCustomer(@PathVariable(value = "id")long id, Model model){
        Customer customer = customerService.getCustomerId(id);
        model.addAttribute("customers",customer);
        return "views/backend/customer/update";
    }
}
