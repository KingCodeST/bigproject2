package ac.za.cput.controller.customer;

import ac.za.cput.domain.customer.Customer;
import ac.za.cput.domain.logevent.LogEvent;
import ac.za.cput.factory.customer.CustomerFactory;
import ac.za.cput.factory.logevent.LogEventFactory;
import ac.za.cput.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bigproject2/lookup/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/create/{customer}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCustomer(@PathVariable String customer,boolean active,String contact,String delivery,String fname,String lname){

        System.out.println("Entered Value:" + customer);
        LogEvent logEvent = LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Customer created!");
        Customer savedCustomer;

        if(customer ==null || customer.trim().isEmpty() || customer.trim().equalsIgnoreCase("null"))
        {
            logEvent.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            logEvent.setResponseDesc("Provide a customer");
        }else
        {
            savedCustomer = customerService.retrieveByDesc(customer);
            if(savedCustomer !=null)
            {
                logEvent.setResponseDesc("Customer already");
            }else{
                savedCustomer = CustomerFactory.GenerateBuilder(active,contact,delivery,fname,lname);
                savedCustomer =customerService.create(savedCustomer);
            }
            logEvent.setResponse(savedCustomer);
        }
        return ResponseEntity.ok(logEvent);

    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        LogEvent logEvent =LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Success");
        List<Customer> customers =customerService.getAll();
        logEvent.setResponse(customers);
        return ResponseEntity.ok(logEvent);
    }



}
