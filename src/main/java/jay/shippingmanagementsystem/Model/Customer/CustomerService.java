package jay.shippingmanagementsystem.Model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getCustomerList(){
        return customerDao.getCustomerStatus();
    }

    public Customer getCustomerId(long id){
        return customerDao.findById(id).get();
    }

    public void save(Customer customer) {
        customerDao.save(customer);
    }

    public void delete(long id){
        customerDao.deleteById(id);
    }
}
