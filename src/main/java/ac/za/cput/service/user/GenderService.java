package ac.za.cput.service.user;

import ac.za.cput.domain.user.Gender;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenderService extends IService<Gender,String> {
    Gender retrieveByDesc(String genderDesc);
    List<Gender> getAll();
}
