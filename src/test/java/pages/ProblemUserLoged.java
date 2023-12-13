package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProblemUserLoged extends PageBase {
    public ProblemUserLoged(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//img[@alt='Sauce Labs Backpack']")
    private WebElement sauceLabsBackpack;
    @FindBy(xpath = "//img[@alt='Sauce Labs Bike Light']")
    private WebElement sauceLabsBikeLight;
    @FindBy(xpath = "//img[@alt='Sauce Labs Bolt T-Shirt']")
    private WebElement sauceLabsBoltTShirt;
    @FindBy(xpath = "//img[@alt='Sauce Labs Fleece Jacket']")
    private WebElement sauceLabsFleeceJacket;
    @FindBy(xpath = "//img[@alt='Sauce Labs Onesie']")
    private WebElement sauceLabsOnesie;
    @FindBy(xpath = "//img[@alt='Test.allTheThings() T-Shirt (Red)']")
    private WebElement sauceLabsTShirt;

    String sauceLabsBackpackImgURL = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";
    String sauceLabsBikeLightImgURL = "https://www.saucedemo.com/static/media/bike-light-1200x1500.37c843b0.jpg";
    String sauceLabsBoltTShirtImgURL = "https://www.saucedemo.com/static/media/bolt-shirt-1200x1500.c2599ac5.jpg";
    String sauceLabsFleeceJacketImgURL = "https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg";
    String sauceLabsOnesieImgURL = "https://www.saucedemo.com/static/media/red-onesie-1200x1500.2ec615b2.jpg";
    String sauceLabsTShirtImgURL = "https://www.saucedemo.com/static/media/red-tatt-1200x1500.30dadef4.jpg";

    public void getSrc() {

        sauceLabsBackpackImgURL = sauceLabsBackpack.getAttribute("src");
        sauceLabsBikeLightImgURL = sauceLabsBikeLight.getAttribute("src");
        sauceLabsBoltTShirtImgURL = sauceLabsBoltTShirt.getAttribute("src");
        sauceLabsFleeceJacketImgURL = sauceLabsFleeceJacket.getAttribute("src");
        sauceLabsOnesieImgURL = sauceLabsOnesie.getAttribute("src");
        sauceLabsTShirtImgURL = sauceLabsTShirt.getAttribute("src");

        // Now, you can use these URL strings as needed
        System.out.println("Backpack Image URL: " + sauceLabsBackpackImgURL);
        System.out.println("Bike Light Image URL: " + sauceLabsBikeLightImgURL);
        System.out.println("Bolt T-Shirt Image URL: " + sauceLabsBoltTShirtImgURL);
        System.out.println("Fleece Jacket Image URL: " + sauceLabsFleeceJacketImgURL);
        System.out.println("Onesie Image URL: " + sauceLabsOnesieImgURL);
        System.out.println("T-Shirt Image URL: " + sauceLabsTShirtImgURL);
    }
}
