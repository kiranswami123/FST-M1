import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Activity10_3 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://training-support.net/selenium/drag-drop");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(ball, dropzone1).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone1,"background-color"));
        System.out.println("ENTERED DROPZONE 1");

        builder.dragAndDrop(ball, dropzone2).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone2,"background-color"));
        System.out.println("ENTERED DROPZONE 2");

        driver.quit();

    }
}