package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Goal3 {
    WebDriver driver;
    @BeforeMethod
    public void browserSetUp() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        System.out.println("Browser Opened");
    }
    @Test
    public void  firstCopyrightText(){
        String actText = driver.findElement(By.xpath("//A[@id='admin_options']")).getText();
        System.out.println("act first Copyright Text :"+ actText);
        String expText = "© Supercharged by SuiteCRM";
        Assert.assertEquals(expText,actText);

    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
        System.out.println("Browser Closed");
    }
}
