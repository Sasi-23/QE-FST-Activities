package demos;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestActivity10 {

    WebDriver driver;
    @DataProvider(name = "ExcelData")
    public Iterator<Object[]> readExcelData() {

        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis =
             new FileInputStream("src/test/resources/Book.xlsx")) {

            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                String fullName = formatter.formatCellValue(row.getCell(0));
                String email    = formatter.formatCellValue(row.getCell(1));
                String date     = formatter.formatCellValue(row.getCell(2));
                String details  = formatter.formatCellValue(row.getCell(3));

                data.add(new Object[] {
                        fullName, email, date, details
                });
            }
            workbook.close();

        } catch (Exception e) {
            throw new RuntimeException("Excel read failed: " + e.getMessage());
        }

        return data.iterator();
    }
    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/simple-form");
    }
       @Test(dataProvider = "ExcelData")
    public void fillSimpleForm(
            String fullName,
            String email,
            String date,
            String details) {

        driver.findElement(By.id("full-name")).sendKeys(fullName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='signInForm']/input[3]")).sendKeys(date);
        driver.findElement(By.id("additional-details")).sendKeys(details);

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement msgElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='action-confirmation']")));
        String confirmationMsg = msgElement.getAttribute("textContent").trim();

        System.out.println("Confirmation Message: " + confirmationMsg);

        Assert.assertTrue(confirmationMsg.length() > 0);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}