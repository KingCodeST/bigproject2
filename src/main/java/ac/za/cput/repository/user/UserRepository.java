package ac.za.cput.repository.user;

import ac.za.cput.domain.valueObject.User;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends IRepository<User,String> {
}
