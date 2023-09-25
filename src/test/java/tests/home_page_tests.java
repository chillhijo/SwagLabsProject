package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class home_page_tests extends BaseTest {

    public home_page_tests() {super();}
    LoginPage loginPage;
    HomePage homePage;
    @Test (description = "Verify Home Page")
    public void verify_home_page_test() {
        loginPage = new LoginPage(driver);
        loginPage.loginStandardUser("standard_user");

        homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.addBackpackToCart();
        homePage.openYourCart();
    }
}
