package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.Array;
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

    public void validateShownAndActualProducts() {
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        List<String> productsName = new ArrayList<>();

        for (WebElement product : products) {
            productsName.add(product.getText());
        }

    }

    public ArrayList<String> productName() {

    }
    public void getShownProductInfo() {
        ArrayList<String> shownNames = new ArrayList<>();
        for (WebElement element : productElement) {

        }
    }

    public void visibleAndGetSrc(WebElement element, String expectedSrc) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getAttribute("src"), expectedSrc, "URL doesn't match");
    }


}
