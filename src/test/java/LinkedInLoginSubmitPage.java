import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInLoginSubmitPage extends BasePage {
    private WebElement alertBox;
    private WebElement userEmailValidationText;
    private WebElement userPasswordValidationText;

    public LinkedInLoginSubmitPage(WebDriver browser){
        this.browser = browser;
        initElements();
    }
    private void initElements (){
        alertBox = browser.findElement(By.xpath("//*[@role='alert']"));
        userEmailValidationText = browser.findElement(By.xpath("//*[@id='session_key-login-error']"));
        userPasswordValidationText = browser.findElement(By.xpath("//*[@id='session_password-login-error']"));
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
