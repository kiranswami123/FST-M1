import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        WebElement aboutus = driver.findElement(By.xpath("//*[@id=\"about-link\"]"));

        WebElement button = driver.findElement(By.id("about-link"));

        button.click();

        String titlenew = driver.getTitle();
        System.out.println("New Page title is: " + titlenew);

        driver.quit();
    }
}
