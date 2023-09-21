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

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCart;

    public void verifyHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(ActualUrl, ExpectedUrl);
        System.out.println(ActualUrl);

        Assert.assertEquals(driver.findElement(By.className("app_logo")).getText(), "Swag Labs", "Home page logo doesn't match.");
        Assert.assertEquals(driver.findElement(By.className("title")).getText(), "Products", "Home page title doesn't match.");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("social_twitter"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("social_facebook"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("social_linkedin"))));
    }

    public void addBackpackToCart() {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));

        WebElement addBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        wait.until(ExpectedConditions.elementToBeClickable(addBackpack));
        addBackpack.click();
    }

    public void verifyShoppingCartBadge() {

    }

}
