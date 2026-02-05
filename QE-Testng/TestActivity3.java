package demos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity3 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://training-support.net/webelements/login-form/");
    }

    @Test
    public void loginTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        System.out.println("Entered username and password");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        String confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main/div/div/div/div/div/h1"))).getText();
        System.out.println("Confirmation Message:");
        System.out.println(confirmationMessage);
        Assert.assertEquals(confirmationMessage, "Login Success!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}