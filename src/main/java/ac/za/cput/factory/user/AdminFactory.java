package ac.za.cput.factory.user;

import ac.za.cput.domain.user.Admin;

public class AdminFactory {


    public static Admin GenerateBuilder(String email,String fname,String lname)
    {
        return new Admin.Builder()
                        .setEmail(email)
                        .setFname(fname)
                        .setLname(lname)
                        .build();
    }

}
