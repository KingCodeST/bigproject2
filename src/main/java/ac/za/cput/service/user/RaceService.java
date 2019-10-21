package ac.za.cput.service.user;

import ac.za.cput.domain.user.Race;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RaceService extends IService<Race,String> {
    Race retrieveByDesc(String raceDesc);
    List<Race> getAll();
}
