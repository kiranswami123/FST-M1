package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Activity3 {
        AndroidDriver driver;
        WebDriverWait wait;
        private Object Dimension;

        @BeforeMethod
        public void browserSetUp() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.google.android.keep");
            options.setAppActivity(".activities.BrowseActivity");
            options.noReset();
            URL serverURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(serverURL, options);
            System.out.println("Browser opened");
        }

    @Test
    public void testingTodoList() throws Exception {

        // MobileElement pageTitle =
        // driver.findElementByXPath("//android.view.View[@text='Selenium']");
        // wait.until(ExpectedConditions.textToBePresentInElement(pageTitle,
        // "Selenium"));
        // wait & Scroll to To-Do List
        // wait.until(ExpectedConditions.elementToBeClickable(
        // MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).(\"To-DoList\")"))).click();
        try {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5)"));
        } catch (InvalidSelectorException e) {
            // ignore
        }
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[15]/android.view.View")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")"))).sendKeys("New task");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("textContains(\"Add Task\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("textContains(\"Clear List\")"))).click();

    }
    @AfterMethod
        public void closeBrowser(){
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
