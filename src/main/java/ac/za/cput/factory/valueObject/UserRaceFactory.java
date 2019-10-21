package ac.za.cput.factory.valueObject;

import ac.za.cput.domain.valueObject.UserRace;

public class UserRaceFactory {

    public static UserRace GenerateBuilder(String userEmail,String raceId)
    {
        return new UserRace(userEmail,raceId);
    }

}
