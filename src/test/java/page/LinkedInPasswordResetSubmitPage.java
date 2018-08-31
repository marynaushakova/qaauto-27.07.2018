package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInPasswordResetSubmitPage extends BasePage {

    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement subtitleMessage;

    public LinkedInPasswordResetSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public LinkedInSetNewPasswordPage navigateToLinkFromEmail() {

        String messageSubject = "содержит ссылку для изменения пароля";
        String messageTo = "mf689799@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Message:"+message);

        String resetPasswordLink = StringUtils.substringBetween(message,"нажмите <a href=\"<a href=&quot;", "&quot;>[text]</a>").replace("amp;","");
        System.out.println("Link:"+resetPasswordLink);
        browser.get(resetPasswordLink);

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
