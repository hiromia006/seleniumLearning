package selenium.secondClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NavigationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        WebDriver.Navigation navigation = driver.navigate();
        navigation.to("https://www.saucedemo.com/");
        Thread.sleep(1500);
        navigation.back();
        Thread.sleep(1500);
        navigation.forward();
        Thread.sleep(1500);
        navigation.refresh();
        Thread.sleep(1500);

        driver.quit();
    }
}
