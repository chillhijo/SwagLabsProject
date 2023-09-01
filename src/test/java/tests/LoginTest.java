package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    public LoginTest() {
        super();
    }

    @Test(description = "test verifying login page")
    public void verifyLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.loginLockedOutUser("locked_out_user");
    }
}
