package testframework.baseframe;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import testframework.browserfactory.basebrowser.Browser;

public abstract class BaseTest {
    @BeforeTest
    public void setUpUrl() {
        Browser.getBrowser().getDriver();
    }

    @AfterTest
    public void tearDown() {
        Browser.closeBrowser();
    }
}
