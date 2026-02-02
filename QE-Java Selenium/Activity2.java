package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class Activity2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/login-form");

        System.out.println(driver.getTitle());

        driver.findElement(By.id("username")).sendKeys("admin");
        
        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.cssSelector("body > div > main > div > div > div > div > div.mx-auto.my-5.flex.flex-col.justify-center.align-middle > form > button"));
        driver.quit();
    }
}
