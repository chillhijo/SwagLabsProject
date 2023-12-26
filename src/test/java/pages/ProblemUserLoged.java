package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProblemUserLoged extends PageBase {

    public ProblemUserLoged(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//img[@alt='Sauce Labs Backpack']")
    private WebElement sauceLabsBackpackImg;
    @FindBy(xpath = "//img[@alt='Sauce Labs Bike Light']")
    private WebElement sauceLabsBikeLightImg;
    @FindBy(xpath = "//img[@alt='Sauce Labs Bolt T-Shirt']")
    private WebElement sauceLabsBoltTShirtImg;
    @FindBy(xpath = "//img[@alt='Sauce Labs Fleece Jacket']")
    private WebElement sauceLabsFleeceJacketImg;
    @FindBy(xpath = "//img[@alt='Sauce Labs Onesie']")
    private WebElement sauceLabsOnesieImg;
    @FindBy(xpath = "//img[@alt='Test.allTheThings() T-Shirt (Red)']")
    private WebElement sauceLabsTShirtImg;
    @FindBy(id = "//a[@id='item_4_title_link']")
    private WebElement sauceLabsBackpackName;
    @FindBy(id = "//a[@id='item_4_title_link']")
    private WebElement sauceLabsBikeLightName;
    @FindBy(id = "//a[@id='item_4_title_link']")
    private WebElement sauceLabsBoltTShirtName;
    @FindBy(id = "//a[@id='item_4_title_link']")
    private WebElement sauceLabsFleeceName;
    @FindBy(id = "//a[@id='item_4_title_link']")
    private WebElement sauceLabsOnesieName;
    @FindBy(id = "//a[@id='item_4_title_link']")
    private WebElement sauceLabsTShirtName;

    @FindBy(className = "inventory_details_name")
    private WebElement productName;
    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;
    @FindBy(className = "btn_inventory")
    private WebElement itemAddRemoveBtn;

    String sauceLabsBackpackImgURL = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";
    String sauceLabsBikeLightImgURL = "https://www.saucedemo.com/static/media/bike-light-1200x1500.37c843b0.jpg";
    String sauceLabsBoltTShirtImgURL = "https://www.saucedemo.com/static/media/bolt-shirt-1200x1500.c2599ac5.jpg";
    String sauceLabsFleeceJacketImgURL = "https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg";
    String sauceLabsOnesieImgURL = "https://www.saucedemo.com/static/media/red-onesie-1200x1500.2ec615b2.jpg";
    String sauceLabsTShirtImgURL = "https://www.saucedemo.com/static/media/red-tatt-1200x1500.30dadef4.jpg";

    public void validateSrcOfProductImages() {
        visibleAndGetSrc(sauceLabsBackpackImg, sauceLabsBackpackImgURL);
        visibleAndGetSrc(sauceLabsBikeLightImg, sauceLabsBikeLightImgURL);
        visibleAndGetSrc(sauceLabsBoltTShirtImg, sauceLabsBoltTShirtImgURL);
        visibleAndGetSrc(sauceLabsFleeceJacketImg, sauceLabsFleeceJacketImgURL);
        visibleAndGetSrc(sauceLabsOnesieImg, sauceLabsOnesieImgURL);
        visibleAndGetSrc(sauceLabsTShirtImg, sauceLabsTShirtImgURL);
    }

    public void verifyProductNames() throws InterruptedException {
        List<String> shownNames = getShownProductName();
        List<String> actualNames = getActualNames();

        compareLists(shownNames, actualNames);
    }

    private List<WebElement> shownElements() {
        return driver.findElements(By.className("inventory_item_name"));
    }
    public List<String> getShownProductName(){
        List<WebElement> shownNamesElements = shownElements();
        List<String> shownNames = new ArrayList<>();

        for (WebElement element : shownNamesElements) {
            shownNames.add(element.getText());
        }
        return shownNames;
    }

    public List<String> getActualNames() throws InterruptedException {
        List<WebElement> shownNamesElements = shownElements();
        List<String> actualProductNames = new ArrayList<>();
        for (int i = 0; i < shownNamesElements.size(); i++) {
            //Re-searching elements in each iteration of the loop.
            List<WebElement> updatedElements = driver.findElements(By.className("inventory_item_name"));
            WebElement element = updatedElements.get(i);

            clickableAndClick(element);
            verifyVisibilityOfElement(productName);
            String actualName = productName.getText();
            actualProductNames.add(actualName);
            backToProductsPage();
        }
        return actualProductNames;
    }

    private void compareLists(List<String> shownNames, List<String> actualNames) {
        if (shownNames.size() != actualNames.size()) {
            System.out.println("The lists do not have the same number of elements.");
            return;
        }

        boolean differance = false;

        for (int i = 0; i < shownNames.size(); i++) {
            String element1 = shownNames.get(i);
            String element2 = actualNames.get(i);

            if (!element1.equals(element2)) {
                System.out.println("Differance on position " + i + ": " + element1 + " != " + element2);
                differance = true;
            }
        }

        if (!differance) {
            System.out.println();
        }
    }

    public void verifyAddingProductInCart() {
        List<WebElement> itemAddRemoveButtons = driver.findElements(By.className("btn_inventory"));
        List<String> btnTextAfterClick = new ArrayList<>();
        for (WebElement btn : itemAddRemoveButtons) {
            List<WebElement> updatedItemAddRemoveButtons = driver.findElements(By.className("btn_inventory"));
            System.out.println("btnTXT: " + btn.getText());
            btnTextAfterClick.add(btn.getText());
            System.out.println("btn Text: " + btnTextAfterClick);
        }
    }

    public void backToProductsPage() {
        clickableAndClick(backToProductsButton);
    }

    public void visibleAndGetSrc(WebElement element, String expectedSrc) {
        verifyVisibilityOfElement(element);
        Assert.assertEquals(element.getAttribute("src"), expectedSrc, "URL doesn't match");
    }

    public void clickableAndClick(WebElement element) {
        verifyClickabilityOfElement(element);
        element.click();
    }

    public void verifyVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyClickabilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
