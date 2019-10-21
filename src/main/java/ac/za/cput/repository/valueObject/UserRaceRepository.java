package ac.za.cput.repository.valueObject;

import ac.za.cput.domain.valueObject.User;
import ac.za.cput.domain.valueObject.UserRace;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRaceRepository extends IRepository<UserRace,String> {
}
