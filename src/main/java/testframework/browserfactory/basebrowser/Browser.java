package testframework.browserfactory.basebrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import testframework.browserfactory.browserutils.BrowserConfigurationSettings;
import utils.ConfigProperties;
import utils.LoggerUtils;


public class Browser {
    private static Browser browser;
    private static WebDriver webDriver;
    private static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    private Browser(WebDriver driver) {
        webDriver = driver;
    }

    public static Browser getBrowser() {
        try {
            if (browser == null) {
                switch (configProperties.browser()) {
                    case "CHROME":
                        WebDriverManager.chromedriver().setup();
                        browser = new Browser(BrowserConfigurationSettings.initializeSeleniumCHROME());
                        LoggerUtils.logInfo(Browser.class.getName(), "good");
                        break;
                    case "FIRE_FOX":
                        browser = new Browser(BrowserConfigurationSettings.initializeSeleniumFireFox());
                        WebDriverManager.firefoxdriver().setup();
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException ex) {
            LoggerUtils.logError(Browser.class.getName(), "Browser is not exist.");
        }
        return browser;
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public static void closeBrowser() {
        browser.getDriver().quit();
        browser = null;
    }
}
