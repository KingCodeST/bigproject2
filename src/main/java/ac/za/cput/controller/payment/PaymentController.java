package ac.za.cput.controller.payment;

import ac.za.cput.domain.logevent.LogEvent;
import ac.za.cput.domain.payment.Payment;
import ac.za.cput.factory.logevent.LogEventFactory;
import ac.za.cput.factory.payment.PaymentFactory;
import ac.za.cput.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bigproject2/lookup/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create/{payment}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(@PathVariable String payment, int money){

        System.out.println("Entered Value:" + payment);
        LogEvent logEvent = LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Payment created!");
        Payment savedPayment;

        if(payment ==null || payment.trim().isEmpty() || payment.trim().equalsIgnoreCase("null"))
        {
            logEvent.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            logEvent.setResponseDesc("Provide a payment");
        }else
        {
            savedPayment = paymentService.retrieveByDesc(payment);
            if(savedPayment !=null)
            {
                logEvent.setResponseDesc("Payment already");
            }else{
                savedPayment = PaymentFactory.GenerateBuilder(money);
                savedPayment =paymentService.create(savedPayment);
            }
            logEvent.setResponse(savedPayment);
        }
        return ResponseEntity.ok(logEvent);

    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        LogEvent logEvent =LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Success");
        List<Payment> items =paymentService.getAll();
        logEvent.setResponse(items);
        return ResponseEntity.ok(logEvent);
    }

}
