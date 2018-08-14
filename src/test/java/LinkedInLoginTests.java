import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class LinkedInLoginTests {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;
    String currentURL;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }
    @DataProvider
    public Object[][] validFieldsCombination() {
        return new Object[][]{
                {"mf689799@gmail.com", "Miriam123" },
                {"MF689799@gmail.com", "Miriam123" },
                {" mf689799@gmail.com", " Miriam123"}
        };
    }

    @Test (dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass) {
        linkedInLoginPage.login(userEmail, userPass);
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(browser);
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");
    }

    @Test
    public void negativeLoginTest() {

        linkedInLoginPage.login("abc.i", "wrong");
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(browser);
        Assert.assertEquals(linkedInLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");
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

    @Test  //data hardcoded
    public void validateEmptyUserEmailAndUserPasswordFields() {
        linkedInLoginPage.login("", "");
        Assert.assertTrue(linkedInLoginPage.isLoaded(),"User is not on login page.");
    }

    @Test
    public void negativeLoginTest4CorrectEmailAndWrongPassFields() {
        linkedInLoginPage.login("mf689799@gmail.com", "1");
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(browser);
        Assert.assertEquals(linkedInLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message when Correct Email And Wrong Pass are set");
    }

    @Test
    public void negativeLoginTest5WrongEmailAndCorrectPassFields() {
        linkedInLoginPage.login("mf689799gmail.com", "Miriam123");
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(browser);
        Assert.assertEquals(linkedInLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message when Wrong Email And Correct Pass are set");
    }
     //HomeWork describe data provider for next combinations
    @Test
    public void validateShortUserEmailAndPassword (){
        linkedInLoginPage.login("a", "a");
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(browser);
        Assert.assertTrue(linkedInLoginSubmitPage.isLoaded(), "User is not on LoginSubmit page.");

        Assert.assertEquals(linkedInLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message when Short Email And Pass are set");

        Assert.assertEquals(linkedInLoginSubmitPage.getUserEmailValidationText(),
                "Слишком короткий текст (минимальная длина – 3 симв., введено – 1 симв.).",
                "User Email Validation Field has wrong message text");

        Assert.assertEquals(linkedInLoginSubmitPage.getUserPasswortValidationText(),
                "Пароль должен содержать не менее 6 символов.",
                "User Password Validation Field has wrong message text");
    }
}

