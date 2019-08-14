package framework;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SeleniumTestCase extends WebDriverCommands {

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "\\selenium_drivers\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("pageLoadStrategy", "none");
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        WebDriverCommands.driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(WebDriverCommands.driver);

        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterMethod
    public void tearDown()
    {
        getWebDriver().manage().deleteAllCookies();
        getWebDriver().quit();
    }

}
