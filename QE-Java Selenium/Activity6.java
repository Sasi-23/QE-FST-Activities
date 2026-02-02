package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println("Title: " + driver.getTitle());

        WebElement checkbox = driver.findElement(By.id("checkbox"));

        System.out.println("Checkbox selected (before): " + checkbox.isSelected());

        checkbox.click();

        System.out.println("Checkbox selected (after): " + checkbox.isSelected());

        driver.quit();
    }
}

