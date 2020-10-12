package tests;

import app.TestFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestFactory {

    @BeforeTest
    public void closeCookiePopup() {
        driver.get("https://www.for-me-online.de/");
        pageFactory().waitForElementIsVisible(By.cssSelector("#onetrust-accept-btn-handler"));
        pageFactory().Sleep(2);//used to avoid JavaScript animation
        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
        pageFactory().waitForElementInvisible(By.cssSelector("#onetrust-accept-btn-handler"));
    }

    @Test
    public void loginWithValidCredentials() {
        //Arrange
        driver.get("https://www.for-me-online.de/");
        driver.findElement(By.cssSelector("a.header-account__login-link")).click();
        //Act
        loginPage().login("gefgertest@yopmail.com", "Geftest123");
        pageFactory().waitForElementIsVisible(By.cssSelector(".header-account__profile-link"));
        //Assert
        Assert.assertTrue(driver.getCurrentUrl().contains("login-successful"));
        Assert.assertTrue(driver.findElement(By.cssSelector(".header-account__profile-link")).isDisplayed());
    }
}
