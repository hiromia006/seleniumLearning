package testng.firstClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoTest {
    @Test
    public void verifySauceDemoTittle() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/");

        Assert.assertEquals(driver.getTitle(), "Swag Labs");

        driver.quit();
    }

    @Test
    public void checkSauceDemoUrl() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        driver.quit();
    }

    @Test
    public void checkLoginBtnText() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/");

        String loginBtnText = driver.findElement(By.id("login-button")).getAttribute("value");
        Assert.assertEquals(loginBtnText, "Login");

        driver.quit();
    }

    @Test
    public void verifyLogin() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        String loginBtnText = loginBtn.getAttribute("value");

        Assert.assertEquals(loginBtnText, "Login");

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        loginBtn.click();

        WebElement errorEl = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String errorText = errorEl.getText().trim();

        Assert.assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");

        Assert.assertTrue(errorEl.isDisplayed());


        driver.quit();
    }

    @Test
    public void checkRegisterMandatoryField() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        driver.findElement(By.cssSelector("input[value='Register']")).click();

        String requiredTxt = driver.findElement(By.id("customer.firstName.errors")).getText().trim();
        Assert.assertEquals(requiredTxt, "First name is required.");


        Assert.assertTrue(driver.findElement(By.id("customer.lastName.errors")).isDisplayed());

        int errorCount = driver.findElements(By.className("error")).size();
        Assert.assertEquals(errorCount, 10);


        driver.quit();
    }
}
