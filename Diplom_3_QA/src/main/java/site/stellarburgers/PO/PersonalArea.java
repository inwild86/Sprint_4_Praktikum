package site.stellarburgers.PO;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalArea {
    public static final String USER_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    public SelenideElement constructorButton;
    @FindBy(how = How.XPATH, using = "//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    public SelenideElement informationText;
    @FindBy(how = How.CSS, using = "div#root>div>header>nav")
    public SelenideElement logo;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'Account_button__14Yp3 text')]")
    public SelenideElement exitButton;

    @Step("Click on the logo in your account")
    public void clickLogo() {
        logo.click();
    }

    @Step("Click on the exit button in your account")
    public void clickExitButton() {
        exitButton.click();
    }

    @Step("Click on the Constructor button in your account")
    public void clickConstructorButton() {
        constructorButton.shouldBe(Condition.visible).click();
    }

    @Step("Wait after transition on the PA page")
    public void waitAfterExitButton() {
        exitButton.shouldBe(Condition.visible);
    }
}
