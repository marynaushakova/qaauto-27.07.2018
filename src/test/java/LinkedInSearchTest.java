import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedInSearchTest {

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
   public void linkedInFindHRTest () throws InterruptedException {
       LinkedInHomePage linkedInHomePage = linkedInLoginPage.loginReturnHomePage("mf689799@gmail.com", "Miriam123");
       Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");

       LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search("HR");
       Assert.assertTrue(linkedInSearchPage.isLoaded(), "Search page is not loaded");
       Assert.assertEquals(linkedInSearchPage.getSearchResultsCount(), 10, "Search results count is wrong");
       //Assert.assertEquals();
   }
}

