package demos;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class Activity8 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/mouse-events");
        System.out.println("Title: " + driver.getTitle());

        WebElement cargoLock = driver.findElement(By.cssSelector(".file:nth-child(1)"));
        WebElement cargoToml = driver.findElement(By.cssSelector(".file:nth-child(2)"));
        WebElement src = driver.findElement(By.cssSelector(".file:nth-child(3)"));
        WebElement target = driver.findElement(By.cssSelector(".file:nth-child(4)"));

        actions.click(cargoLock).moveToElement(cargoToml).click().perform();
        System.out.println(driver.findElement(By.id("result")).getText());

        actions.doubleClick(src).contextClick(target).perform();

        WebElement open = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.w-full:nth-child(1)")
            )
        );
        open.click();

        System.out.println(driver.findElement(By.id("result")).getText());

        driver.quit();
    }
}
