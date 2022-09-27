package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Activity1 {
        AndroidDriver driver;
        WebDriverWait wait;
        private Object Dimension;

        @BeforeMethod
        public void browserSetUp() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.google.android.apps.tasks");
            options.setAppActivity(".ui.TaskListsActivity");
            options.noReset();
            URL serverURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(serverURL, options);
            System.out.println("Browser opened");
        }
        @Test
        public void createGoogleTasks() throws Exception {
            googleTask("Complete Activity with Google Tasks");
            googleTask("Complete Activity with Google Keep");
            googleTask("Complete the second Activity Google Keep");
            Thread.sleep(2000);
            List<WebElement> taskList = (List<WebElement>) driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Mark as complete\"])"));
            System.out.println("No of tasks added: "+taskList.size());
            Assert.assertEquals(taskList.size(),3);
        }
        @Test
        public void googleTask(String task) throws Exception {

            // Wait for elements to load and click on it
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("description(\"Create new task\")"))).click();
            Thread.sleep(2000);
            // Locating Add Task Button Locator and send text
            String addTaskLocator = "resourceId(\"com.google.android.apps.tasks:id/add_task_title\")";
            driver.findElement(AppiumBy.androidUIAutomator(addTaskLocator)).sendKeys(task);
            // wait and click the save button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")"))).click();
        }
        @AfterMethod
        public void closeBrowser(){
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
