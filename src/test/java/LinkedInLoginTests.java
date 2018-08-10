import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class LinkedInLoginTests {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;

    @BeforeMethod
    public void beforeMethod (){
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod (){browser.close();
    }

    @Test
    public void successfulLoginTest () {

        linkedInLoginPage.login("mf689799@gmail.com", "Miriam123");
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(browser);
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");
    }

    @Test
    public void negativeLoginTest () {

        linkedInLoginPage.login("abc.i", "wrong");
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(browser);
        Assert.assertEquals (linkedInLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");

        //home task - add all possible negative tests
    }
}

