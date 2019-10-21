package ac.za.cput.domain.valueObject;

import java.util.Objects;

public class UserGender {

    private String userEmail,genderId;

    private UserGender(){}

    public UserGender(String userEmail, String genderId) {
        this.userEmail = userEmail;
        this.genderId = genderId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGender that = (UserGender) o;
        return userEmail.equals(that.userEmail) &&
                Objects.equals(genderId, that.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail);
    }
}
