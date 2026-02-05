package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestActivity6 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver(); 
        driver.manage().window().maximize();
        driver.get("https://training-support.net/webelements/login-form");
    }

    @Test
@Parameters({ "username", "password" })
public void loginTest(
        @Optional("admin") String username,
        @Optional("password") String password) {

    WebElement usernameField =driver.findElement(By.xpath("//*[@id='username']"));
    WebElement passwordField =driver.findElement(By.xpath("//*[@id='password']"));
    WebElement submitButton =driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button"));

    usernameField.sendKeys(username);
    passwordField.sendKeys(password);

    System.out.println("Username entered: " + username);
    System.out.println("Password entered: " + password);

    submitButton.click();
}
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}