package pages;
import app.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageFactory {

    public LoginPage (WebDriver driver, WebDriverWait wait) {
        super (driver, wait);
    }

    private String URL = "";

    //ELEMENTS

    public By emailField = By.cssSelector("input[data-name=\"Email Address\"]");
    public By passwordField = By.cssSelector("input[data-name=\"Password\"]");
    public By loginButton = By.cssSelector("div.sc-fzqBZW button[type=\"submit\"]");
    public By forgotPasswordLink;

    //METHODS

    public void login(String email, String password) {
        WebElement login = driver.findElement(emailField);
        WebElement pass = driver.findElement(passwordField);
        waitForElementIsVisible(emailField);
        Sleep(2); //Page is reloading that's why we can't figure it out with any of Waits
        login.sendKeys(email);
        pass.sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
