package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1Steps extends Base {
    @Given("user is on the TS homepage")
    public void userOnTsHomePage(){
        driver.get("https://training-support.net");
        Assertions.assertEquals("Training Support",driver.getTitle());
    }
    @When("user clicks on the About Us link")
    public void clickOnAboutUsButton(){
        driver.findElement(By.linkText("About Us")).click();
    }
    @Then("they should be redirected to the about us page")
    public void shouldBeOnAboutPage(){
        wait.until(ExpectedConditions.titleIs("About Training Support"));
        System.out.println("The new page title is: "+driver.getTitle());
        Assertions.assertEquals("About Training Support",driver.getTitle());
    }

}