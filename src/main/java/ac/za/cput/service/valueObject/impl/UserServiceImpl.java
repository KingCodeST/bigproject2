package ac.za.cput.service.valueObject.impl;

import ac.za.cput.domain.valueObject.User;
import ac.za.cput.repository.user.UserRepository;
import ac.za.cput.repository.valueObject.impl.UserRepositoryImpl;
import ac.za.cput.service.valueObject.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static UserService userService = null;
    private UserRepository userRaceRepository;

    private UserServiceImpl() {
        this.userRaceRepository = UserRepositoryImpl.getEmployeeGenderRepository();
    }

    public static UserService getEmployeeGenderService() {
        if (userService == null) userService = new UserServiceImpl();
        return userService;
    }


    @Override
    public User create(User user) {
        return this.userRaceRepository.create(user);
    }

    @Override
    public User read(String s) {
        return this.userRaceRepository.read(s);
    }

    @Override
    public User update(User user) {
        return this.userRaceRepository.update(user);
    }

    @Override
    public void delete(String s) {
        this.userRaceRepository.delete(s);
    }
}