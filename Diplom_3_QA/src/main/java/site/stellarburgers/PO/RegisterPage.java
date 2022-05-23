package site.stellarburgers.PO;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import site.stellarburgers.UserData;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {
    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = ".//input[@class = 'text input__textfield text_type_main-default']")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input[@class='text input__textfield text_type_main-default']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//fieldset[3]//input[@class='text input__textfield text_type_main-default']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationButton;
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    public SelenideElement loginPageButtonInBottom;
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Некорректный пароль')]")
    private SelenideElement textErrorPassword;

    @FindBy(xpath = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement errorMessage;

    @Step("Click on the buttonName")
    public void clickNameField() {
        nameField.click();
    }
    @Step("Click on the button Email")
    public void clickEmailField() {
        emailField.click();
    }
    @Step("Click on the buttonPassword")
    public void clickPasswordField() {
        passwordField.click();
    }
    @Step("Checking the text of the error message")
    public void checkTextErrorMessageInputPassword(){
        textErrorPassword.shouldHave(exactText("Некорректный пароль"));
    }
    @Step("Click on the login button")
    public void clickEnterButton() {
        enterButton.click();
    }
    @Step("Click on the register button")
    public void clickregistrationButton() {
        registrationButton.click();
    }


    @Step("Clicking on the Personal Account button")
    public void clickLoginPageButtonInBottom() {
        loginPageButtonInBottom.click();
    }

    @Step("Fill out the registration form: name {userName}, email {userEmail}, password {userPassword}")
    public void fillFormRegisterUser(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
        registrationButton.click();
    }

    public void fillFormRegisterUser(UserData userData) {
        nameField.setValue(userData.getName());
        emailField.setValue(userData.getEmail());
        passwordField.setValue(userData.getPassword());
        registrationButton.click();
    }
    @Step("Check error message if password isn't corrected")
    public boolean errorMessage(String text) {
        errorMessage.shouldBe(visible).shouldHave(exactText(text));
        return true;
    }
}
