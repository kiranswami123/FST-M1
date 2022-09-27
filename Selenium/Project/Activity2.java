package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Goal2 {
    WebDriver driver;
    @BeforeMethod
    public void browserSetUp() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        System.out.println("Browser Opened");
    }
    @Test
    public void  headerImageURL(){
        String actURL = driver.findElement(By.xpath("//IMG[@src='themes/default/images/company_logo.png?v=cK7kLsY0ftg72ZVHTYUT_g']")).getAttribute("src");
        System.out.println("actURL for suite CRM :"+ actURL);
        String expURL = "https://alchemy.hguy.co/crm/themes/default/images/company_logo.png?v=cK7kLsY0ftg72ZVHTYUT_g";
        Assert.assertEquals(expURL,actURL);

    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
        System.out.println("Browser Closed");
    }
}
