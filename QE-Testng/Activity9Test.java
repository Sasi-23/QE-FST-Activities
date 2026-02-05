package demos;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9Test {

    WebDriver driver;

    // Runs once before all test methods
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/alerts");
        Reporter.log("Browser opened and URL launched", true);
    }

    // Runs before every @Test method
    @BeforeMethod
    public void switchToPage() {
        driver.switchTo().defaultContent();
    }

    // Test case for Simple Alert
    @Test
    public void simpleAlertTestCase() {
        driver.findElement(By.id("simple")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);

        Reporter.log("Simple Alert text: " + alertText, true);

        Assert.assertTrue(alertText.contains("simple"), "Simple alert text verified");

        alert.accept(); // Click OK
    }

    // Test case for Confirm Alert
    @Test
    public void confirmAlertTestCase() {
        driver.findElement(By.id("confirmation")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);

        Reporter.log("Confirm Alert text: " + alertText, true);

        Assert.assertTrue(alertText.contains("confirm"), "Confirm alert text verified");

        alert.dismiss(); // Click Cancel
    }

    // Test case for Prompt Alert
    @Test
    public void promptAlertTestCase() {
        driver.findElement(By.id("prompt")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);

        Reporter.log("Prompt Alert text: " + alertText, true);

        alert.sendKeys("Hello TestNG");
        alert.accept(); // Click OK

        Assert.assertTrue(true, "Prompt alert handled successfully");
    }

    // Runs once after all test methods
    @AfterClass
    public void tearDown() {
        driver.close();

        Reporter.log("Browser closed", true);
    }
}