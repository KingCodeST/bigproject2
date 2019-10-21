package ac.za.cput.controller.user;

import ac.za.cput.domain.logevent.LogEvent;
import ac.za.cput.domain.user.Race;
import ac.za.cput.factory.logevent.LogEventFactory;
import ac.za.cput.factory.user.RaceFactory;
import ac.za.cput.service.user.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bigproject2/lookup/race")
public class RaceController {

    @Autowired
    private RaceService raceService;

    @PostMapping(value = "/create/{race}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(@PathVariable String race){

        System.out.println("Entered Value:" + race);
        LogEvent logEvent = LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Race created!");
        Race savedRace;

        if(race ==null || race.trim().isEmpty() || race.trim().equalsIgnoreCase("null"))
        {
            logEvent.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            logEvent.setResponseDesc("Provide a race");
        }else
        {
            savedRace = raceService.retrieveByDesc(race);
            if(savedRace !=null)
            {
                logEvent.setResponseDesc("Race already");
            }else{
                savedRace = RaceFactory.GenerateBuilder(race);
                savedRace =raceService.create(savedRace);
            }
            logEvent.setResponse(savedRace);
        }
        return ResponseEntity.ok(logEvent);

    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        LogEvent logEvent =LogEventFactory.GenerateBuilder(HttpStatus.OK.toString(),"Success");
        List<Race> items =raceService.getAll();
        logEvent.setResponse(items);
        return ResponseEntity.ok(logEvent);
    }

}


