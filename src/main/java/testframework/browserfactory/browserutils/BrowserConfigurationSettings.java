package testframework.browserfactory.browserutils;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.ConfigProperties;

public class BrowserConfigurationSettings {
    private static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    private static WebDriver getDriverChrome() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + configProperties.language().toUpperCase());
        return new ChromeDriver(options);
    }


    public static WebDriver initializeSeleniumCHROME() {

        return getDriverChrome();
    }


    public static FirefoxDriver initializeSeleniumFireFox() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", configProperties.language());
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return new FirefoxDriver(options);
    }
}
