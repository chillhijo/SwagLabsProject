package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCart;

public class home_page_tests extends BaseTest {

    public home_page_tests() {super();}
    LoginPage loginPage;
    HomePage homePage;
    @Test (description = "Verify Home Page")
    public void verify_home_page_test001() {
        loginPage = new LoginPage(driver);
        loginPage.loginStandardUser("standard_user");

        homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.addBackpackToCart();
        homePage.removeBackpackFromCart();
        homePage.addBackpackToCart();
        homePage.openYourCart();
    }

    @Test (description = "Open the Hamburger menu")
    public void open_the_hamburger_menu_test002() {
        loginPage = new LoginPage(driver);
        loginPage.loginStandardUser("standard_user");

        homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.openTheHamburgerMenu();
        homePage.verifyHamburgerMenuElementsText();
    }

    @Test (description = "Add Backpack to the cart")
    public void add_backpack_to_the_cart_test003() {
        loginPage = new LoginPage(driver);
        loginPage.loginStandardUser("standard_user");

        homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.addBackpackToCart();
        homePage.verifyBackpackAddedToTheCart();
    }
}
