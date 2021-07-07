package tests;

import app.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.management.OperatingSystemMXBean;

public class InternetHerokuappTests extends Utility {

    @Test
    public void checkCheckbox() {
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

    @Test
    public void clickAlert() {
        openPage("http://the-internet.herokuapp.com/javascript_alerts");
        base().click(driver.findElement(By.cssSelector(".example li:first-of-type button")));
        base().waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.cssSelector("#result")).getText(), "You successfully clicked an alert");
    }

    @Test
    public void switchToNewWindow() {
        openPage("http://the-internet.herokuapp.com/windows");
        base().click(driver.findElement(By.cssSelector("div#content a")));
        SwitchToWindowWithTitle("New Window");
        Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "New Window");
    }

    @Test
    public void switchToIFrame() {
        openPage("https://the-internet.herokuapp.com/tinymce");
        driver.switchTo().frame(driver.findElement(By.cssSelector("#mce_0_ifr")));
        Assert.assertEquals(driver.findElement(By.cssSelector("#tinymce p")).getText(), "Your content goes here.");
    }

    @Test
    public void pressKey() {
        openPage("https://the-internet.herokuapp.com/key_presses");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.SPACE).build().perform();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("SPACE"));
    }

    @Test
    public void uploadFile() {
        openPage("https://the-internet.herokuapp.com/upload");
        String fileName = "bugs.jpg";
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\" + fileName;
        base().type(driver.findElement(By.id("file-upload")), filePath);
        base().click(By.id("file-submit"));
        Sleep(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("#content h3")).getText().equals("File Uploaded!"));
        Assert.assertTrue(driver.findElement(By.id("uploaded-files")).getText().equals(fileName));
    }
}