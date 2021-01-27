package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;

    public BasePage (WebDriver driver, WebDriverWait wait, Logger logger) {
        this.driver = driver;
        this.wait = wait;
        this.logger = logger;
    }

    //ACTION METHODS
    public void click(WebElement element) {
        logger.info("Clicking element " + element.getText());
        element.click();
    }

    public void click(By selector) {
        logger.info("Clicking element using selector " + selector.toString());
        driver.findElement(selector).click();
    }

    public void type(WebElement element, String text) {
        logger.info("Typing text '" + text + "' into field " + element.getText());
        element.sendKeys(text);
    }

    public void type(By selector, String text) {
        logger.info("Typing text '" + text + "' into field " + selector.toString());
        driver.findElement(selector).sendKeys(text);
    }

    //WAIT METHODS
    public void waitForElementIsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //OTHERS METHODS
    public boolean isElementPresentOnPage(By selector) {
        return (driver.findElements(selector).size() > 0);
    }

    public void sleep(int seconds) {
        logger.info("Thread sleep for " + seconds + " seconds");
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception ex) {
            System.err.println(ex.toString());
            ex.printStackTrace();
        }
    }
}
