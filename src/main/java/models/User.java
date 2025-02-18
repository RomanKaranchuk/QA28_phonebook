package models;

public class User {

    private String firsName;
    private String lastName;
    private String email;
    private String password;


    public models.User setFirsName(String firsName) {
        this.firsName = firsName;
        return this;
    }

    public models.User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public models.User setEmail(String email) {
        this.email = email;
        return this;
    }

    public models.User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
