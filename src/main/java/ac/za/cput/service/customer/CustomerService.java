package ac.za.cput.service.customer;

import ac.za.cput.domain.customer.Customer;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService extends IService<Customer,String> {
    Customer retrieveByDesc(String customerDesc);
    List<Customer> getAll();
}
