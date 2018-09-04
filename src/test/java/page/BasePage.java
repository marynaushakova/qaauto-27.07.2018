package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * Page Object class with abstract AccessModifier for common variables extension
 */
public abstract class BasePage {
    protected WebDriver browser;
    protected static GMailService gMailService=new GMailService();

    /**
     * Parametrized waitUntilElementIsVisible method which implements confirmation of WebElement availability
     * @param webElement - input from test
     * @param timeOutInSeconds - input from test
     * @return value of variable with WebElement type
     */
    public WebElement waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(browser,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    /**
     * method getCurrentPageTitle
     * @return page title
     */
    public String getCurrentPageTitle() {
        return browser.getTitle();
    }

    /**
     * method getCurrentPageURL
     * @return page current URL
     */
    public String getCurrentPageURL() {
        return browser.getCurrentUrl();
    }

    /**
     * method IsLoaded with abstract AccessModifier to be realized in Page Object with extends
     */
    public abstract boolean isLoaded();
}
