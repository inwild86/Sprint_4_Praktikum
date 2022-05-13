package site.stellarburgers.PO;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;

public class MainPage {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";

    @FindBy(how = How.XPATH, using =  "//p[text()='Конструктор']")
    private SelenideElement constructor;

    @FindBy(how = How.XPATH, using ="//p[text()='Лента Заказов']")
    private SelenideElement OrderFeed;

    @FindBy(how = How.XPATH, using ="//p[text()='Личный Кабинет']")
    private SelenideElement PersonalArea;

    @FindBy(how = How.XPATH, using ="//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement linkLogo;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private static SelenideElement accountEntryButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    public SelenideElement createOrderButton;

    @FindBy(how = How.XPATH, using =".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement fillingsTab;

    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Начинки')]")
    private SelenideElement fillingsButton;

    @FindBy(how = How.XPATH, using ="//*[text()='Соусы']")
    private SelenideElement saucesButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']")
    private SelenideElement saucesTab;

    @FindBy(how = How.XPATH, using =".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement bunsButton;

    @FindBy(how = How.XPATH, using =".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement bunsTab;


    @Step("Click constructor button")
    public void clickConstructor(){
        constructor.click();
    }

    @Step("Click Order List button")
    public  void clickOrderFeed(){    OrderFeed.click();    }
    @Step("Click sign in button")
    public  static  void clicSignInButton(){    accountEntryButton.click();    }

    @Step("Click Personal Account button")
    public void clickLinkPersonalArea(){
        PersonalArea.click();
    }

    @Step("Click Link Logo button")
    public void clickLinkLogo(){
        linkLogo.click();
    }
    @Step("Checking the display of the Checkout button")
    public  boolean CheckCreateOrderButton() {
        return createOrderButton.isEnabled();
    }

    @Step("Click fillings button")
    public void clickFillingsButton() {
        fillingsButton.click();
    }

    @Step("Check fillings tab exact text 'Начинки'")
    public boolean isFillingsTabText() {
        fillingsTab.shouldHave(exactText("Начинки"));
        return true;
    }

    @Step("Click sauces button")
    public void clickSaucesButton() {
        saucesButton.click();
    }

    @Step("Check sauces tab exact text 'Соусы'")
    public boolean isSaucesTabText() {
        saucesTab.shouldHave(exactText("Соусы"));
        return true;
    }

    @Step("Click buns button")
    public void clickBunsButton() {
        bunsButton.click();
    }

    @Step("Check buns tab exact text 'Булки'")
    public boolean isBunsTabText() {
        bunsTab.shouldHave(exactText("Булки"));
        return true;
    }
}
