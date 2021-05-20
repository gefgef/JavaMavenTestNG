package app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class TestFactory {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;

    @Parameters({ "browser" })
    @BeforeTest
    public void SetUp(@Optional("chrome") String browser, ITestContext context) {
        String testName = context.getCurrentXmlTest().getName();
        logger = LogManager.getLogger(testName);
        logger.info("Starting the test " + testName);

        BrowserFactory factory = new BrowserFactory(browser, logger);
        driver = factory.CreateDriver();
        //BrowserStack browserStack = new BrowserStack(logger);
        //driver = browserStack.CreateDriver();

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
        logger.info("Driver closed.");
    }
}
