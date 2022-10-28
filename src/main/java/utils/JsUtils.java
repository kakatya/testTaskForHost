package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import testframework.browserfactory.basebrowser.Browser;

public class JsUtils {

    public static void clickOnElement(WebElement webElement) {
        ((JavascriptExecutor) Browser.getBrowser().getDriver())
                .executeScript("arguments[0].click();", webElement);
    }
    public static void pageDown(int scrollTo) {
        try {
            ((JavascriptExecutor) Browser.getBrowser().getDriver())
                    .executeScript("window.scrollTo(0," + scrollTo + ")");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LoggerUtils.logFatal(JsUtils.class.getName(), e.getMessage());
        }
    }

}
