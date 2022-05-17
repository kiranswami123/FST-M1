import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        String title= driver.getTitle();
        System.out.println("Page title is: " + title);

        WebElement firstname= driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        WebElement lastname= driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        WebElement email= driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement contactno= driver.findElement(By.xpath("//*[@id=\"number\"]"));
        WebElement submit= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[1]/input"));

        firstname.sendKeys("Kiran");
        lastname.sendKeys("Swami");
        email.sendKeys("kiranswami@in.ibm.com");
        contactno.sendKeys("7756808496");

        submit.click();
        System.out.println("Form submitted successfully");

        driver.quit();

    }
}

