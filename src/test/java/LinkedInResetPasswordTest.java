import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedInResetPasswordTest {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(browser);
        Assert.assertTrue(linkedInLoginPage.isLoaded(), "Login page is not loaded");
    }
    @AfterMethod
    public void afterMethod() {browser.close();
    }
    @Test
    public void linkedInResetPasswordTest(){
        LinkedInResetPasswordPage linkedInResetPasswordPage = linkedInLoginPage.loginReturnResetPasswordPage();
        Assert.assertTrue(linkedInResetPasswordPage.isLoaded(), "Reset password page is not loaded");

        LinkedInResetPasswordRequestPage linkedInResetPasswordRequestPage = linkedInResetPasswordPage.sendResetPasswordRequest("mf689799@gmail.com");
        Assert.assertTrue(linkedInResetPasswordRequestPage.isLoaded(), "Reset password request page is not loaded");

        try {
            sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LinkedInResetPasswordConfirmationPage linkedInResetPasswordConfirmationPage=new LinkedInResetPasswordConfirmationPage(browser);
        LinkedInSuccessfulResetPasswordPage linkedInSuccessfulResetPasswordPage = linkedInResetPasswordConfirmationPage.confirmResetPassword("MirMer_198310", "MirMer_198310");
        Assert.assertTrue(linkedInSuccessfulResetPasswordPage.isLoaded(), "Successful reset password page is not loaded");

        LinkedInHomePage linkedInHomePage=linkedInSuccessfulResetPasswordPage.returnToHomePage();
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");
    }
}
