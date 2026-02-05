package demos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestActivity7 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void loadPage() {
        driver.get("https://training-support.net/webelements/login-form");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
    }

    @DataProvider(name = "Authentication")
    public Object[][] credentials() {
        return new Object[][] {
                { "admin", "password" },
                { "invalid", "invalid123" }
        };
    }

    @Test(dataProvider = "Authentication")
    public void loginTest(String username, String password) {

        WebElement usernameField =driver.findElement(By.xpath("//*[@id='username']"));

        WebElement passwordField =driver.findElement(By.xpath("//*[@id='password']"));

        WebElement submitButton =driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button"));

        usernameField.clear();
        passwordField.clear();

        System.out.println("Login attempt:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        submitButton.click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}