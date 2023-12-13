package tests;

import base.BaseTest;
import base.PageBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.DevToolsManager;

import java.io.IOException;

public class locked_out_user_tests extends BaseTest {

    @Test(description = "Login with locked out user and capture a ss of error")
    public void login_locked_out_user_and_screenshot() throws IOException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.verifyLoginPageUrl();
        loginPage.verifyLoginPageLoginLogo();
        loginPage.verifyLoginPageUsernameInputBox();
        loginPage.verifyLoginPagePasswordInputBox();
        loginPage.verifyLoginPageLoginButton();
        loginPage.loginLockedOutUser("locked_out_user");
        loginPage.verifyLockedOutUserErrorMessages();
    }



    @Test
    public void login_with_locked_out_user() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageUrl();
        loginPage.verifyLoginPageLoginLogo();
        loginPage.verifyLoginPageUsernameInputBox();
        loginPage.verifyLoginPagePasswordInputBox();
        loginPage.verifyLoginPageLoginButton();


        DevToolsManager devToolsManager = new DevToolsManager();
        devToolsManager.createDevToolsSession((ChromeDriver) driver);
        devToolsManager.captureConsoleLogs();

        loginPage.loginLockedOutUser("locked_out_user");
        Thread.sleep(4000);
        loginPage.verifyLockedOutUserErrorMessages();
    }
}
