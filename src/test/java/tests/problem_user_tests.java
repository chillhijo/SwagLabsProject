package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProblemUserLoged;

public class problem_user_tests extends BaseTest {

    @Test
    public void verifySauceLabsBackpack() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.loginStandardUser("standard_user");
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        ProblemUserLoged problemUserLoged = new ProblemUserLoged(driver);
        problemUserLoged.getSrc();
    }
}
