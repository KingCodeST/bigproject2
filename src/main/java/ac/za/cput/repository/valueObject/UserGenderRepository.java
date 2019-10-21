package ac.za.cput.repository.valueObject;

import ac.za.cput.domain.valueObject.UserGender;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGenderRepository extends IRepository<UserGender,String> {
}
