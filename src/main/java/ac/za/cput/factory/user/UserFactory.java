package ac.za.cput.factory.user;

import ac.za.cput.domain.valueObject.User;

public class UserFactory {

    public static User GenerateBuilder(String email,String fname,String lname)
    {
        return new User.Builder()
                        .setEmail(email)
                        .setFirstName(fname)
                        .setLastName(lname)
                        .build();
    }

}
