package testng.firstClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassTest extends BaseClassTest{
    @Test(priority = 0)
    public void verifySauceDemoTittle() {
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

    }

    @Test(priority = 1)
    public void checkSauceDemoUrl() {
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

    }

    @Test(priority = 2)
    public void checkLoginBtnText() {
        driver.get("https://www.saucedemo.com/");
        String loginBtnText = driver.findElement(By.id("login-button")).getAttribute("value");
        Assert.assertEquals(loginBtnText, "Login");

    }

    @Test(priority = 3)
    public void verifyLogin() {
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

    }

    @Test(priority = 4)
    public void checkRegisterMandatoryField() {

        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        driver.findElement(By.cssSelector("input[value='Register']")).click();

        String requiredTxt = driver.findElement(By.id("customer.firstName.errors")).getText().trim();
        Assert.assertEquals(requiredTxt, "First name is required.");


        Assert.assertTrue(driver.findElement(By.id("customer.lastName.errors")).isDisplayed());

        int errorCount = driver.findElements(By.className("error")).size();
        Assert.assertEquals(errorCount, 10);

    }
}
