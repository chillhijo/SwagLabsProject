package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.io.File;
import java.io.IOException;
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

    public void loginStandardUser(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if ("standard_user".equals(user)){
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            System.out.println("User is logged in as Standard User.");
        }
        else {
            System.out.println("Test failed! Standard user not logged in.");
        }
    }

    public void loginLockedOutUser(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if ("locked_out_user".equals(user)){
            driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            System.out.println("Locked out user tried to login.");
        }
        else {
            System.out.println("Test failed!");
        }
    }

    public void loginProblemUser(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if ("problem_user".equals(user)){
            driver.findElement(By.id("user-name")).sendKeys("problem_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            System.out.println("User is logged in as Problem user.");
        }
        else {
            System.out.println("Test failed! Problem user not logged in.");
        }
    }

    public void loginPerformanceGlitchUser(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if ("performance_glitch_user".equals(user)){
            driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            System.out.println("User is logged in as Performance glitch user.");
        }
        else {
            System.out.println("Test failed! Performance glitch user not logged in.");
        }
    }

    public void takeAScreenShot() throws IOException {
        WebElement errorMessageElement = driver.findElement(By.className("error-message-container"));
        File source = errorMessageElement.getScreenshotAs(OutputType.FILE);
        File destination = new File("resources/screenshots/Error Message Element.png");
        FileHandler.copy(source,destination);
    }

    public void takeFullScreenPageScreenShot() throws IOException {
        WebElement errorMessageElement = driver.findElement(By.id("root"));
        File source = errorMessageElement.getScreenshotAs(OutputType.FILE);
        File destination = new File("resources/screenshots/Full Page.png");
        FileHandler.copy(source,destination);
    }

    public void verifyLockedOutUserErrorMessages() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
        wait.until(ExpectedConditions.visibilityOf(errorMessageContainer));
        Assert.assertEquals(errorMessageContainer.getText(), "Epic sadface: Sorry, this user has been locked out.", "Error message do not match!");
    }

}
