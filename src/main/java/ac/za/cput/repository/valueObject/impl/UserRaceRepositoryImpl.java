package ac.za.cput.repository.valueObject.impl;

import ac.za.cput.domain.valueObject.User;
import ac.za.cput.domain.valueObject.UserRace;
import ac.za.cput.repository.valueObject.UserRaceRepository;
import ac.za.cput.service.valueObject.UserRaceService;

import java.util.HashSet;
import java.util.Set;

public class UserRaceRepositoryImpl implements UserRaceRepository {

    private static UserRaceRepository userRaceRepository = null;
    private Set<UserRace> userRaces;

    private UserRaceRepositoryImpl() {
        this.userRaces = new HashSet<>();
    }

    public static UserRaceRepository getEmployeeGenderRepository() {
        if (userRaceRepository == null) userRaceRepository = new UserRaceRepositoryImpl();
        return userRaceRepository;
    }

    @Override
    public UserRace create(UserRace userRace) {
        this.userRaces.add(userRace);
        return userRace;
    }


    @Override
    public UserRace read(String s) {
        return this.userRaces.stream().filter(eg -> eg.getUserEmail().equalsIgnoreCase(s)).findAny().orElse(null);
    }


    @Override
    public UserRace update(UserRace userRace) {
        UserRace eg = read(userRace.getUserEmail());
        if (eg != null) {
            delete(eg.getUserEmail());
            return create(userRace);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        UserRace userRace = read(s);
        if (userRace != null) this.userRaces.remove(userRace);
    }
}