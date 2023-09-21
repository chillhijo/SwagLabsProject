package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class login_tests extends BaseTest {

    public login_tests() {
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

    @Test(description = "Login with problem user")
    public void login_with_problem_user_test() {
        loginPage = new LoginPage(driver);
        loginPage.loginProblemUser("problem_user");
    }

    @Test(description = "Login with performance glitch user")
    public void login_with_performance_glitch_user_test() {
        loginPage = new LoginPage(driver);
        loginPage.loginPerformanceGlitchUser("performance_glitch_user");
    }

    @Test(description = "Login with invalid username")
    public void login_with_invalid_username_test() {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("invalid username", "secret_sauce");
    }

    @Test(description = "Login with invalid password")
    public void login_with_invalid_password_test() {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("standard_user","invalid password");
    }

    @Test(description = "Login with empty username field")
    public void login_with_empty_username_field_test() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("", "secret_sauce");
        loginPage.verifyUsernameIsNotEntered();
    }

    @Test(description = "Login with empty password field")
    public void login_with_empty_password_field_test() {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("standard_user", "");
    }
    @Test(description = "Login with empty username and password fields")
    public void login_with_empty_username_and_password_fields_test() {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("", "");
    }

    @Test(description = "test verifying login page")
    public void verifyLoginPage() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.loginLockedOutUser("locked_out_user");
        loginPage.verifyLockedOutUserErrorMessages();
        loginPage.takeAScreenShotOfLoginBox();
        loginPage.takeFullScreenPageScreenShot();
    }

}
