package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity5 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println("Title: " + driver.getTitle());

        System.out.println("Checkbox displayed (before): " +
                driver.findElement(By.xpath("//*[@id='checkbox']")).isDisplayed());

        driver.findElement(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/section[1]/button")
        ).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//*[@id='checkbox']")));

        System.out.println("Checkbox displayed (after): False");

        driver.quit();
    }
}
