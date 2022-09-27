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

public class Goal5 {
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
        WebElement t = driver.findElement(By.xpath("//DIV[@id='toolbar']"));
        String s = t.getCssValue("color");
        String c = Color.fromString(s).asHex();
        System.out.println("Color is :" + s);
        System.out.println("Hex code for color:" + c);
        Assert.assertEquals(c,"#534d64");

    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        System.out.println("Browser Closed");
    }
}
