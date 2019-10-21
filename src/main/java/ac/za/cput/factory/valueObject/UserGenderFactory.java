package ac.za.cput.factory.valueObject;

import ac.za.cput.domain.valueObject.UserGender;

public class UserGenderFactory {

    public static UserGender GenerateBuilder(String Useremail,String genderId)
    {
        return new UserGender(Useremail,genderId);
    }

}
