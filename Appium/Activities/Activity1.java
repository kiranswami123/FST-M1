package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        //desired capabilities
        UiAutomator2Options options =new UiAutomator2Options();
        options.setDeviceName("8fac4cad");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.oneplus.calculator");
        options.setAppActivity(".Calculator");
        options.noReset();

        //server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //driver initialization
        driver=new AndroidDriver(serverURL,options);

    }

    @Test
    public void calcTest(){
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("op_mul")).click();
        driver.findElement(AppiumBy.id("digit_6")).click();
        driver.findElement(AppiumBy.id("eq")).click();
        String result=driver.findElement(AppiumBy.id("result")).getText();
        System.out.println(result);

        //Assertions
        Assert.assertEquals(result,"30");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
