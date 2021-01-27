package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderComponent extends BasePage {

    public HeaderComponent(WebDriver driver, WebDriverWait wait, Logger logger) {
        super (driver, wait, logger);
    }

    //ELEMENTS
    public final By emailField = By.cssSelector("img[data-component=\"header-logo\"]");
    public final By loginLink = By.cssSelector("span.header-account__login-text");
    public final By registrationLink = By.cssSelector("span.header-account__register-text");
    public final By loggedInProfileButton = By.cssSelector("button.header-account__profile-button");

    //METHODS
    public boolean isUserLoggedIn() {
        return isElementPresentOnPage(loggedInProfileButton);
    }

    public void waitUntilUserIsLoggedIn() {
        waitForElementIsVisible(loggedInProfileButton);
    }
}