package base;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "login-box")
    private WebElement loginBoxForScreenShot;

    public void takeAScreenShotOfLoginBox() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginBoxForScreenShot));
        File source = loginBoxForScreenShot.getScreenshotAs(OutputType.FILE);
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
        Assert.assertEquals(errorMessageContainer.getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error message do not match!");
    }
}
