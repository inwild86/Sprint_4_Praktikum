package site.stellarburgers.PO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    public SelenideElement emailField;
    @FindBy(how = How.XPATH, using = "//h2[text() = 'Вход']")
    private SelenideElement titleLogin;
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    public SelenideElement passwordField;

    @FindBy(how = How.XPATH, using =  ".//button[text()='Войти']")
    private SelenideElement entryButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerLink;

    @Step("Set email")
    public void setEmail(String email) {
        emailField.setValue(email);
    }

    @Step("Set password")
    public void setPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Click entry button")
    public void clickEntryButton() {
        entryButton.shouldBe(visible).click();
    }

    @Step("Check go to login page")
    public boolean isLoginPage() {
        titleLogin.shouldBe(visible);
        return true;
    }
    @Step("Enter your username and password and log in")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
      clickEntryButton();
    }
    @Step("Поле email отображается")
    public boolean CheckEmailLoginInputDisplayed() {
        entryButton.shouldBe(visible);
        return entryButton.isDisplayed();
    }
}
