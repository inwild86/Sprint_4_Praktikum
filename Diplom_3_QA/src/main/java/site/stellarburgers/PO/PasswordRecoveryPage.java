package site.stellarburgers.PO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class PasswordRecoveryPage {
    public static final String PASSWORD_RECOVERY_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    public SelenideElement entryButton;

    @Step("Click login button")
    public void clickEntryButton() {

        entryButton.shouldBe(Condition.visible).shouldBe(Condition.visible).click();
    }
}
