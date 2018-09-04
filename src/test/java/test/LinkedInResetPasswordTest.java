package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

public class LinkedInResetPasswordTest extends BaseTest {

    @Test
    public void successfulLinkedInResetPasswordTest(){
        LinkedInRequestPasswordResetPage linkedInRequestPasswordResetPage = linkedInLoginPage.clickOnForgotPasswordLink();
            Assert.assertTrue(linkedInRequestPasswordResetPage.isLoaded(), "RequestPasswordResetPage is not loaded");

        LinkedInPasswordResetSubmitPage linkedInPasswordResetSubmitPage = linkedInRequestPasswordResetPage.clickOnFindAccount("mf689799@gmail.com");
        try {
            sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(linkedInPasswordResetSubmitPage.isLoaded(), "PasswordResetSubmitPage is not loaded");


        LinkedInSetNewPasswordPage linkedInSetNewPasswordPage = linkedInPasswordResetSubmitPage.navigateToLinkFromEmail();
             Assert.assertTrue(linkedInSetNewPasswordPage.isLoaded(), "page.LinkedInSetNewPasswordPage is not loaded");

        LinkedInSuccessfulResetPasswordPage linkedInSuccessfulResetPasswordPage = linkedInSetNewPasswordPage.confirmResetPassword("MirMer_1010", "MirMer_1010");//last actual pass MirMer1010
            Assert.assertTrue(linkedInSuccessfulResetPasswordPage.isLoaded(), "SuccessfulResetPasswordPage is not loaded");

        LinkedInHomePage linkedInHomePage=linkedInSuccessfulResetPasswordPage.returnToHomePage();
            Assert.assertTrue(linkedInHomePage.isLoaded(), "HomePage is not loaded");
    }
}
