package demos;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestAppiumProject {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() throws MalformedURLException, URISyntaxException{
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("android");
    options.setAutomationName("UiAutomator2");
    options.setApp("C:\\Users\\SadineniSasi\\Desktop\\Qe-Fse-Activities\\qe-appium\\src\\test\\resources\\ts-todo-list-v1.apk");
    options.setAppWaitActivity(".view.MainActivity");
    options.setAppWaitForLaunch(true);
    options.setNoReset(true);
    options.setFullReset(false);
    options.setCapability("appium:forceAppLaunch", true);
    options.setCapability("appium:shouldTerminateApp", true);


    URL serverURL = new URI("http://127.0.0.1:4723").toURL();

    driver = new AndroidDriver(serverURL, options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));


}

  @Test(priority = 1)
   public void addTasksTest() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // ================= TASK 1 =================
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.id("com.app.todolist:id/et_new_task_name")))
            .sendKeys("Activity 1");

    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//android.widget.TextView[@text='High']"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/bt_new_task_ok"))).click();


    // ================= TASK 2 =================
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.id("com.app.todolist:id/et_new_task_name")))
            .sendKeys("Activity 2");

    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//android.widget.TextView[@text='Medium']"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/bt_new_task_ok"))).click();


    // ================= TASK 3 =================
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.id("com.app.todolist:id/et_new_task_name")))
            .sendKeys("Activity 3");

    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//android.widget.TextView[@text='Low']"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/bt_new_task_ok"))).click();


    // ================= ASSERTION =================

    // Wait until at least one task is visible
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")));

    List<WebElement> tasks = driver.findElements(
            AppiumBy.id("com.app.todolist:id/tv_exlv_task_name"));

    System.out.println("Total tasks added: " + tasks.size());

    Assert.assertEquals(tasks.size(), 3,
            "Expected 3 tasks but found " + tasks.size());

}
    @Test(priority = 2)
    public void editTaskSetDeadline() {

    // -------- WAIT FOR FIRST TASK --------
    WebElement firstTask = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_name'])[1]")
            )
    );

    // -------- LONG PRESS --------
    HashMap<String, Object> params = new HashMap<>();
    params.put("elementId", ((RemoteWebElement) firstTask).getId());
    params.put("duration", 2000);
    driver.executeScript("mobile: longClickGesture", params);

    // -------- CLICK EDIT OPTION FROM POPUP --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Edit To-Do Task']")
    )).click();

    // -------- NOW WAIT FOR DEADLINE FIELD --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")
    )).click();

    // -------- SELECT DATE 14 --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.androidUIAutomator("new UiSelector().text(\"14\")")
    )).click();

    // -------- CLICK DEADLINE OK --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/bt_deadline_ok")
    )).click();

    // -------- SAVE EDIT --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/bt_new_task_ok")
    )).click();

    // -------- ASSERT DEADLINE --------
    WebElement deadlineText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_deadline' and @text='Deadline: 14.02.2026']")
            )
    );

    Assert.assertTrue(deadlineText.isDisplayed());
}


    @Test(priority = 3)
    public void markTasksAndVerifyCompleted() {

    // -------- MARK FIRST TASK COMPLETE --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("(//android.widget.CheckBox[@resource-id='com.app.todolist:id/cb_task_done'])[1]")
    )).click();

    // -------- MARK SECOND TASK COMPLETE --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("(//android.widget.CheckBox[@resource-id='com.app.todolist:id/cb_task_done'])[2]")
    )).click();

    // -------- LONG PRESS THIRD TASK --------
    WebElement thirdTask = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_name'])[3]")
            )
    );

    HashMap<String, Object> params = new HashMap<>();
    params.put("elementId", ((RemoteWebElement) thirdTask).getId());
    params.put("duration", 2000);
    driver.executeScript("mobile: longClickGesture", params);

    // -------- CLICK EDIT OPTION --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Edit To-Do Task']")
    )).click();

    // -------- SLIDE PROGRESS BAR TO 50% --------
    WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
        AppiumBy.id("com.app.todolist:id/sb_new_task_progress")
));

    int startX = progressBar.getLocation().getX();
    int width = progressBar.getSize().getWidth();
    int y = progressBar.getLocation().getY() + (progressBar.getSize().getHeight() / 2);

    int moveToX = startX + (width / 2); // 50%

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence slide = new Sequence(finger, 1);

    slide.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
    slide.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    slide.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), moveToX, y));
    slide.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(slide));



    // -------- SAVE TASK --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.app.todolist:id/bt_new_task_ok")
    )).click();

    // -------- CLICK MORE OPTIONS --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.accessibilityId("More options")
    )).click();

    // -------- SELECT COMPLETED TASKS --------
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//android.widget.TextView[@resource-id='com.app.todolist:id/title' and @text='Completed tasks']")
    )).click();

    // -------- ASSERT ONLY 2 TASKS SHOWN --------
    List<WebElement> completedTasks = driver.findElements(
            AppiumBy.id("com.app.todolist:id/cb_task_done")
    );

    Assert.assertEquals(completedTasks.size(), 2);
}


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
