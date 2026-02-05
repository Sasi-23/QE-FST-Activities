package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.junit.jupiter.api.Assertions;
import io.cucumber.java.After;

import java.time.Duration;

public class Activity5Steps {

    static WebDriver driver;
    static WebDriverWait wait;

    @Given("user is on the login page")
    public void the_user_is_on_the_login_page() {

        if (driver == null) {
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }

        driver.get("https://training-support.net/webelements/login-form");
    }

    @When("user enters {string} and {string}")
    public void the_user_enters_username_and_password(String username, String password) {

        WebElement user = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement pass = driver.findElement(By.id("password"));

        user.clear();
        pass.clear();

        user.sendKeys(username);
        pass.sendKeys(password);
    }

    @And("click the submit button")
    public void clicks_the_submit_button() {
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    @Then("gets the confirmation text and verify message as {string}")
    public void verify_confirmation_message(String expectedMessage) {

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[text()='Invalid credentials']")
                )
        );

        String actualMessage = message.getText();
        System.out.println("Confirmation Message: " + actualMessage);

        Assertions.assertTrue(
                actualMessage.contains(expectedMessage),
                "Expected message not displayed"
        );
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser closed successfully");
        }
    }
}