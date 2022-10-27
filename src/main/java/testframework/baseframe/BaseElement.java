package testframework.baseframe;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testframework.browserfactory.basebrowser.Browser;
import utils.ConfigProperties;
import utils.JsUtils;

import java.time.Duration;
import java.util.List;

public abstract class BaseElement {
    private By locator;
    private String name;
    private static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public Boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    public String getAttribute(String nameAttribute) {
        return findElement().getAttribute(nameAttribute);
    }

    public void click() {
        JsUtils.clickOnElement(findElement());
    }

    protected WebElement findElement() {
        return Browser.getBrowser().getDriver().findElement(locator);
    }

    protected List<WebElement> findElements() {
        return Browser.getBrowser().getDriver().findElements(locator);
    }

    public void waitForVisible() {
        new WebDriverWait(Browser.getBrowser().getDriver(),
                Duration.ofSeconds(Long.parseLong(configProperties.waits())))
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    public String getName() {
        return name;
    }
}
