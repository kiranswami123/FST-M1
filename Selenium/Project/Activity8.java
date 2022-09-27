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
import java.util.List;

public class Goal8 {
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
        driver.findElement(By.xpath("//A[@id='moduleTab_9_Accounts']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table")));
        WebElement Table = driver.findElement(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table"));
        int rowNum = driver.findElements(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr")).size();
        System.out.println("number of rows " + rowNum);
        List<WebElement> rowVals = Table.findElements(By.tagName("tr"));
        System.out.println("odd numbered rows : ");
        for(int i=1; i<10; i++){
           if(i%2 !=0){
                String name = driver.findElement(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[" + i + "]/td[3]/b/a")).getText();
                System.out.println(name);
            }
        }




    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        System.out.println("Browser Closed");
    }
}
