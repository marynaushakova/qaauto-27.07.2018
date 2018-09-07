package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * Page Object class for LinkedInLoginPage.
 */
public class LinkedInLoginPage extends BasePage {

    @FindBy(xpath ="//*[@id=\"login-email\"]" )
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement userPassword;

    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class= 'link-forgot-password']")
    private WebElement linkForgotPassword;

    /**
     * Parametrized constructor of LinkedInLoginPage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedInLoginPage (WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(signInButton,10);
    }

    /**
     * Method login, enters userEmail and UserPassword and click in SignIn button.
     * @param userEmail - String with user email.
     * @param userPass - String with user password.
     * @param <T> - Generic type to return corresponding pageObject.
     * @return either LinkedInLoginSubmitPage or LinkedInHomePage or LinkedInLoginPage pageObject.
     */
     public <T> T login (String userEmail, String userPass) {//generic type
            userEmailField.sendKeys(userEmail);
            userPassword.sendKeys(userPass);
            signInButton.click();
            if (getCurrentPageURL().contains("/feed")) {
                return (T) new LinkedInHomePage(browser);
            }
            if (getCurrentPageURL().contains("/uas/login-submit")) {
                return (T) new LinkedInLoginSubmitPage(browser);
            } else {
                return (T) new LinkedInLoginPage(browser);
            }
     }
    /**
     * clickOnForgotPasswordLink method, which implements the transition from LinkedInLoginPage to LinkedInLoginSubmitPage
     * @return value of variable with LinkedInRequestPasswordResetPage type
     */
    public LinkedInRequestPasswordResetPage clickOnForgotPasswordLink() {
        linkForgotPassword.click();
        return new LinkedInRequestPasswordResetPage(browser);
    }

    /**
     * isLoaded boolean method, implements validation of LinkedInLoginPage load
     * @return true/false
     */
    public boolean isLoaded() {
        return signInButton.isDisplayed();
               //&& getCurrentPageTitle().contains("LinkedIn: Войти или зарегистрироваться");
             //   && getCurrentPageURL().equals("https://www.linkedin.com/");
    }
}
