package tests;

import app.Utility;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends Utility {

    @Test
    public void loginWithValidCreds() {
        //Arrange
        openPage("https://www.for-me-online.de/anmelden");

        //Act
        loginPage().login("gefdetest@yopmail.com", "Meganom2013");

        //Assert
        header().waitUntilUserIsLoggedIn();
        Assert.assertTrue(header().isUserLoggedIn());
    }

    @Test
    public void loginWithEmptyFields() {
        openPage("https://www.for-me-online.de/anmelden");
        loginPage().login("", "");
        Assert.assertFalse(header().isUserLoggedIn());
        Assert.assertTrue(loginPage().areValidationErrorsDisplayed());
    }
}
