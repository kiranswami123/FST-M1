import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        String title= driver.getTitle();
        System.out.println("Page title is: " + title);

        WebElement firstname= driver.findElement(By.id("firstName"));
        WebElement lastname= driver.findElement(By.id("lastName"));
        WebElement email= driver.findElement(By.id("email"));
        WebElement contactno= driver.findElement(By.id("number"));
        WebElement submit= driver.findElement(By.cssSelector(".ui.green.button"));

        firstname.sendKeys("Kiran");
        lastname.sendKeys("Swami");
        email.sendKeys("kiranswami@in.ibm.com");
        contactno.sendKeys("7756808496");

        submit.click();
        System.out.println("Form submitted successfully");

        driver.quit();

    }
}
