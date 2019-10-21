package ac.za.cput.repository.valueObject.impl;

import ac.za.cput.domain.valueObject.UserGender;
import ac.za.cput.repository.valueObject.UserGenderRepository;


import java.util.HashSet;
import java.util.Set;

public class UserGenderRepositoryImpl implements  UserGenderRepository {

    private static UserGenderRepository userGenderRepository = null;
    private Set<UserGender> userGenders;

    private UserGenderRepositoryImpl() {
        this.userGenders = new HashSet<>();
    }

    public static UserGenderRepository getEmployeeGenderRepository() {
        if (userGenderRepository == null) userGenderRepository = new UserGenderRepositoryImpl();
        return userGenderRepository;
    }

    @Override
    public UserGender create(UserGender userGender) {
        this.userGenders.add(userGender);
        return userGender;
    }

    @Override
    public UserGender read(String s) {
        return this.userGenders.stream().filter(eg -> eg.getUserEmail().equalsIgnoreCase(s)).findAny().orElse(null);
    }

    @Override
    public UserGender update(UserGender userGender) {
        UserGender eg = read(userGender.getUserEmail());
        if (eg != null) {
            delete(eg.getUserEmail());
            return create(userGender);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        UserGender userGender = read(s);
        if (userGender != null) this.userGenders.remove(userGender);
    }
}