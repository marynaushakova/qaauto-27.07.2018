package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.LinkedInLoginPage;

public class BaseTest {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;

    @Parameters({"browserName", "envURL" })
    @BeforeMethod
    public void beforeMethod(@Optional ("firefox") String browserName, @Optional ("https://ua.linkedin.com/") String envURL) {
        if (browserName.toLowerCase().equals("firefox")){
            browser = new FirefoxDriver();
        }
        if (browserName.toLowerCase().equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Temp\\chromedriver.exe");
            browser = new ChromeDriver();
        }
          else {
            try {
                throw new Exception("browserName "+browserName+" is  not supported");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        browser.get(envURL);
        linkedInLoginPage = new LinkedInLoginPage(browser);
    }
    @AfterMethod
    public void afterMethod() {browser.close();
    }
}