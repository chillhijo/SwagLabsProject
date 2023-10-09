package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCart;

public class e2e_test extends BaseTest {

    @Test
    public void e2e_test() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginStandardUser("standard_user");

        HomePage homePage = new HomePage(driver);
        homePage.addBackpackToCart();
        homePage.openYourCart();

        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.clickCheckoutButton();

    }
}
