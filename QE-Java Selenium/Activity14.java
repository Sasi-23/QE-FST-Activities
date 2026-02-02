package demos;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class Activity14 {
    public static void main(String[] args) {

        // 1. Open browser
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 2. Open page
        driver.get("https://training-support.net/webelements/tables");

        // 3. Print page title
        System.out.println("Page Title: " + driver.getTitle());

        // 4. Locate table body and count rows & columns
        WebElement tbody = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody")
        ));

        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        List<WebElement> cols = rows.get(0).findElements(By.tagName("td"));

        System.out.println("Number of Rows: " + rows.size());
        System.out.println("Number of Columns: " + cols.size());

        // 5. Book name in 5th row BEFORE sorting
        String bookBefore = driver.findElement(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[5]/td[2]")
        ).getText();
        System.out.println("Book name in 5th row before sorting: " + bookBefore);

        // 6. Click Price column header to sort (ascending)
        WebElement priceHeader = driver.findElement(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/thead/tr/th[5]")
        );
        System.out.println("Sorting by column: " + priceHeader.getText());
        priceHeader.click();

        // 7. Print ALL prices in ascending order
        System.out.println("Prices in ascending order:");
        List<WebElement> prices = driver.findElements(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr/td[5]")
        );

        for (WebElement price : prices) {
            System.out.println(price.getText());
        }

        // 8. Book name in 5th row AFTER sorting
        String bookAfter = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[5]/td[2]")
        )).getText();
        System.out.println("Book name in 5th row after sorting: " + bookAfter);

        // 9. Close browser
        driver.quit();
    }
}
