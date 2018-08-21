import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInSearchPage extends BasePage {

    @FindBy(xpath ="//div[@class='search-results-page core-rail']" )
    private WebElement searchResultsElement;

    public LinkedInSearchPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public boolean isLoaded() {
        return searchResultsElement.isDisplayed()
                && getCurrentPageTitle().contains("| Поиск | LinkedIn")
                && getCurrentPageURL().equals("https://www.linkedin.com/search/results/index/?keywords=hr&origin=GLOBAL_SEARCH_HEADER");
    }
}
