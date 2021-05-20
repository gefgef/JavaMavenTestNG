package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Utility extends TestFactory {

    //PAGES
    public BasePage basePage;
    public LoginPage loginPage;
    public HeaderComponent header;

    public BasePage base() {
        if (basePage == null)
            basePage = new BasePage(driver, wait, logger);
        return basePage;
    }

    public LoginPage loginPage() {
        if (loginPage == null)
            loginPage = new LoginPage(driver, wait, logger);
        return loginPage;
    }

    public HeaderComponent header() {
        if (header == null)
            header = new HeaderComponent(driver, wait, logger);
        return header;
    }

    //UTILITY METHODS
    public void openPage(String URL) {
        logger.info("Opening the page " + URL);
        driver.get(URL);
    }

    public void Sleep(int seconds) {
        logger.info("Thread sleep for " + seconds + " seconds");
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception ex) {
            System.err.println(ex.toString());
            ex.printStackTrace();
        }
    }

    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public void SwitchToWindowWithTitle(String expectedTitle) {
        logger.info("Switching to tab: " + expectedTitle);
        String firstWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String allWindow : allWindows) {
            String windowHandle = allWindow.toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (driver.getTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }
}
