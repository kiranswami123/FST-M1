package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Goal6 {
    WebDriver driver;
    @BeforeMethod
    public void browserSetUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://alchemy.hguy.co/crm");
        System.out.println("Browser Opened");
    }
    @Test
    public void homePage(){
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.name("Login")).click();
        System.out.println("New page title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "SuiteCRM");
        WebElement activity = driver.findElement(By.xpath("//A[@id='grouptab_3']"));
        if(activity.isDisplayed()){
            activity.click();
        }
        else{
            System.out.println("Activities is not present in menu list");
        }
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        System.out.println("Browser Closed");
    }
}
