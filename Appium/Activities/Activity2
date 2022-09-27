package Activities;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
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
    public void testSearchAppium() {
        driver.get("https://www.training-support.net/");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("About Us")));
        String title = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();

//        String title = driver.getTitle();
        System.out.println("Landing screen heading:   "+title);
        Assert.assertEquals(title, "Training Support");

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='About Us']/android.widget.TextView")).click();

        // Wait for new page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")));
        String aboutUsTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println("Screen heading after About us is clicked:   "+aboutUsTitle);
        Assert.assertEquals(aboutUsTitle, "About Us");

    }

      @AfterMethod
        public void closeBrowser(){
            driver.quit();
            System.out.println("Browser Closed");
        }
    }

