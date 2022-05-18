package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    //Driver declaration
    WebDriver driver;

    @Test
    public void homepageTest(){
        //Get page title
        String title= driver.getTitle();
        System.out.println(title);

        //Assertion
        Assert.assertEquals(title,"Training Support");

        //find aboutus button and click it
        WebElement button= driver.findElement(By.id("about-link"));

        button.click();

        //get new page title
        String newtitle= driver.getTitle();
        System.out.println(newtitle);

        //assert new page title
        Assert.assertEquals(newtitle,"About Training Support");

    }

    @BeforeMethod
    public void setup(){
        //Driver Initialization
        driver= new FirefoxDriver();
        //Open Browser
        driver.get("https://www.training-support.net/");

    }

    @AfterMethod
    public void tearDown(){
        //Close Browser
        driver.quit();

    }


}
