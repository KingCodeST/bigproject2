package ac.za.cput.domain.valueObject;

public class User {

    private String email,firstName, lastName;

    private User(){}

    private User(Builder builder)
    {
        this.email =builder.email;
        this.firstName =builder.firstName;
        this.lastName =builder.lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Builder{

        private String email,firstName, lastName;

        public Builder setEmail(String email)
        {
            this.email =email;
            return this;
        }

        public Builder setFirstName(String firstName)
        {
            this.firstName =firstName;
            return this;
        }

        public Builder setLastName(String lastName)
        {
            this.lastName =lastName;
            return this;
        }

        public Builder copy(User user)
        {
            this.email =user.email;
            this.lastName =user.lastName;
            this.firstName =user.firstName;
            return this;
        }

        public User build()
        {
            return new User(this);

        }

    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
