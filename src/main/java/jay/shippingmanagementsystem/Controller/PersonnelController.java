package jay.shippingmanagementsystem.Controller;

import jay.shippingmanagementsystem.Model.Payment.Payment;
import jay.shippingmanagementsystem.Model.Personnel.Personnel;
import jay.shippingmanagementsystem.Model.Personnel.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping(value = "/personnel")
    public String listPersonnel(Model model) {
        model.addAttribute("personnel", personnelService.getPersonnelList());
        return "views/backend/personnel/index";
    }

    @RequestMapping(value = "/personnel/findById")
    @ResponseBody
    public Optional<Personnel> findById(Long id){
        return personnelService.getPersonnelById(id);
    }

    @PostMapping(value = "/create-personnel")
    public String addPayment(Personnel personnel) {
        personnelService.createPersonnel(personnel);
        return "redirect:/personnel";
    }

    @RequestMapping(value = "/update-personnel", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Personnel personnel) {
        personnelService.createPersonnel(personnel);
        return "redirect:/personnel";
    }

    @RequestMapping(value = "/delete-personnel", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        personnelService.deletePersonnel(id);
        return "redirect:/personnel";
    }
}
