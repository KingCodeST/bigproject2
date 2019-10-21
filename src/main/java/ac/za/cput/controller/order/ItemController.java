package ac.za.cput.controller.order;

import ac.za.cput.domain.logevent.LogEvent;
import ac.za.cput.domain.order.Item;
import ac.za.cput.factory.logevent.LogEventFactory;
import ac.za.cput.factory.order.ItemFactory;
import ac.za.cput.service.order.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bigproject2/lookup/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/create/{item}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(@PathVariable String item, int weight){

        System.out.println("Entered Value:" + item);
        LogEvent logEvent = LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Item created!");
        Item savedItem;

        if(item ==null || item.trim().isEmpty() || item.trim().equalsIgnoreCase("null"))
        {
            logEvent.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            logEvent.setResponseDesc("Provide a item");
        }else
        {
            savedItem = itemService.retrieveByDesc(item);
            if(savedItem !=null)
            {
                logEvent.setResponseDesc("Item already");
            }else{
                savedItem = ItemFactory.GenerateBuilder(item,weight);
                savedItem =itemService.create(savedItem);
            }
            logEvent.setResponse(savedItem);
        }
        return ResponseEntity.ok(logEvent);

    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        LogEvent logEvent =LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Success");
        List<Item> items =itemService.getAll();
        logEvent.setResponse(items);
        return ResponseEntity.ok(logEvent);
    }



}
