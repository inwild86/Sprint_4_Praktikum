package site.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.PO.*;

import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static site.stellarburgers.PO.MainPage.MAIN_PAGE_URL;

public class ConstructorTest {
    public UserActions userActions;
    public String token;
    public UserData userData;
    MainPage mainPage = page(MainPage.class);

    @Before
    public void setUp() {
        userActions = new UserActions();
        userData = UserData.getRandomUser();
        Response response = userActions.createUser(userData);
        token = userActions.getAccessToken(response);
        open(MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        userActions.deleteCustomer(token);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Checking Sauce tabs")
    public void clickOnSauceButtonTest() {
        mainPage.clickSaucesButton();
        assertTrue("Isn't sauces tab", mainPage.isSaucesTabText());
    }

    @Test
    @DisplayName("Checking Fillings tabs")
    public void clickOnFillingsButtonTest() {
        mainPage.clickFillingsButton();
        assertTrue("Isn't fillings tab", mainPage.isFillingsTabText());
    }

    @Test
    @DisplayName("Checking Bread tabs")
    public void clickOnBreadButtonTest() {
        mainPage.clickBunsButton();
        assertTrue("Isn't buns tab", mainPage.isBunsTabText());
    }
}
