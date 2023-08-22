package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("firefox") String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("security.sandbox.content.level", 5);
            profile.setPreference("dom.disable_beforeunload", true);
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
//            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
        }
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
