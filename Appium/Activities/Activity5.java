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

public class Activity5 {
        AndroidDriver driver;
        WebDriverWait wait;
    private Object Dimension;

    @BeforeMethod
        public void browserSetUp() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.google.android.apps.messaging");
            options.setAppActivity(".ui.ConversationListActivity");
            options.noReset();
            URL serverURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(serverURL, options);
            System.out.println("Browser opened");
        }
    @Test
    public void smsApplicationTest(){

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Start chat")));

        driver.findElement(AppiumBy.accessibilityId("Start chat")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.messaging:id/toolbar")));

        driver.findElement(By.id("com.google.android.apps.messaging:id/recipient_text_view")).sendKeys("8982347545");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Make a video call")));

        driver.findElement(By.xpath("//android.widget.EditText[@text='Text message']")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@text='Hello from Appium'])[2]")));
        WebElement message = driver.findElement(By.xpath("(//android.widget.TextView[@text='Hello from Appium'])[2]"));
        System.out.println("Message displayed is:   "+message.getText());
        Assert.assertEquals(message.getText(),"Hello from Appium","Message doesn't match");
    }
    @AfterMethod
        public void closeBrowser(){
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
