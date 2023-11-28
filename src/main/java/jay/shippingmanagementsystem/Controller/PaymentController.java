package jay.shippingmanagementsystem.Controller;

import jay.shippingmanagementsystem.Model.Payment.Payment;
import jay.shippingmanagementsystem.Model.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/payments")
    public String listPayment(Model model) {
        model.addAttribute("payments", paymentService.getPaymentList());
        return "views/backend/payment/index";
    }

    @RequestMapping(value = "/payments/findById")
    @ResponseBody
    public Optional<Payment> findById(Long id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping(value = "/create-payment")
    public String addPayment(Payment payment, BindingResult bindingResult) {
        paymentService.createPayment(payment);
        return "redirect:/payments";
    }

    @RequestMapping(value = "/update-payment", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Payment payment) {
        paymentService.createPayment(payment);
        return "redirect:/payments";
    }

    @RequestMapping(value = "/delete-payment", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        paymentService.deletePayment(id);
        return "redirect:/payments";
    }
}
