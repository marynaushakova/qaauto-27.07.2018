import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInSetNewPasswordPage extends BasePage {
    @FindBy(xpath = "//input[@name='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmNewPasswordField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement newPasswordConfirmButton;

    public LinkedInSetNewPasswordPage(WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
    public LinkedInSuccessfulResetPasswordPage confirmResetPassword (String newPassword, String confirmNewPassword) {
        newPasswordField.sendKeys(newPassword);
        confirmNewPasswordField.sendKeys(confirmNewPassword);
        newPasswordConfirmButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInSuccessfulResetPasswordPage(browser);
    }
        public boolean isLoaded() {
        return newPasswordField.isDisplayed()
                && getCurrentPageTitle().contains("Изменить пароль")
                && getCurrentPageURL().contains("requestSubmissionId");
    }
}
