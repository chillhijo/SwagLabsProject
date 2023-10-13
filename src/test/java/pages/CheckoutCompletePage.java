package pages;

import base.BaseTest;
import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class CheckoutCompletePage extends PageBase {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "title")
    private WebElement overviewPageTitle;

    @FindBy (id = "back-to-products")
    private WebElement backHomeButton;

    @FindBy (className = "complete-header")
    private WebElement completeHeaderConfirmationText;

    @FindBy (id = "checkout_complete_container")
    private WebElement completedPurchaseContainer;


    public void verifyCompleteOrderAndPage() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(actualUrl, expectedUrl, "Url doesnt match!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(overviewPageTitle));
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButton));

        Assert.assertEquals(completeHeaderConfirmationText.getText(),
                "Thank you for your order!",
                "Confirmation text doesnt match!");
        System.out.println("Order completed!");
    }

    public void takeAScreenShotOfCompletedOrder() throws IOException {
        PageBase pageBase = new PageBase(driver);
        pageBase.takeAScreenShotOfAWantedElement(completedPurchaseContainer);
    }

    public void backHomeToContinueShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButton));
        backHomeButton.click();
    }
}
