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

    @BeforeMethod
    public void beforeMethod (){
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
    }
    @AfterMethod
    public void afterMethod (){browser.close();
    }
   @Test
    public void successfulLoginTest () throws InterruptedException {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(browser);
        linkedInLoginPage.login("mf689799@gmail.com", "Miriam123");

        sleep (5000);

        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(browser);
        linkedInHomePage.isProfileNavigationItemDisplayed();

        String urlAfterSuccessLogin = browser.getCurrentUrl();
        String title = browser.getTitle();

        Assert.assertEquals (urlAfterSuccessLogin, "https://www.linkedin.com/feed/", "Incorrect URL");
        Assert.assertEquals (title, "LinkedIn", "Home page title is wrong");

        Assert.assertTrue(linkedInHomePage.isProfileNavigationItemDisplayed());
    }
    @Test
    public void negativeLoginTest () throws InterruptedException {

        WebElement userEmailField = browser.findElement(By.xpath("//*[@id=\"login-email\"]"));
        WebElement userPassword = browser.findElement(By.xpath("//*[@id=\"login-password\"]"));
        WebElement signInButton = browser.findElement(By.xpath("//*[@id=\"login-submit\"]"));

        userEmailField.sendKeys("abc.i");
        userPassword.sendKeys("wrong");
        signInButton.sendKeys(Keys.ENTER);

        sleep (3000);

        WebElement alertBox = browser.findElement(By.xpath("//*[@role='alert']"));
        Assert.assertEquals (alertBox.getText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");

    }
}

