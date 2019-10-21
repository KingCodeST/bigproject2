package ac.za.cput.controller.order;

import ac.za.cput.domain.logevent.LogEvent;
import ac.za.cput.domain.order.Orders;
import ac.za.cput.factory.logevent.LogEventFactory;
import ac.za.cput.factory.order.OrdersFactory;
import ac.za.cput.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bigproject2/lookup/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/create/{order}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(@PathVariable String order, Date date){

        System.out.println("Entered Value:" + order);
        LogEvent logEvent = LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Orders created!");
        Orders savedItem;

        if(order ==null || order.trim().isEmpty() || order.trim().equalsIgnoreCase("null"))
        {
            logEvent.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            logEvent.setResponseDesc("Provide a order");
        }else
        {
            savedItem = orderService.retrieveByDesc(order);
            if(savedItem !=null)
            {
                logEvent.setResponseDesc("Orders already");
            }else{
                savedItem = OrdersFactory.GenerateBuilder(date,order);
                savedItem =orderService.create(savedItem);
            }
            logEvent.setResponse(savedItem);
        }
        return ResponseEntity.ok(logEvent);

    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        LogEvent logEvent =LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Success");
        List<Orders> items =orderService.getAll();
        logEvent.setResponse(items);
        return ResponseEntity.ok(logEvent);
    }

}
