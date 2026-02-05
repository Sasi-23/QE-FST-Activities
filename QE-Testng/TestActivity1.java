package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TestActivity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://training-support.net");
    }

    @Test
    public void testPageTitleAndAboutUs(){
        String homeTitle = driver.getTitle();
        System.out.println("Home Pge Title: " + homeTitle);
        Assert.assertEquals(homeTitle, "Training Support");
        driver.findElement(By.linkText("About Us")).click();
        String aboutTitle = driver.getTitle();
        System.out.println("About Us Page title: " + aboutTitle);
        Assert.assertEquals(aboutTitle, "About Training Support");
        }

        @AfterClass
        public void tearDown(){
            driver.close();
        }

}
