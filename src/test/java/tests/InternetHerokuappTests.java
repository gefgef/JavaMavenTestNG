package tests;

import app.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class InternetHerokuappTests extends Utility {

    @Test
    public void checkCheckboxTest() {
        openPage("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.cssSelector("#checkboxes input:first-of-type"));
        base().checkCheckbox(checkbox);
        Assert.assertTrue(checkbox.isSelected());
    }

    @Test
    public void selectValueInDropdown() {
        openPage("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.cssSelector("#dropdown"));
        base().selectByIndex(dropdown, 1);
        Assert.assertEquals(base().getSelectedOptionText(dropdown), "Option 1");
    }
}
