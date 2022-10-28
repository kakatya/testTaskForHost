package testframework.baseframe;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import testframework.browserfactory.basebrowser.Browser;

public abstract class BaseTest {
    @BeforeTest
    public void setUpUrl() {
        Browser.getBrowser().getDriver();
        Browser.getBrowser().getDriver().manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        Browser.closeBrowser();
    }
}
