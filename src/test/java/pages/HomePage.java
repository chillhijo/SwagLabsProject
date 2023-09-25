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

    //WEB ELEMENTS

    @FindBy (className = "app_logo")
    private WebElement homePageSwagLogo;

    @FindBy (className = "title")
    private WebElement productTitleUnderHamburgerMenu;

    @FindBy (className = "social_twitter")
    private WebElement twitterIconFooter;

    @FindBy (className = "social_facebook")
    private WebElement facebookIconFooter;

    @FindBy (className = "social_linkedin")
    private WebElement linkedinIconFooter;

    @FindBy (className = "shopping_cart_link")
    private WebElement shoppingCartContainer;

    @FindBy (xpath = "//span[@class='shopping_cart_badge']")
    public static WebElement shoppingCartBadge;

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCart;

    @FindBy (id = "'remove-sauce-labs-backpack")
    private WebElement removeBackpackFromCart;

    public void verifyHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(ActualUrl, ExpectedUrl);
        System.out.println(ActualUrl);

        Assert.assertEquals(homePageSwagLogo.getText(), "Swag Labs", "Home page logo doesn't match.");
        Assert.assertEquals(productTitleUnderHamburgerMenu.getText(), "Products", "Home page title doesn't match.");

        wait.until(ExpectedConditions.visibilityOf(twitterIconFooter));
        wait.until(ExpectedConditions.visibilityOf(facebookIconFooter));
        wait.until(ExpectedConditions.visibilityOf(linkedinIconFooter));
    }

    public void addBackpackToCart() {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addBackpackToCart));
        addBackpackToCart.click();
    }

    public void removeBackpackFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(removeBackpackFromCart));
        removeBackpackFromCart.click();
    }

    public void openYourCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartContainer));
        shoppingCartContainer.click();
    }

    public void verifyShoppingCartBadge() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (shoppingCartBadge.isDisplayed()){
            String itemsInTheCart = shoppingCartBadge.getText();
            System.out.println("You have" + itemsInTheCart + "items is in the cart!");
        } else {
            System.out.println("Your item is not in the cart, please add item to cart!");
        }
    }
}
