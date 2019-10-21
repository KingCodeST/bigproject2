package ac.za.cput.controller.order;

import ac.za.cput.domain.logevent.LogEvent;
import ac.za.cput.domain.order.OrderDetail;
import ac.za.cput.factory.logevent.LogEventFactory;
import ac.za.cput.factory.order.OrderDetailFactory;
import ac.za.cput.service.order.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bigproject2/lookup/orderdetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping(value = "/create/{orderdetail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(@PathVariable   int qty,  String orderdetail){

        System.out.println("Entered Value:" + orderdetail);
        LogEvent logEvent = LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"OrderDetail created!");
        OrderDetail savedItem;

        if(orderdetail ==null || orderdetail.trim().isEmpty() || orderdetail.trim().equalsIgnoreCase("null"))
        {
            logEvent.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            logEvent.setResponseDesc("Provide a orderdetail");
        }else
        {
            savedItem = orderDetailService.retrieveByDesc(orderdetail);
            if(savedItem !=null)
            {
                logEvent.setResponseDesc("OrderDetail already");
            }else{
                savedItem = OrderDetailFactory.GenerateBuilder(qty,orderdetail);
                savedItem =orderDetailService.create(savedItem);
            }
            logEvent.setResponse(savedItem);
        }
        return ResponseEntity.ok(logEvent);

    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        LogEvent logEvent =LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Success");
        List<OrderDetail> items =orderDetailService.getAll();
        logEvent.setResponse(items);
        return ResponseEntity.ok(logEvent);
    }

}
