import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInSuccessfulResetPasswordPage extends BasePage {
    @FindBy(xpath = "//button[contains(@class, 'form__cancel--stretch')]")
    private WebElement returnToLoginPageButton;

    public LinkedInSuccessfulResetPasswordPage (WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public LinkedInHomePage returnToHomePage() {
        returnToLoginPageButton.click();
        return new LinkedInHomePage(browser);
    }
    public boolean isLoaded() {
        return returnToLoginPageButton.isDisplayed()
                && getCurrentPageTitle().contains("Вы изменили")
                && getCurrentPageURL().contains("/password-reset-submit");
    }
}