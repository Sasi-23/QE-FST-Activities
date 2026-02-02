package demos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println("Page Title: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String checkboxXPath = "//*[@id='checkbox']";

        String toggleBtnXPath = "/html/body/div/main/div/div/div/div/div[2]/section[1]/button";

        WebElement checkbox = driver.findElement(By.xpath(checkboxXPath));
        System.out.println("Checkbox displayed: " + checkbox.isDisplayed());

        WebElement toggleBtn = driver.findElement(By.xpath(toggleBtnXPath));
        toggleBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(checkboxXPath)));
        System.out.println("Checkbox disappeared");

        toggleBtn.click();

        checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkboxXPath)));

        checkbox.click();
        System.out.println("Checkbox selected");
        
        driver.quit();
    }
}
