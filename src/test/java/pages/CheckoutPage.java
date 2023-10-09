package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameInfo;

    @FindBy (id = "last-name")
    private WebElement lastNameInfo;

    @FindBy (id = "postal-code")
    private WebElement postalCodeInfo;

    @FindBy (className = "title")
    private WebElement yourInfoTitle;

    @FindBy (id = "continue")
    private WebElement continueButtonOnCheckoutPage;

    @FindBy (id = "cancel")
    private WebElement cancelButtonOnCheckoutPage;

    public void verifyCheckoutYourInformation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(yourInfoTitle));

        Assert.assertEquals(firstNameInfo.getAttribute("placeholder"),
                "First Name",
                "Text doesnt match!");
        Assert.assertEquals(lastNameInfo.getAttribute("placeholder"),
                "Last Name",
                "Text doesnt match!");
        Assert.assertEquals(postalCodeInfo.getAttribute("placeholder"),
                "Zip/Postal Code",
                "Text doesnt match!");
        System.out.println("Your information page is verified");
    }

    public void enterYourInformation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInfo));
        firstNameInfo.sendKeys("Dusko");
        lastNameInfo.sendKeys("Pralica");
        postalCodeInfo.sendKeys("12345");
        System.out.println("Your information's are entered.");
    }

    public void clickContinueAfterEnteringInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueButtonOnCheckoutPage));
        continueButtonOnCheckoutPage.click();
        System.out.println("Clicked on continue after entering your info.");
    }

    public void clickCancelAfterEnteringInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cancelButtonOnCheckoutPage));
        cancelButtonOnCheckoutPage.click();
    }
}
