package demos;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class Activity13 {
    public static void main(String[] args) {

        WebDriver d = new FirefoxDriver();
        WebDriverWait w = new WebDriverWait(d, Duration.ofSeconds(10));

        d.get("https://training-support.net/webelements/tables");
        System.out.println(d.getTitle());

        WebElement tb = w.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody")));

        var rows = tb.findElements(By.tagName("tr"));
        var cols = rows.get(0).findElements(By.tagName("td"));
        System.out.println("Rows: " + rows.size() + " Columns: " + cols.size());

        for (WebElement c : w.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[3]")
        )).findElements(By.tagName("td")))
            System.out.println(c.getText());

        System.out.println("R2C2: " + d.findElement(By.xpath(
                "/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]"
        )).getText());

        d.quit();
    }
}

