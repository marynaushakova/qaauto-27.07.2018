import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInResetPasswordRequestPage extends BasePage{

    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement subtitleMessage;

    public LinkedInResetPasswordRequestPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
        public boolean isLoaded() {
        return subtitleMessage.isDisplayed()
                && getCurrentPageTitle().contains("Проверьте, получили ли")
                && getCurrentPageURL().contains("/request-password-reset-submit");
        }
}
