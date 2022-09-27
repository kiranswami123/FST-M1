package Activities;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
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

public class Activity6 {
        AndroidDriver driver;
        WebDriverWait wait;
    private Object Dimension;

    @BeforeMethod
        public void browserSetUp() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.android.chrome");
            options.setAppActivity("com.google.android.apps.chrome.Main");
            options.noReset();
            URL serverURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(serverURL, options);
            System.out.println("Browser opened");
        }
    @Test
    public void chromeTest(){


        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Elements that take time to appear!']")));
        String title = driver.findElement(AppiumBy.xpath("(//android.widget.TextView)[2]")).getText();

        //String title = driver.getTitle();
        System.out.println("Landing screen heading:   "+title);
        Assert.assertEquals(title, "Lazy Loading");

        //Count Images
        List<WebElement> imagesCount = driver.findElements(By.xpath("//android.view.View/android.view.View/android.widget.Image"));
        System.out.println("Number of images before helen's post: " +imagesCount.size());

        // Assertion before scrolling
        Assert.assertEquals(imagesCount.size(), 2);

        //Scroll till halens post
        String UiScrollable = "new UiScrollable(new UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollIntoView(new UiSelector().text(\"helen\"))"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'helen')]")));

        System.out.println("Number of images after helen's post: " +imagesCount.size());
        // Assertion after scrolling
        Assert.assertEquals(imagesCount.size(), 2);

    }
    @AfterMethod
        public void closeBrowser(){
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
