package demos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver d = new FirefoxDriver();
        d.get("https://training-support.net/webelements/selects");
        System.out.println("Title: " + d.getTitle());

        Select m = new Select(d.findElement(
            By.xpath("/html/body/div/main/div/div/div/div/section/div[2]/select")
        ));

        m.selectByVisibleText("HTML");
        m.selectByIndex(3);
        m.selectByIndex(4);
        m.selectByIndex(5);

        JavascriptExecutor js = (JavascriptExecutor) d;

        js.executeScript("arguments[0].selected=true;",
            d.findElement(By.xpath(
            "/html/body/div/main/div/div/div/div/section/div[2]/select/option[11]"))
        );

        js.executeScript("arguments[0].selected=false;",
            d.findElement(By.xpath(
            "/html/body/div/main/div/div/div/div/section/div[2]/select/option[5]"))
        );

        Thread.sleep(1000);
        d.quit();
    }
}
