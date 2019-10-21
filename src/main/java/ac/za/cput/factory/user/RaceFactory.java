package ac.za.cput.factory.user;

import ac.za.cput.domain.user.Race;
import ac.za.cput.util.Misc;

public class RaceFactory {

    public static Race GenerateBuilder(String race)
    {
        return new Race.Builder()
                        .setDesc(race)
                        .setId(Misc.generatedId())
                        .build();
    }

}
