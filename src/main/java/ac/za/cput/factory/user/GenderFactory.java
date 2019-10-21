package ac.za.cput.factory.user;

import ac.za.cput.domain.user.Gender;
import ac.za.cput.util.Misc;

public class GenderFactory {

    public static Gender GenerateBuilder(String gender)
    {
        return new Gender.Builder()
                        .setDesc(gender)
                        .setId(Misc.generatedId())
                        .build();
    }

}
