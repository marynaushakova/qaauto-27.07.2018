import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class IRSLoginTest {
    @Test
    public void successLogin() {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://ssi.wincor-nixdorf.com/");
        WebElement irs = browser.findElement(By.xpath("/html/body/ul/li[1]/a"));
        irs.sendKeys(Keys.ENTER);
    }
}
