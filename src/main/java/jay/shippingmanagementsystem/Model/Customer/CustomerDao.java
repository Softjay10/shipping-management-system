package jay.shippingmanagementsystem.Model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT c FROM Customer c WHERE c.status = 'Active' OR c.status = 'Inactive'")
    List<Customer> getCustomerStatus();

    @Query(value = "SELECT COUNT(c.id) FROM Customer c")
    Long getCustomerByCount();
}
