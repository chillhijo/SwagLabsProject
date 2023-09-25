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
import java.util.List;

public class ShoppingCart extends PageBase {
    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    //WEB ELEMENTS
    @FindBy (className = "title")
    private WebElement shoppingCartTitleUnderHamburgerMenu;

    @FindBy (className = "cart_quantity_label")
    private WebElement cartQuantityLabel;

    @FindBy (className = "cart_desc_label")
    private WebElement cartDescLabel;

    @FindBy (className = "cart_item")
    private WebElement cartItemsDiv;

    @FindBy (id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy (id = "checkout")
    private WebElement checkoutButton;

    // Methods
    public void verifyShoppingPage() {
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));

        String expectedUrl = "https://www.saucedemo.com/cart.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Shopping cart url does not match!");

        Assert.assertEquals(shoppingCartTitleUnderHamburgerMenu.getText(), "Your Cart", "Shopping cart title does not match!");
        Assert.assertEquals(cartQuantityLabel.getText(), "QTY", "Cart quantity label text does not match!");
        Assert.assertEquals(cartDescLabel.getText(), "Description", "Cart description text does not match!");

        wait.until(ExpectedConditions.visibilityOfAllElements(cartQuantityLabel, cartDescLabel));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
    }

    public void clickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public void clickCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

    public void countItemsInCart() {
        List <WebElement> items = driver.findElements(By.className("cart_item"));
        int itemsInCart = items.size();

        if (itemsInCart == HomePage.shoppingCartBadge) {

        }
    }
}
