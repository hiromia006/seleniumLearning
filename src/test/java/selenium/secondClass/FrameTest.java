package selenium.secondClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FrameTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/frames");

        System.out.println(driver.findElement(By.className("text-center")).getText());
//        System.out.println("sampleHeading " + driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().frame("frame1");
        System.out.println("sampleHeading " + driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();


        driver.quit();
    }
}
