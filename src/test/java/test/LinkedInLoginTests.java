package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedInHomePage;
import page.LinkedInLoginPage;
import page.LinkedInLoginSubmitPage;

public class LinkedInLoginTests {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod() {browser.close();
    }

    @DataProvider
    public Object[][] validFieldsCombination() {
        return new Object[][]{
                {"mf689799@gmail.com", "Miriam123" },
                //{"MF689799@gmail.com", "Miriam123" },
                //{" mf689799@gmail.com", " Miriam123"}
        };
    }
    @Test (dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass) {
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.loginReturnHomePage(userEmail, userPass);
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
        linkedInLoginPage.loginReturnLoginPage(userEmail, userPass);
        Assert.assertTrue(linkedInLoginPage.isLoaded(),"User is not on login page.");
    }

    @DataProvider
     public Object[][] invalidUserEmailAndPasswordCombinations() {
     return new Object[][]{
              {"a", "1", "Слишком короткий текст (минимальная длина – 3 симв., введено – 1 симв.).", "Пароль должен содержать не менее 6 символов."},
              {"MF689799@GMAIL.COM", "MIRIAM123", "", "Это неверный пароль. Повторите попытку или измените пароль."},
              {"1","1111111111111", "Обязательно включите в номер значок «+» и код своей страны.", ""},
              {"qwertyuiop", "qwertyuiop", "Укажите действительный адрес эл. почты.", ""},
              {"qwertyuiop@bla.bla", "qwertyuiop", "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", ""},
              {"qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop", "qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop", "Слишком длинный текст: максимальная длина – 128 симв., введено 150 симв.", ""},
              {"qwertyuiop@bla.bla","qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwerty", "","Пароль должен содержать не более 400 символов." }
        };
    }
    @Test (dataProvider = "invalidUserEmailAndPasswordCombinations")
    public void validateWrongUserEmailAndPassword (String userEmail, String userPass, String userEmailValidationText, String userPasValidationText ){
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = linkedInLoginPage.loginReturnSubmitPage(userEmail,userPass);
        Assert.assertTrue(linkedInLoginSubmitPage.isLoaded(), "User is not on LoginSubmit page.");

        Assert.assertEquals(linkedInLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message when Short Email And Pass are set");

        Assert.assertEquals(linkedInLoginSubmitPage.getUserEmailValidationText(),
                userEmailValidationText,
                "User Email Validation Field has wrong message text");

        Assert.assertEquals(linkedInLoginSubmitPage.getUserPasswordValidationText(),
                userPasValidationText,
                "User Password Validation Field has wrong message text");
    }
}

