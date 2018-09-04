package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInHomePage extends BasePage {

    @FindBy(xpath ="//*[@id='profile-nav-item']" )
    private WebElement profileNavigationItem;

    @FindBy(xpath ="//input[@placeholder and @role]" )
    private WebElement searchField;

    public LinkedInHomePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(profileNavigationItem,10);
    }

    public boolean isLoaded() {
        return profileNavigationItem.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn")
                && getCurrentPageURL().equals("https://www.linkedin.com/feed/");
    }

    public LinkedInSearchPage search(String searchTerm) {
        searchField.sendKeys((searchTerm));
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInSearchPage (browser);
    }
}


