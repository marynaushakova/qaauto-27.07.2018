import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInLoginPage extends BasePage {

    @FindBy(xpath ="//*[@id=\"login-email\"]" )
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement userPassword;

    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class= 'link-forgot-password']")
    private WebElement linkForgotPassword;

    public LinkedInLoginPage (WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public LinkedInLoginSubmitPage loginReturnSubmitPage (String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPassword.sendKeys(userPass);
        signInButton.click ();
        try {
            sleep (5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInLoginSubmitPage(browser);
    }

    public LinkedInHomePage loginReturnHomePage (String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPassword.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInHomePage(browser);
    }

    public LinkedInLoginPage loginReturnLoginPage (String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPassword.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInLoginPage(browser) ;
    }
    public LinkedInResetPasswordPage loginReturnResetPasswordPage () {
        linkForgotPassword.click();
            try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInResetPasswordPage(browser) ;
    }

    public boolean isLoaded() {
        return signInButton.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn: Войти или зарегистрироваться")
                && getCurrentPageURL().equals("https://www.linkedin.com/");
    }
}
