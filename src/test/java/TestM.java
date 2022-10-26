import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import testframework.browserfactory.basebrowser.Browser;
import utils.ConfigProperties;

public class TestM {
    ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Test
    public void myTest() {
        Browser.getBrowser().getDriver().get(configProperties.baseUrl());
    }

   /* @AfterTest
    public void tearDown() {
        Browser.closeBrowser();
    }*/
}
