package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity5 {

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();  
        driver.manage().window().maximize();
        driver.get("https://training-support.net/webelements/target-practice/");
    }
    @Test
    public void testPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "Selenium: Target Practice");
    }
   @Test(groups = { "HeaderTests" })
    public void testHeader3Text() {
        WebElement header3 = driver.findElement(By.xpath("//h3"));
        System.out.println("Header 3 Text: " + header3.getText());
        Assert.assertEquals(header3.getText(), "Heading #3");
}


    @Test(groups = { "HeaderTests" })
    public void testHeader5Color() {

        WebElement header5 = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/h5"));
        String color = header5.getCssValue("color");
        System.out.println("Header 5 Color: " + color);
        Assert.assertEquals(color, "rgb(147, 51, 234)");
    }
    @Test(groups = { "ButtonTests" })
    public void testEmeraldButtonText() {

        WebElement emeraldButton = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/button[8]"));
        System.out.println("Emerald Button Text: " + emeraldButton.getText());
        Assert.assertEquals(emeraldButton.getText(), "Emerald");
    }

    @Test(groups = { "ButtonTests" })
    public void testEmeraldButtonColor() {
        WebElement emeraldButton = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/button[8]"));
        String color = emeraldButton.getCssValue("background-color");
        System.out.println("Emerald Button Color: " + color);
        Assert.assertEquals(color, "rgb(167, 243, 208)");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}