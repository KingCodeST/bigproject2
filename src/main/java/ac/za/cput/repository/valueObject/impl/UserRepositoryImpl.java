package ac.za.cput.repository.valueObject.impl;

import ac.za.cput.domain.valueObject.User;
import ac.za.cput.repository.user.UserRepository;
import ac.za.cput.service.valueObject.UserService;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository userRepository = null;
    private Set<User> users;

    private UserRepositoryImpl() {
        this.users = new HashSet<>();
    }

    public static UserRepository getEmployeeGenderRepository() {
        if (userRepository == null) userRepository = new UserRepositoryImpl();
        return userRepository;
    }

    @Override
    public User create(User user) {
        this.users.add(user);
        return user;
    }


    @Override
    public User read(String s) {
        return this.users.stream().filter(eg -> eg.getEmail().equalsIgnoreCase(s)).findAny().orElse(null);
    }


    @Override
    public User update(User user) {
        User eg = read(user.getEmail());
        if (eg != null) {
            delete(eg.getEmail());
            return create(user);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        User user = read(s);
        if (user != null) this.users.remove(user);
    }
}