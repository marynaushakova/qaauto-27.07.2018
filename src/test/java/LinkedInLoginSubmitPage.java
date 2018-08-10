import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedInLoginSubmitPage {
    private WebDriver browser;
    private WebElement alertBox;

    public LinkedInLoginSubmitPage(WebDriver browser){
        this.browser = browser;
        initElements();
    }
    private void initElements (){
        alertBox = browser.findElement(By.xpath("//*[@role='alert']"));
    }
    public String getAlertBoxText() {
        return alertBox.getText();
    }
}