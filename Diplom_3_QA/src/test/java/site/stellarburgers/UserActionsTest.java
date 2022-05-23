package site.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.PO.*;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static site.stellarburgers.PO.LoginPage.LOGIN_PAGE_URL;
import static site.stellarburgers.PO.PersonalArea.USER_PAGE_URL;
import static site.stellarburgers.PO.RegisterPage.REGISTER_PAGE_URL;

public class UserActionsTest {
    public UserActions userActions;
    public String token;
    public UserData userData;
    RegisterPage registerPage = page(RegisterPage.class);
    LoginPage loginPage = page(LoginPage.class);
    MainPage mainPage = page(MainPage.class);
    PersonalArea personalArea = page(PersonalArea.class);

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
        userActions.deleteCustomer(token);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Exit through the exit button in your account")
    public void userLogout() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.login(userData.getEmail(), userData.getPassword());
        mainPage.clickLinkPersonalArea();
        personalArea.clickExitButton();
        assertTrue(loginPage.checkEmailLoginInputDisplayed());
    }

    @Test
    @DisplayName("Entry and move to the personal account page via the button Personal Area")
    public void checkTheTransitionToThePersonalAccountPage() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.login(userData.getEmail(), userData.getPassword());
        mainPage.clickLinkPersonalArea();
        personalArea.waitAfterExitButton();
        assertEquals("After clicking on the personal account, the page did not open",
                USER_PAGE_URL, url());
    }

    @Test
    @DisplayName("Transition to the main page after click the constructor button")
    public void checkTransitionAfterClickConstructorButton() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.login(userData.getEmail(), userData.getPassword());
        mainPage.clickLinkPersonalArea();
        personalArea.waitAfterExitButton();
        personalArea.clickConstructorButton();
        assertTrue(mainPage.checkCreateOrderButton());
    }

    @Test
    @DisplayName("Switching from personal account to the designer by clicking on the logo")
    public void moveToConstructorByLogoClick() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.login(userData.getEmail(), userData.getPassword());
        mainPage.clickLinkPersonalArea();
        personalArea.waitAfterExitButton();
        personalArea.clickLogo();
        assertTrue(mainPage.checkCreateOrderButton());
    }
}