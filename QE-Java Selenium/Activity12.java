package demos;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class Activity12 {
    public static void main(String[] args) {

        WebDriver d = new FirefoxDriver();
        WebDriverWait w = new WebDriverWait(d, Duration.ofSeconds(10));

        d.get("https://training-support.net/webelements/dynamic-content");
        System.out.println(d.getTitle());

        w.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='genButton']"))).click();

        w.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//*[@id='word']"), "release"));

        System.out.println(d.findElement(By.xpath("//*[@id='word']")).getText());
        d.quit();
    }
}

