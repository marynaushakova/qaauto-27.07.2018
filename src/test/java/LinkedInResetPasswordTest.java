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
    public void successfulLinkedInResetPasswordTest(){
        LinkedInRequestPasswordResetPage linkedInRequestPasswordResetPage = linkedInLoginPage.clickOnForgotPasswordLink();
            Assert.assertTrue(linkedInRequestPasswordResetPage.isLoaded(), "RequestPasswordReset page is not loaded");

        LinkedInPasswordResetSubmitPage linkedInPasswordResetSubmitPage = linkedInRequestPasswordResetPage.clickOnFindAccount("mf689799@gmail.com");

        try {
            sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(linkedInPasswordResetSubmitPage.isLoaded(), "Reset password request page is not loaded");

        LinkedInSetNewPasswordPage linkedInSetNewPasswordPage = linkedInPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedInSetNewPasswordPage.isLoaded(), "LinkedInSetNewPasswordPage is not loaded");

        LinkedInSuccessfulResetPasswordPage linkedInSuccessfulResetPasswordPage = linkedInSetNewPasswordPage.confirmResetPassword("MirMer_111223", "MirMer_111223");
            Assert.assertTrue(linkedInSuccessfulResetPasswordPage.isLoaded(), "Successful reset password page is not loaded");

        LinkedInHomePage linkedInHomePage=linkedInSuccessfulResetPasswordPage.returnToHomePage();
            Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");
    }
}
