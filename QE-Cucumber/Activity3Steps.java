package stepDefinitions;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity3Steps extends Base{
    private Alert alert;

    @Given("User is on the page")
    public void UserOnPage(){
        driver.get("https://training-support.net/webelements/alerts");
        System.out.println(driver.getTitle());
    }

    @When("User clicks on the simple alert button")
    public void SimpleAlertButton(){
        WebElement simple=driver.findElement(By.id("simple"));
        simple.click();
    }

    @When("User clicks on the Confirm Alert Button")
    public void ConfirmAlertButton(){
        WebElement confirm=driver.findElement(By.id("confirmation"));
        confirm.click();
    }

    @When("User clicks on the Prompt Alert Button")
    public void PromptAlertButton(){
        WebElement prompt=driver.findElement(By.id("prompt"));
        prompt.click();
    }
    @Then("Alert opens")
    public void AlertOpens(){
        alert=driver.switchTo().alert();
    }
    @And("Read the text from it and print it")
    public void ReadText(){
        System.out.println("Alert Test is:"+alert.getText());
    }
    @And("Write a custom message in it")
    public void CustomMessage(){
        alert.sendKeys("Hello Prompt");
    }
    @And("Close the alert")
    public void AcceptAlert(){
        alert.accept();
    }
    @And("Close the alert with cancel")
    public void CancelAlert(){
        alert.dismiss();
    }
    @And("Read the result text")
    public void ReadResult(){
        WebElement result=driver.findElement(By.id("result"));
        System.out.println("Result is:"+result.getText());
    }
}