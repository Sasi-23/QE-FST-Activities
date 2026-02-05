package stepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class Activity2Steps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("user is on the login pages")
    public void the_user_is_on_the_login_page() {
        driver.get("https://training-support.net/webelements/login-form");
    }

    @When("user enters username and password")
    public void the_user_enters_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
    }

    @And("click submit button")
    public void clicks_the_submit_button() {
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    @Then("get the confirmation message and verify it")
    public void get_the_confirmation_message_and_verify_it() {

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/main/div/div/div/div/div/h2")
                )
        );

        String actualMessage = message.getText();
        System.out.println("Confirmation Message: " + actualMessage);

        Assertions.assertTrue(
                actualMessage.toLowerCase().contains("welcome"),
                "Login confirmation message not displayed"
        );
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}