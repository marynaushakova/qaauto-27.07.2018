import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInLoginSubmitPage extends BasePage {
    @FindBy(xpath ="//*[@role='alert']" )
    private WebElement alertBox;

    @FindBy(xpath ="//*[@id='session_key-login-error']" )
    private WebElement userEmailValidationText;

    @FindBy(xpath ="//*[@id='session_password-login-error']" )
    private WebElement userPasswordValidationText;

    public LinkedInLoginSubmitPage(WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public String getAlertBoxText() {
        return alertBox.getText();
    }
    public boolean isLoaded() {
        return alertBox.isDisplayed()
                && getCurrentPageTitle().contains("Войти в LinkedIn")
                && getCurrentPageURL().equals("https://www.linkedin.com/uas/login-submit");
    }

    public String getUserEmailValidationText() {

        return userEmailValidationText.getText();
    }
    public String getUserPasswordValidationText() {

        return userPasswordValidationText.getText();
    }
}
