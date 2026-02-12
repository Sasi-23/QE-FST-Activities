package demos;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity4 {
    private AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException{
        UiAutomator2Options options =  new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");
        options.setAppPackage("com.google.android.contacts");
        options.setNoReset(true);
        options.setFullReset(false);
        options.setCapability("appium:forceAppLaunch", true);
        options.setCapability("appium:shouldTerminateApp", true);
        URL serverURL = new URI("http://127.0.0.1:4723").toURL();
        driver =  new AndroidDriver(serverURL,options);



    }
    @Test
    public void addContact(){
        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys("Aaditya");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys("Varma");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]")).sendKeys("999148292");
        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button")).click();
        String name=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.contacts:id/large_title\"]")).getText();
        Assert.assertEquals(name, "Aaditya Varma");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}