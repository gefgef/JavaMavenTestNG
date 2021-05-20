package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.apache.logging.log4j.Logger;

public class BrowserStack {

    private WebDriver driver;
    private Logger logger;

    public BrowserStack (Logger logger) {
        this.logger = logger;
    }

    public static final String AUTOMATE_USERNAME = "serhiisolovei1";
    public static final String AUTOMATE_ACCESS_KEY = "E1g4rApkAZStwxRxgasa";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public WebDriver CreateDriver() {
        logger.info("Creating BrowserStack instance...");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        //caps.setCapability("device", "");
        //caps.setCapability("name", ""); // test name
        //caps.setCapability("build", "Test build"); // CI/CD job or build name
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return driver;
    }


}
