package ac.za.cput.service.valueObject;

import ac.za.cput.domain.valueObject.User;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User,String> {
}
