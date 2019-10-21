package ac.za.cput.service.user;

import ac.za.cput.domain.user.Admin;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService extends IService<Admin,String> {
    Admin retrieveByDesc(String adminDesc);
    List<Admin> getAll();
}
