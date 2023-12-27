package tests;

import base.BaseTest;
import org.apache.commons.mail.EmailException;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class login_tests extends BaseTest {

    public login_tests() {
        super();
    }
    LoginPage loginPage;
    long startTime = System.currentTimeMillis();

    @Test(description = "Verify Login page", priority = 1)
    public void verify_login_page_test001() throws EmailException, IOException {
        loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageUrl();
        loginPage.verifyLoginPageLoginLogo();
        loginPage.verifyLoginPageUsernameInputBox();
        loginPage.verifyLoginPagePasswordInputBox();
        loginPage.verifyLoginPageLoginButton();
    }

    @Test(description = "Login with standard user", priority = 2)
    public void login_with_standard_user_test002() {
        loginPage = new LoginPage(driver);
        loginPage.loginStandardUser("standard_user");

    }

    @Test(description = "Login with locked out user", priority = 3)
    public void login_with_locked_out_user_test003() {
        loginPage = new LoginPage(driver);
        loginPage.loginLockedOutUser("locked_out_user");
    }

    @Test(description = "Login with problem user", priority = 4)
    public void login_with_problem_user_test004() {
        loginPage = new LoginPage(driver);
        loginPage.loginProblemUser("problem_user");
    }

    @Test(description = "Login with performance glitch user", priority = 5)
    public void login_with_performance_glitch_user_test005() {
        loginPage = new LoginPage(driver);
        loginPage.loginPerformanceGlitchUser("performance_glitch_user");
    }

    @Test(description = "Login with invalid username", priority = 6)
    public void login_with_invalid_username_test006() {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("invalid username", "secret_sauce");
    }

    @Test(description = "Login with invalid password", priority = 7)
    public void login_with_invalid_password_test007() {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("standard_user","invalid password");
    }

    @Test(description = "Login with empty username field", priority = 8)
    public void login_with_empty_username_field_test008() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("", "secret_sauce");
        loginPage.verifyUsernameIsNotEntered();
    }

    @Test(description = "Login with empty password field", priority = 9)
    public void login_with_empty_password_field_test009() {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("standard_user", "");
    }

    @Test(description = "Login with empty username and password fields", priority = 10)
    public void login_with_empty_username_and_password_fields_test010() {
        loginPage = new LoginPage(driver);
        loginPage.LoginValidations("", "");

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + ((endTime - startTime) / 1000) + "seconds");
    }


}
