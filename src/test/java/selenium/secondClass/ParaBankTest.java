package selenium.secondClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class ParaBankTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://parabank.parasoft.com/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        WebElement webElement = driver.findElement(By.linkText("Register"));
        webElement.click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("t login i")).click();
        Thread.sleep(2000);
//        driver.findElement(By.id("login-button")).click();
//        Thread.sleep(2000);


        WebElement element = driver.findElement(By.cssSelector("input.button"));

        String fontName = element.getCssValue("font");
        String fontSize = element.getCssValue("font-size");
        String fontFamily = element.getCssValue("font-family");
        System.out.println("fontName : " + fontName + " fontSize: " + fontSize + " fontFamily: " + fontFamily);

        System.out.println("=============================================");
        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement w : elements) {
            System.out.println(w.getText() + " " + w.getDomAttribute("href"));
        }

        driver.quit();
    }
}
