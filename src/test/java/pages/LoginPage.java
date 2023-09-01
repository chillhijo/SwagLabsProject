package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.saucedemo.com/");
    }


    //VERIFY METHODS

    public void verifyLoginPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Swag Labs";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println(ActualTitle);

        WebElement loginLogo = driver.findElement(By.className("login_logo"));
        wait.until(ExpectedConditions.visibilityOf(loginLogo));
        Assert.assertEquals(loginLogo.getText(), "Swag Labs", "Header title not matching!");

        WebElement usernameInputBox = driver.findElement(By.id("user-name"));
        wait.until(ExpectedConditions.visibilityOf(loginLogo));
        Assert.assertEquals(usernameInputBox.getAttribute("placeholder"), "Username", "Username placeholder is not matching!");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(loginLogo));
        Assert.assertEquals(passwordInputBox.getAttribute("placeholder"), "Password", "Password placeholder is not matching!");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        wait.until(ExpectedConditions.visibilityOf(loginLogo));
        Assert.assertEquals(loginButton.getAttribute("value"), "Login", "Login button value is not matching!");
    }
}
