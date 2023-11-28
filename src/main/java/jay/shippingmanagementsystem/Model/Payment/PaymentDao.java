package jay.shippingmanagementsystem.Model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {

    @Query(value = "SELECT p FROM Payment p WHERE p.paymentType = 'cash' OR p.paymentType = 'card' OR p.paymentType = 'cheque' OR p.paymentType= 'others'")
    List<Payment> getPaymentAll();

    @Query(value = "SELECT SUM(p.amount) FROM Payment p")
    Integer getTotalAmount();
}
