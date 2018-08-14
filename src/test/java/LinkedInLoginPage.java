import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedInLoginPage {
    private WebDriver browser;
    private WebElement userEmailField;
    private WebElement userPassword;
    private WebElement signInButton;

    public LinkedInLoginPage (WebDriver browser){//конструктор класса, в этом случае назване метода с большой буквы и такое же как класс
        this.browser = browser;
        initElements();
    }
    private void initElements (){
        userEmailField = browser.findElement(By.xpath("//*[@id=\"login-email\"]"));
        userPassword = browser.findElement(By.xpath("//*[@id=\"login-password\"]"));
        signInButton = browser.findElement(By.xpath("//*[@id=\"login-submit\"]"));
    }

    public void login (String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPassword.sendKeys(userPass);
        signInButton.click ();
        try {
            sleep (5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentPageTitle() {return browser.getTitle();}
    public String getCurrentPageURL() {return browser.getCurrentUrl();}

    public boolean isLoaded() {
        return signInButton.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn: Войти или зарегистрироваться")
                && getCurrentPageURL().equals("https://www.linkedin.com/");
    }
}
