package site.stellarburgers;

public class User {
    public String email;
    public String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static User from(UserData userData) {
        return new User(userData.getEmail(), userData.getPassword());
    }
}
