import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static java.lang.Thread.sleep;

public class BadCodeExample {
    public static void main(String args[]) throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://www.google.com");
        WebElement element = browser.findElement(By.name("q"));
        element.sendKeys("Selenium");
        element.sendKeys(Keys.ENTER);

        sleep(3000);

        List<WebElement> searchResults = browser.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println("Results count: " + searchResults.size());

            if (searchResults.size() == 10) {
                System.out.println("results count is correct");
            }
            else {
                System.out.println("results count is incorrect");
            }
        // for each searchResults in searchResult list
        for (WebElement searchResult: searchResults) {
           String searchResultText = searchResult.getText();
            System.out.println(searchResult.getText());
        //System.out.println("This result contains \"Selenium\", true or false?:-------->>  " +searchResultText.contains("Selenium"));
            if (searchResultText.toLowerCase().contains("selenium")) {
                System.out.println("SearchItem Found");
            }
            else{
                System.out.println("SearchItem not Found");
            }
        }
    }
}



