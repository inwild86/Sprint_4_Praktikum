package site.stellarburgers;

import com.codeborne.selenide.Selenide;
import site.stellarburgers.PO.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.*;
import static site.stellarburgers.PO.MainPage.MAIN_PAGE_URL;
import static site.stellarburgers.PO.PasswordRecoveryPage.PASSWORD_RECOVERY_PAGE_URL;
import static site.stellarburgers.PO.RegisterPage.REGISTER_PAGE_URL;

import site.stellarburgers.PO.RegisterPage;

public class LoginUserTest {
    public UserActions userActions;
    public String token;
    public UserData userData;
    RegisterPage registerPage = page(RegisterPage.class);
    LoginPage loginPage = page(LoginPage.class);
    MainPage mainPage = page(MainPage.class);
    PasswordRecoveryPage passwordRecoveryPage = page(PasswordRecoveryPage.class);

    @Before
    public void setUp() {
        userActions = new UserActions();
        userData = UserData.getRandomUser();
        Response response = userActions.createUser(userData);
        open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.fillFormRegisterUser(userData);
        token = userActions.getAccessToken(response);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Login by clicking the Login button on the main page")
    public void userLoginClickAccountButton() {
        open(MAIN_PAGE_URL, MainPage.class);
        mainPage.clicSignInButton();
        loginPage.login(userData.getEmail(), userData.getPassword());
        assertTrue(mainPage.checkCreateOrderButton());
    }

    @Test
    @DisplayName("Login through the Personal Account button")
    public void userLoginClickPersonalAccountButton() {
        open(MAIN_PAGE_URL, MainPage.class);
        mainPage.clickLinkPersonalArea();
        loginPage.login(userData.getEmail(), userData.getPassword());
        assertTrue(mainPage.checkCreateOrderButton());
    }

    @Test
    @DisplayName("Login through the button on the registration page")
    public void userLoginInRegisterPage() {
        open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.clickLoginPageButtonInBottom();
        loginPage.login(userData.getEmail(), userData.getPassword());
        assertTrue(mainPage.checkCreateOrderButton());
    }

    @Test
    @DisplayName("Login via the button in the password recovery form")
    public void userLoginInRestorePasswordRecoveryForm() {
        open(PASSWORD_RECOVERY_PAGE_URL, PasswordRecoveryPage.class);
        passwordRecoveryPage.clickEntryButton();
        loginPage.login(userData.getEmail(), userData.getPassword());
        assertTrue(mainPage.checkCreateOrderButton());
    }
}
