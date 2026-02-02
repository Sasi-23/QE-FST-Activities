package demos;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class Activity10 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://training-support.net/webelements/drag-drop");

        System.out.println(driver.getTitle());

        WebElement ball = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ball")));
        WebElement dz1  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropzone1")));
        WebElement dz2  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropzone2")));

        Actions a = new Actions(driver);

        a.clickAndHold(ball).moveToElement(dz1).release().perform();
        System.out.println("DZ1: " + dz1.getText());

        a.clickAndHold(ball).moveToElement(dz2).release().perform();
        System.out.println("DZ2: " + dz2.getText());

        driver.quit();
    }
}
