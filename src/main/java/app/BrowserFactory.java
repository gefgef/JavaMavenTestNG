package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    public BrowserFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public WebDriver CreateDriver() {

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
