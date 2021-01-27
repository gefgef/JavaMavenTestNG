package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver, WebDriverWait wait, Logger logger) {
        super(driver, wait, logger);
    }

    //ELEMENTS
    public final By emailField = By.cssSelector("input[data-component=\"email\"]");
    public final By emailFieldValidationErrorMessage = By.cssSelector("input[data-component=\"email\"] + div.invalid");
    public final By passwordField = By.cssSelector("input[data-component=\"password\"]");
    public final By passwordFieldValidationErrorMessage = By.cssSelector("input[data-component=\"password\"] ~ div.invalid");
    public final By submitButton = By.cssSelector("button[data-component=\"submit-button\"]");

    //METHODS
    public void login(String email, String password) {
        sleep(1);
        type(emailField, email);
        type(passwordField, password);
        click(submitButton);
    }

    public boolean areValidationErrorsDisplayed() {
        return (driver.findElement(emailFieldValidationErrorMessage).isDisplayed() &&
                driver.findElement(passwordFieldValidationErrorMessage).isDisplayed());
    }
}
