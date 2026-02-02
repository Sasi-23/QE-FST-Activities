package demos;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.Random;

public class Activity15 {
    
    static String randText(int n) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            sb.append(chars.charAt(r.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://training-support.net/webelements/dynamic-attributes");
        System.out.println("Page Title: " + driver.getTitle());

        //String name = randText(6);
        String name = "Sasi";
        String email = randText(6) + "@test.com";
        String password = randText(6) + "@1";
        String details = randText(10);
        String dateValue = "2026-02-01"; 

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@id,'full-name')]")
        )).sendKeys(name);

        driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='signInForm']/input[3]")).sendKeys(password);
        driver.findElement(By.xpath("//textarea[contains(@id,'additional-details')]")).sendKeys(details);

        WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1];", dateField, dateValue
        );

        driver.findElement(By.xpath("//*[@id='signInForm']/button")).click();

        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='action-confirmation']")
        ));
        System.out.println("Success Message: " + success.getText());

        driver.quit();
    }
}

