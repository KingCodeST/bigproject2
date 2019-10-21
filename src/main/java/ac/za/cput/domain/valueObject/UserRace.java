package ac.za.cput.domain.valueObject;

import java.util.Objects;

public class UserRace {

    private String userEmail,raceId;

    private UserRace(){}

    public UserRace(String userEmail, String raceId) {
        this.userEmail = userEmail;
        this.raceId = raceId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getRaceId() {
        return raceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRace userRace = (UserRace) o;
        return userEmail.equals(userRace.userEmail) &&
                Objects.equals(raceId, userRace.raceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail);
    }
}
