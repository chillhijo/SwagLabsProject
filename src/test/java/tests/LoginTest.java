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

    LoginPage loginPage;
    HomePage homePage;

    @Test(description = "Verify Login page", priority = 1)
    public void verify_login_page_test() {
        loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageUrl();
        loginPage.verifyLoginPageLoginLogo();
        loginPage.verifyLoginPageUsernameInputBox();
        loginPage.verifyLoginPagePasswordInputBox();
        loginPage.verifyLoginPageLoginButton();
    }

    @Test(description = "Login with standard user")
    public void login_with_standard_user_test() {
        loginPage = new LoginPage(driver);
        loginPage.loginStandardUser("standard_user");
    }

    @Test(description = "Login with locked out user")
    public void login_with_locked_out_user_test() {
        loginPage = new LoginPage(driver);
        loginPage.loginLockedOutUser("locked_out_user");
    }

    @Test(description = "test verifying login page")
    public void verifyLoginPage() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.loginLockedOutUser("locked_out_user");
        loginPage.verifyLockedOutUserErrorMessages();
        loginPage.takeAScreenShot();
        loginPage.takeFullScreenPageScreenShot();
    }

    @Test
    public void verifyHomePage() {
        loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.loginStandardUser("standard_user");
        homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.addBackpackToCart();
    }
}
