package selenium.secondClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WindowTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/browser-windows");

        System.out.println("Before " + driver.findElement(By.className("text-center")).getText());

        String originalWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://demoqa.com/sample");
        System.out.println("Window " + driver.findElement(By.id("sampleHeading")).getText());
        Thread.sleep(2500);
        driver.close();
        driver.switchTo().window(originalWindow);
        Thread.sleep(1500);

        System.out.println("After " + driver.findElement(By.className("text-center")).getText());

        driver.quit();
    }
}
