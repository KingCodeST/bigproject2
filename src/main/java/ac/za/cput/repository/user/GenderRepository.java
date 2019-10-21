package ac.za.cput.repository.user;

import ac.za.cput.domain.user.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender,String> {
}
