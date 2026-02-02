package demos;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
public class HelloSelenium {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net");
        System.out.println(driver.getTitle());
        driver.quit();
        
    }

}
