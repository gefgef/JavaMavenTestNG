package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;

public class TestFactory {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageFactory pageFactory;
    public LoginPage loginPage;

    @BeforeTest
    public void SetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
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
