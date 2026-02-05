package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TestActivity2 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice");
    }

    @Test
    public void testPageTitle(){
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "Selenium: Target Practice");
    }

    @Test
    public void testBlackButtonFail(){
        driver.findElement(By.id("black"));
        Assert.assertEquals(false, "This assertion is intentionally incorrect");
    }

    @Test(enabled = false)
    public void testSkippedDisabled(){
        System.out.println("This test is disabled");
    }

    @Test
    public void testSkippedUsingException(){
        throw new SkipException("Skipping this test using SkipException");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
