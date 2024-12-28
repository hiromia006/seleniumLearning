package selenium.firstClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CssSelectSelectorTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input[name='user-name']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[data-test='login-button']")).click();

        driver.quit();

    }
}