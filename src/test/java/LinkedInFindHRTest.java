import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class LinkedInFindHRTest {

    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;
  //  LinkedInSearchPage linkedInSearchPage;

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
       linkedInLoginPage.loginReturnHomePage("mf689799@gmail.com", "Miriam123");
       LinkedInHomePage linkedInHomePage = new LinkedInHomePage(browser);
       Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");

       WebElement searchField = browser.findElement(By.xpath("//*[@role='combobox']"));
       searchField.sendKeys("hr");
       searchField.sendKeys(Keys.ENTER);

       sleep(1000);
       LinkedInSearchPage linkedInSearchPage = new LinkedInSearchPage(browser);
       Assert.assertTrue(linkedInSearchPage.isLoaded(), "Home page is not loaded");

       List<WebElement> searchResultsList = browser.findElements(By.xpath("//*[@class='search-result search-result__occluded-item ember-view']"));
       System.out.println("Results count: " + searchResultsList.size());

       sleep(1000);

       if (searchResultsList.size() == 10) {
           System.out.println("results count is correct");
       } else {
           System.out.println("results count is incorrect");
       }

       for (WebElement searchResultItem : searchResultsList) {
           String searchResultText = searchResultItem.getText();
           System.out.println(searchResultItem.getText());
           if (searchResultText.toLowerCase().contains("hr")) {
               System.out.println("SearchItem Found");
           } else {
               System.out.println("SearchItem not Found");
           }
       }
   }

}
