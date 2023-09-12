package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest extends BaseTest {

    public LoginTest() {
        super();
    }

    @Test(description = "test verifying login page")
    public void verifyLoginPage() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.loginLockedOutUser("locked_out_user");
        loginPage.verifyLockedOutUserErrorMessages();
        loginPage.takeAScreenShot();
        loginPage.takeFullScreenPageScreenShot();
    }

    @Test
    public void verifyHomePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.loginStandardUser("standard_user");
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.addBackpackToCart();
    }
}
