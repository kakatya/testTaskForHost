package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import testframework.browserfactory.basebrowser.Browser;

public class JsUtils {

    public static void clickOnElement(WebElement webElement) {
        ((JavascriptExecutor) Browser.getBrowser().getDriver())
                .executeScript("arguments[0].click();", webElement);
    }
}
