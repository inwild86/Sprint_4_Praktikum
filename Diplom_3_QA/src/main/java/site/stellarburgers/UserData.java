package site.stellarburgers;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class UserData {
    private String email;
    private String password;
    private String name;

    public UserData(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    static Faker faker = new Faker();

    @Step("Creating the correct user")
    public static UserData getRandomUser() {
        final String userEmail = faker.internet().emailAddress();
        final String userPassword = faker.internet().password(6, 15, true);
        final String userName = faker.name().username();
        Allure.addAttachment("Email: ", userEmail);
        Allure.addAttachment("Пароль: ", userPassword);
        Allure.addAttachment("Имя: ", userName);
        return new UserData(userEmail, userPassword, userName);
    }

    @Step("Creating a user with an incorrect password")
    public static UserData getInvalidPasswordRandom() {
        final String userEmail = faker.internet().emailAddress();
        final String userPassword = faker.internet().password(1, 5, true);
        final String userName = faker.name().username();
        Allure.addAttachment("Email: ", userEmail);
        Allure.addAttachment("Пароль: ", userPassword);
        Allure.addAttachment("Имя: ", userName);
        return new UserData(userEmail, userPassword, userName);
    }
}
