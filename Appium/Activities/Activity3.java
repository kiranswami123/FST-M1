package Activities;


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

public class Activity3 {
        AndroidDriver driver;
        WebDriverWait wait;
    private Object Dimension;

    @BeforeMethod
        public void browserSetUp() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.miui.calculator");
            options.setAppActivity(".cal.CalculatorActivity");
            options.noReset();
            URL serverURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(serverURL, options);
            System.out.println("Browser opened");
        }
    @Test
    public void add() {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("op_add")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        // Perform Calculation
        driver.findElement(AppiumBy.id("eq")).click();

        // Display Result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println(result);
        Assert.assertEquals(result, "14");
    }
    //Subtraction
    @Test
    public void Subtraction() {
        driver.findElement(AppiumBy.id("digit_1")).click();
        WebElement digit0 = driver.findElement(AppiumBy.id("digit_0"));
        driver.findElement(AppiumBy.accessibilityId("Subtract")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("eq")).click();
        String result = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("result"))).getText();
        System.out.println("Subtraction of 5 from 10: " + result);
        Assert.assertEquals(result, "5");
    }
    @Test
    public void multiply() {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("op_mul")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        // Perform Calculation
        driver.findElement(AppiumBy.id("eq")).click();

        // Display Result
        String result = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("result"))).getText();
        System.out.println(result);
        Assert.assertEquals(result, "500");
    }
    @Test
    public void divide() {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("op_div")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        // Perform Calculation
        driver.findElement(AppiumBy.id("eq")).click();

        // Display Result
        String result = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("result"))).getText();
        System.out.println(result);
        Assert.assertEquals(result, "25");
    }
      @AfterMethod
        public void closeBrowser(){
            driver.quit();
            System.out.println("Browser Closed");
        }
    }


