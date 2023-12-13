package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
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


    //WEB ELEMENTS

    @FindBy (className = "login_logo")
    private WebElement loginLogo;

    @FindBy (id = "user-name")
    private WebElement usernameInputBox;

    @FindBy (id = "password")
    private WebElement passwordInputBox;

    @FindBy (id = "login-button")
    private WebElement loginButton;

    @FindBy (xpath = "//div[contains(@class, 'error')]")
    private WebElement errorMessageContainer;
    //VERIFY METHODS

    /*
    verifyLoginPage method is valid but I split it up in multiple methods
    for better performance and better usage
     */
    public void verifyLoginPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Swag Labs";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println(ActualTitle);

        wait.until(ExpectedConditions.visibilityOf(loginLogo));
        Assert.assertEquals(loginLogo.getText(),
                "Swag Labs",
                "Header title not matching!");

        wait.until(ExpectedConditions.visibilityOf(usernameInputBox));
        Assert.assertEquals(usernameInputBox.getAttribute("placeholder"),
                "Username",
                "Username placeholder is not matching!");

        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        Assert.assertEquals(passwordInputBox.getAttribute("placeholder"),
                "Password",
                "Password placeholder is not matching!");


        wait.until(ExpectedConditions.visibilityOf(loginButton));
        Assert.assertEquals(loginButton.getAttribute("value"),
                "Login",
                "Login button value is not matching!");

        System.out.println("Login page is open and verified!");
    }

    public void verifyLoginPageUrl(){
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Swag Labs";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("Login page url is valid.");
    }

    public void verifyLoginPageLoginLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(loginLogo));
        Assert.assertEquals(loginLogo.getText(),
                "Swag Labs",
                "Header title not matching!");
        System.out.println("Login logo is correct and visible.");
    }

    public void verifyLoginPageUsernameInputBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(usernameInputBox));
        Assert.assertEquals(usernameInputBox.getAttribute("placeholder"),
                "Username",
                "Username placeholder is not matching!");
        System.out.println("Username input box is clickable!");
    }

    public void verifyLoginPagePasswordInputBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(passwordInputBox));
        Assert.assertEquals(passwordInputBox.getAttribute("placeholder"),
                "Password",
                "Password placeholder is not matching!");
        System.out.println("Password input box is clickable");

    }

    public void verifyLoginPageLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        Assert.assertEquals(loginButton.getAttribute("value"),
                "Login",
                "Login button value is not matching!");
        System.out.println("Login button is clickable");

    }

    public void loginStandardUser(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if ("standard_user".equals(user)){
            wait.until(ExpectedConditions.elementToBeClickable(usernameInputBox));
            usernameInputBox.sendKeys("standard_user");
            wait.until(ExpectedConditions.elementToBeClickable(passwordInputBox));
            passwordInputBox.sendKeys("secret_sauce");
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
            System.out.println("User is logged in as Standard User.");
        }
        else {
            System.out.println("Test failed! Standard user not logged in.");
        }
    }

    public void loginLockedOutUser(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if ("locked_out_user".equals(user)){
            wait.until(ExpectedConditions.elementToBeClickable(usernameInputBox));
            usernameInputBox.sendKeys("locked_out_user");
            wait.until(ExpectedConditions.elementToBeClickable(passwordInputBox));
            passwordInputBox.sendKeys("secret_sauce");
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
            System.out.println("Locked out user tried to login.");
        }
        else {
            System.out.println("Test failed!");
        }
    }

    public void loginProblemUser(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if ("problem_user".equals(user)){
            wait.until(ExpectedConditions.elementToBeClickable(usernameInputBox));
            usernameInputBox.sendKeys("problem_user");
            wait.until(ExpectedConditions.elementToBeClickable(passwordInputBox));
            passwordInputBox.sendKeys("secret_sauce");
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
            System.out.println("User is logged in as Problem user.");
        }
        else {
            System.out.println("Test failed! Problem user not logged in.");
        }
    }

    public void loginPerformanceGlitchUser(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if ("performance_glitch_user".equals(user)){
            wait.until(ExpectedConditions.elementToBeClickable(usernameInputBox));
            usernameInputBox.sendKeys("performance_glitch_user");
            wait.until(ExpectedConditions.elementToBeClickable(passwordInputBox));
            passwordInputBox.sendKeys("secret_sauce");
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
            System.out.println("User is logged in as Performance glitch user.");
        }
        else {
            System.out.println("Test failed! Performance glitch user not logged in.");
        }
    }

    public void LoginValidations(String userName, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(usernameInputBox));
        usernameInputBox.sendKeys(userName);
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputBox));
        passwordInputBox.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        if ("".equals(userName)) {
            System.out.println("UserName is empty: " + userName.isEmpty());
        }else if ("".equals(password)) {
            System.out.println("Password is empty: " + password.isEmpty());
        }
    }

    public void verifyUsernameIsNotEntered() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMessageContainer));
        if (errorMessageContainer.isDisplayed()) {
            Assert.assertEquals(errorMessageContainer.getText(),
                    "Epic sadface: Username is required",
                    "Error message does not match!");
            takeAScreenShotOfLoginBox();
        }else {
            System.out.println("Error message container is not shown!");
        }
    }


}
