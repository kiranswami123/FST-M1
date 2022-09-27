package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Goal4 {
    WebDriver driver;
    @BeforeMethod
    public void browserSetUp() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        System.out.println("Browser Opened");
    }
    @Test
    public void homePage(){
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.name("Login")).click();
        System.out.println("New page title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "SuiteCRM");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
        System.out.println("Browser Closed");
    }
}
