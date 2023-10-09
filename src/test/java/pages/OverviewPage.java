package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OverviewPage extends PageBase {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "title")
    private WebElement overviewPageTitle;

    @FindBy (id = "finish")
    private WebElement finishCheckoutButton;

    @FindBy(id = "cancel")
    private WebElement cancelCheckoutButton;

    @FindBy (className = "summary_info_label")
    private WebElement paymentInformationLabel;


    public void verifyOverviewPage() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(actualUrl, expectedUrl, "Url doesnt match");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(overviewPageTitle));
        System.out.println("Overview page is verified!");
    }

    public void clickOnTheFinishButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(finishCheckoutButton));
        finishCheckoutButton.click();
        System.out.println("Clicked on Finish button.");
    }
}
