package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Goal7 {
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
        driver.findElement(By.xpath("//A[@id='grouptab_0']")).click();
        driver.findElement(By.xpath("//A[@id='moduleTab_9_Leads']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[@title='Additional Details']")));
        driver.findElement(By.xpath("//SPAN[@title='Additional Details']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-id-5\"]/span")));
        String phnNumber = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span")).getText();
        System.out.println("phone number" + phnNumber);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        System.out.println("Browser Closed");
    }
}
