package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void startBrowserTest() {
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
        baseTest.cleanUp();
    }
}
