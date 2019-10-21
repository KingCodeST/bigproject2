package ac.za.cput.controller.user;

import ac.za.cput.domain.logevent.LogEvent;
import ac.za.cput.domain.user.Gender;
import ac.za.cput.factory.logevent.LogEventFactory;
import ac.za.cput.factory.user.GenderFactory;
import ac.za.cput.service.user.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bigproject2/lookup/gender")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @PostMapping(value = "/create/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(@PathVariable String gender){

        System.out.println("Entered Value:" + gender);
        LogEvent logEvent = LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Gender created!");
        Gender savedItem;

        if(gender ==null || gender.trim().isEmpty() || gender.trim().equalsIgnoreCase("null"))
        {
            logEvent.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            logEvent.setResponseDesc("Provide a gender");
        }else
        {
            savedItem = genderService.retrieveByDesc(gender);
            if(savedItem !=null)
            {
                logEvent.setResponseDesc("Gender already");
            }else{
                savedItem = GenderFactory.GenerateBuilder(gender);
                savedItem =genderService.create(savedItem);
            }
            logEvent.setResponse(savedItem);
        }
        return ResponseEntity.ok(logEvent);

    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        LogEvent logEvent =LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Success");
        List<Gender> items =genderService.getAll();
        logEvent.setResponse(items);
        return ResponseEntity.ok(logEvent);
    }

}


