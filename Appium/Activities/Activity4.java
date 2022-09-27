package Activities;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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

public class Activity4 {
        AndroidDriver driver;
        WebDriverWait wait;
    private Object Dimension;

    @BeforeMethod
        public void browserSetUp() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.google.android.contacts");
            options.setAppActivity("com.android.contacts.activities.PeopleActivity");
            options.noReset();
            URL serverURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(serverURL, options);
            System.out.println("Browser opened");
        }
    @Test
    public void addContact(){

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.contacts:id/floating_action_button")));

        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Create contact']")));

        driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
        driver.findElement(By.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
        driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");

        driver.findElement(AppiumBy.id("com.google.android.contacts:id/toolbar_button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("/hierarchy/android.widget.Toast")));

        WebElement contactName = driver.findElement(By.id("com.google.android.contacts:id/large_title"));
        System.out.println("Contact name displayed is:   "+contactName.getText());
        Assert.assertEquals(contactName.getText(),"Aaditya Varma","Name doesn't match");
    }
        @AfterMethod
        public void closeBrowser(){
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
