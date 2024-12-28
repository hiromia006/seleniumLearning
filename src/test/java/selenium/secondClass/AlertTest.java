package selenium.secondClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/alerts");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        //Simple alert
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(1500);
        driver.switchTo().alert().accept();
        Thread.sleep(1500);

        // Confirm Alert
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(1500);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1500);

        //Prompt Alert
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(1500);
        Alert alert1=driver.switchTo().alert();
        Thread.sleep(1500);
        alert1.sendKeys("Prompt Alert");
        Thread.sleep(1500);
        System.out.println(alert1.getText());
        alert1.accept();
        Thread.sleep(1500);

        driver.quit();
    }
}
