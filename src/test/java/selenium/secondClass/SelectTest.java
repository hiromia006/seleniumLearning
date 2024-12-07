package selenium.secondClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        Select sel = new Select(driver.findElement(By.cssSelector("select[name='country']")));
        sel.selectByIndex(1);
        Thread.sleep(1500);

        sel.selectByVisibleText("ALBANIA");
        Thread.sleep(1500);

        sel.selectByValue("ANGOLA");
        Thread.sleep(1500);
        sel.selectByContainsVisibleText("AND CARTIER ISL");
        Thread.sleep(1500);

        List<WebElement> list = sel.getOptions();
        for (WebElement element : list) {
            System.out.println(element.getText() + " Value : " + element.getDomAttribute("value"));
        }


        driver.quit();
    }
}
