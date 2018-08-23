import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInResetPasswordPage extends BasePage {
    @FindBy(xpath ="//input[@name='userName']" )
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    @FindBy(xpath = "//a[@class='form__cancel']")
    private WebElement cancelButton;

    public LinkedInResetPasswordPage (WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
    public LinkedInResetPasswordRequestPage sendResetPasswordRequest (String userEmail) {
        userEmailField.sendKeys(userEmail);
        resetPasswordSubmitButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInResetPasswordRequestPage(browser);
    }
    public boolean isLoaded() {
            return resetPasswordSubmitButton.isDisplayed()
                    && getCurrentPageTitle().contains("Изменить пароль")
                    && getCurrentPageURL().contains("/request-password-reset");
    }
}
