package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;

public class TestFactory {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageFactory pageFactory;
    public LoginPage loginPage;

    @Parameters({ "browser" })
    @BeforeTest
    public void SetUp(@Optional("chrome") String browser) {

        BrowserFactory factory = new BrowserFactory(browser);
        driver = factory.CreateDriver();

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);

    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }

    //PAGES
    public PageFactory pageFactory() {
        if (pageFactory == null)
            pageFactory = new PageFactory(driver, wait);
        return pageFactory;
    }

    public LoginPage loginPage() {
        if (loginPage == null)
            loginPage = new LoginPage(driver, wait);
        return loginPage;
    }
}
