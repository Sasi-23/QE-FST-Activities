package demos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;

public class Activity18 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/alerts");
        driver.manage().window().maximize();

        System.out.println("Page Title: " + driver.getTitle());

        driver.findElement(By.xpath("//*[@id='simple']")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());

        alert.accept();

        Thread.sleep(2000);
        driver.quit();
    }
}