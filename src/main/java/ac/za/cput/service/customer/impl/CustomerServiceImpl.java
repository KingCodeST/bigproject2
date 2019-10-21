package ac.za.cput.service.customer.impl;

import ac.za.cput.domain.customer.Customer;
import ac.za.cput.repository.customer.CustomerRepository;
import ac.za.cput.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static CustomerService customerService =null;

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerServiceImpl(){

    }

    public static CustomerService getCustomerService(){
        if(customerService ==null) customerService=new CustomerServiceImpl();
        return customerService;
    }

    @Override
    public Customer retrieveByDesc(String customerDesc) {
       List<Customer> customers =getAll();
       for(Customer customer:customers)
       {
           if(customer.getDeliveryAddress().equalsIgnoreCase(customerDesc))
               return customer;
       }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer read(String s) {
        Optional<Customer> optCustomer =this.customerRepository.findById(s);
        return optCustomer.orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public void delete(String s) {
        this.customerRepository.deleteById(s);

    }
}
