package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(ActualUrl, ExpectedUrl);
        System.out.println(ActualUrl);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("title"))));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("social_twitter"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("social_facebook"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("social_linkedin"))));

    }

}
