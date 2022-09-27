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


public class Activity2 {
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
    private void googleNote() throws Exception {

        // Wait for elements to load and click on it
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")"))).click();
        Thread.sleep(2000);
        // Locating Add Task Button Locator and send text
        String addNoteTitleLocator = "resourceId(\"com.google.android.keep:id/editable_title\")";
        driver.findElement(AppiumBy.androidUIAutomator(addNoteTitleLocator)).sendKeys("New Note Title is adding");
        driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"com.google.android.keep:id/edit_note_text\")")).sendKeys("-----New Note is adding----------");
        // wait and click the save button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("description(\"Open navigation drawer\")"))).click();
        Thread.sleep(2000);

        String note = driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"com.google.android.keep:id/index_note_title\")")).getText();

        System.out.println(note);
        Assert.assertEquals(note, "New Note Title is adding");
    }

    @AfterMethod
        public void closeBrowser(){
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
