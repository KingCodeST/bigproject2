package ac.za.cput.controller.order;

import ac.za.cput.domain.logevent.LogEvent;
import ac.za.cput.domain.order.OrderStatus;
import ac.za.cput.factory.logevent.LogEventFactory;
import ac.za.cput.factory.order.OrderStatusFactory;
import ac.za.cput.service.order.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bigproject2/lookup/orderstatus")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @PostMapping(value = "/create/{statusname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(@PathVariable String statusname,int create,int delivery,int paid,int shipping){

        System.out.println("Entered Value:" + statusname);
        LogEvent logEvent = LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"OrderStatus created!");
        OrderStatus savedOrderStatus;

        if(statusname ==null || statusname.trim().isEmpty() || statusname.trim().equalsIgnoreCase("null"))
        {
            logEvent.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            logEvent.setResponseDesc("Provide a statusname");
        }else
        {
            savedOrderStatus = orderStatusService.retrieveByDesc(statusname);
            if(savedOrderStatus !=null)
            {
                logEvent.setResponseDesc("OrderStatus already");
            }else{
                savedOrderStatus = OrderStatusFactory.GenerateBuilder(statusname,create,delivery,paid,shipping);
                savedOrderStatus =orderStatusService.create(savedOrderStatus);
            }
            logEvent.setResponse(savedOrderStatus);
        }
        return ResponseEntity.ok(logEvent);

    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        LogEvent logEvent =LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Success");
        List<OrderStatus> items =orderStatusService.getAll();
        logEvent.setResponse(items);
        return ResponseEntity.ok(logEvent);
    }

}
