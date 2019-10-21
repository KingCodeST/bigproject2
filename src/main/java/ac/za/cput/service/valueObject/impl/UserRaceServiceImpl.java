package ac.za.cput.service.valueObject.impl;

import ac.za.cput.domain.valueObject.UserRace;
import ac.za.cput.repository.valueObject.UserRaceRepository;
import ac.za.cput.repository.valueObject.impl.UserRaceRepositoryImpl;
import ac.za.cput.service.valueObject.UserRaceService;
import org.springframework.stereotype.Service;

@Service
public class UserRaceServiceImpl implements UserRaceService {


    private static UserRaceService userRaceService = null;
    private UserRaceRepository userRaceRepository;

    private UserRaceServiceImpl() {
        this.userRaceRepository = UserRaceRepositoryImpl.getEmployeeGenderRepository();
    }

    public static UserRaceService getEmployeeGenderService() {
        if (userRaceService == null) userRaceService = new UserRaceServiceImpl();
        return userRaceService;
    }


    @Override
    public UserRace create(UserRace userRace) {
        return this.userRaceRepository.create(userRace);
    }

    @Override
    public UserRace read(String s) {
        return this.userRaceRepository.read(s);
    }

    @Override
    public UserRace update(UserRace userRace) {
        return this.userRaceRepository.update(userRace);
    }

    @Override
    public void delete(String s) {
        this.userRaceRepository.delete(s);
    }
}