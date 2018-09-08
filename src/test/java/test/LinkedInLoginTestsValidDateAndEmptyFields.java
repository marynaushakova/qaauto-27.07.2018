package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedInHomePage;

public class LinkedInLoginTestsValidDateAndEmptyFields extends BaseTest{

    @DataProvider
    public Object[][] validFieldsCombination() {
        return new Object[][]{
                {"mf689799@gmail.com", "MirMer1010" },
                {"MF689799@gmail.com", "MirMer1010" },
                {" mf689799@gmail.com", " MirMer1010"}
        };
    }
    @Test (dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass) {
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPass);
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");
    }

    @DataProvider
    public Object[][] emptyFieldsCombination() {
        return new Object[][]{
                {"", "" },
                {"", "P@ssword123" },
                {"someone@domain.com", "" }
        };
    }
    @Test (dataProvider = "emptyFieldsCombination")
    public void validateEmptyFieldsCombination(String userEmail, String userPass) {
        linkedInLoginPage.login(userEmail, userPass);
        Assert.assertTrue(linkedInLoginPage.isLoaded(),"User is not on login page.");
    }
}

