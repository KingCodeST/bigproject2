package ac.za.cput.service.valueObject.impl;

import ac.za.cput.domain.valueObject.UserGender;
import ac.za.cput.repository.valueObject.UserGenderRepository;
import ac.za.cput.repository.valueObject.impl.UserGenderRepositoryImpl;
import ac.za.cput.service.valueObject.UserGenderService;
import org.springframework.stereotype.Service;

@Service
public class UserGenderServiceImpl implements UserGenderService {

    private static UserGenderService userGenderService = null;
    private UserGenderRepository userGenderRepository;

    private UserGenderServiceImpl() {
        this.userGenderRepository = UserGenderRepositoryImpl.getEmployeeGenderRepository();
    }

    public static UserGenderService getEmployeeGenderService() {
        if (userGenderService == null) userGenderService = new UserGenderServiceImpl();
        return userGenderService;
    }


    @Override
    public UserGender create(UserGender userGender) {
        return this.userGenderRepository.create(userGender);
    }

    @Override
    public UserGender read(String s) {
        return this.userGenderRepository.read(s);
    }

    @Override
    public UserGender update(UserGender userGender) {
        return this.userGenderRepository.update(userGender);
    }

    @Override
    public void delete(String s) {
        this.userGenderRepository.delete(s);
    }
}