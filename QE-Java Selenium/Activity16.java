package demos;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Activity16 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/selects");

        System.out.println("Page Title: " + driver.getTitle());

        WebElement selectElem = driver.findElement(
            By.xpath("/html/body/div/main/div/div/div/div/section/div[1]/select")
        );

        Select dropdown = new Select(selectElem);

        System.out.println("Dropdown options:");
        for (WebElement option : dropdown.getOptions()) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}

