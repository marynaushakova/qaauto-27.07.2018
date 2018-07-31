import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static java.lang.Thread.sleep;

public class BadCodeExample {
    public static void main(String args[]) throws InterruptedException {
//      System.out.println("Hello world!!!");
//физическое открытие браузера
        WebDriver browser = new FirefoxDriver();
        browser.get("https://www.google.com");
//далее : WebElement => тип данных, element - переменная ( любое имя ), .get, .findelement это методы которые всегда идут с круглыми скобками
        WebElement element = browser.findElement(By.name("q"));
//далее переменная + метод
        element.sendKeys("Selenium");
//      element.submit();
        element.sendKeys(Keys.ENTER);
//пауза 3 сек
        sleep(3000);

// Verify that result list contains 10 elements ДЗ: вывести правильно или не правильно нашлось именно 10 результатов
        List<WebElement> searchResults = browser.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println("Results count: " + searchResults.size());

//Verify that each result item contains target searchterm ДЗ: вывести - этот результат содержит Selenium или этот результат не содержит Selenium
        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            System.out.println(searchResultText);
        }
    }
}



