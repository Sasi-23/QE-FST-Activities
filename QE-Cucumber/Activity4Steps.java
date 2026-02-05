package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity4Steps {

    WebDriver driver;
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        driver.get("https://training-support.net/webelements/login-form");
    }
    @When("the user enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("clicks the submit button")
    public void clicksSubmitButton() {
        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button")).click();
    }

    @Then("get the confirmation text and verify message as {string}")
    public void verifyConfirmationMessage(String expectedMessage) {
        String actualText = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h2")).getText();
        System.out.println("Confirmation Message: " + actualText);

        Assertions.assertEquals(actualText, expectedMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
