package ac.za.cput.controller.user;

import ac.za.cput.domain.logevent.LogEvent;
import ac.za.cput.domain.user.Admin;
import ac.za.cput.factory.logevent.LogEventFactory;
import ac.za.cput.factory.user.AdminFactory;
import ac.za.cput.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bigproject2/lookup/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/create/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(@PathVariable String fname,String lname,String email){

        System.out.println("Entered Value:" + email);
        LogEvent logEvent = LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"admin created!");
        Admin savedItem;

        if(email ==null || email.trim().isEmpty() || email.trim().equalsIgnoreCase("null"))
        {
            logEvent.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            logEvent.setResponseDesc("Provide a email");
        }else
        {
            savedItem = adminService.retrieveByDesc(email);
            if(savedItem !=null)
            {
                logEvent.setResponseDesc("admin already");
            }else{
                savedItem = AdminFactory.GenerateBuilder(email,fname,lname);
                savedItem =adminService.create(savedItem);
            }
            logEvent.setResponse(savedItem);
        }
        return ResponseEntity.ok(logEvent);

    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        LogEvent logEvent =LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Success");
        List<Admin> items =adminService.getAll();
        logEvent.setResponse(items);
        return ResponseEntity.ok(logEvent);
    }

}
