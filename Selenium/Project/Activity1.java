package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Goal1 {
    WebDriver driver;
    @BeforeMethod
    public void browserSetUp() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        System.out.println("Browser Opened");
    }
    @Test
    public void title(){
        System.out.println("New page title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "SuiteCRM");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
        System.out.println("Browser Closed");
    }
}
Footer
© 2022 GitHub, Inc.
