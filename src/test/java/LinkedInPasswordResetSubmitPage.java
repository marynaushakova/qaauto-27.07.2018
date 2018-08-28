import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import static java.lang.Thread.sleep;

public class LinkedInPasswordResetSubmitPage extends BasePage{

    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement subtitleMessage;

    public LinkedInPasswordResetSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public  LinkedInSetNewPasswordPage navigateToLinkFromEmail() {

        //ToDo
        //Fixme
        return new LinkedInSetNewPasswordPage(browser);
    }

    public boolean isLoaded() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return subtitleMessage.isDisplayed()
                && getCurrentPageTitle().contains("Проверьте, получили ли")
                && getCurrentPageURL().contains("/request-password-reset-submit");
        }
}
