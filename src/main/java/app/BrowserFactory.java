package app;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger logger;

    public BrowserFactory(String browser, Logger logger) {
        this.browser = browser.toLowerCase();
        this.logger = logger;
    }

    public WebDriver CreateDriver() {
        logger.info("Creating local " + browser + " driver");
        switch (browser) {
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                //ChromeOptions chromeOpts = new ChromeOptions();
                //chromeOpts.addArguments("--start-maximized");
                driver.set(new ChromeDriver(/*chromeOpts*/));
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver.set(new FirefoxDriver());
                break;
        }
        return driver.get();
    }
}
