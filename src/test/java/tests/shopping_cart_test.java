package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.ShoppingCart;

import java.time.Duration;

public class shopping_cart_test extends BaseTest {

    @Test
    public void verify_shopping_cart_test001() {
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.verifyShoppingPage();
    }

    @Test
    public void continue_shopping_test002() {
    }
}
