import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import static java.lang.Thread.sleep;

public class LinkedInRequestPasswordResetPage extends BasePage {
    @FindBy(xpath ="//input[@name='userName']" )
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountButton;

    @FindBy(xpath = "//a[@class='form__cancel']")
    private WebElement cancelButton;

    public LinkedInRequestPasswordResetPage(WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
    public LinkedInPasswordResetSubmitPage clickOnFindAccount(String userEmail) {
        gMailService = new GMailService(userEmail, "Miriam123");
        gMailService.connect();

        userEmailField.sendKeys(userEmail);
        findAccountButton.click();
        String messageSubject = "содержит ссылку для изменения пароля";
        String messageTo = "mf689799@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        return new LinkedInPasswordResetSubmitPage(browser);
    }
    public boolean isLoaded() {
            return findAccountButton.isDisplayed()
                    && getCurrentPageTitle().contains("Изменить пароль")
                    && getCurrentPageURL().contains("/request-password-reset");
    }
}
