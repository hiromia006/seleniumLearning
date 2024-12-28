package selenium.thirdclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/droppable");

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("draggable"));

        actions.moveToElement(element).perform();
        actions.dragAndDrop(element, driver.findElement(By.id("droppable")))
                .perform();
        Thread.sleep(2000);

        actions.contextClick(element).perform();
        Thread.sleep(3000);
        driver.findElement(By.tagName("body")).click();

        actions.doubleClick(driver.findElement(By.id("droppableExample-tab-accept"))).perform();
        Thread.sleep(3000);


        driver.quit();
    }
}
