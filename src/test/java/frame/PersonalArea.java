package frame;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import testframework.baseframe.BaseForm;
import testframework.browserfactory.basebrowser.Browser;
import utils.JsUtils;

public class PersonalArea extends BaseForm {
    private Button otherPartitionBt = new Button(By.xpath("//a[@routerlink='card']"), "Other partition BT");
    private Button indicatorButton = new Button(By.xpath("//a[@routerLink='/account/card/health']"),
            "Indicator button");
    private Button addIndicatorButton = new Button(By.xpath("//div[@class='create-block']//a[contains(@class,'rel action-button')]"), "CreateIndicators button");

    private TextField indicator = new TextField(By.xpath("//p-inputmask//input[@type='text']"), "InputIndicator");

    private TextLabel tempr = new TextLabel(By.xpath("//div[contains(@class,'val')]//span"), "Indicator val");

    public PersonalArea() {
        super(new TextLabel(By.xpath("//div[contains(@class,'logo')]/a"), "BaseElement"), PersonalArea.class.getName());
    }

    @Step("Open other partition")
    public void openOtherPartition() {
        otherPartitionBt.waitForVisible();
        otherPartitionBt.click();
    }

    @Step("Click on the IndicatorHealthButton")
    public void openIndicatorsHealth() {
        indicatorButton.waitForVisible();
        indicatorButton.click();
    }

    @Step("Scroll the page")
    public void scrollPage() {
        JsUtils.pageDown(120);
    }

    @Step("Click on add indicator")
    public void clickOnAddIndicator() {
        addIndicatorButton.waitForVisible();
        addIndicatorButton.click();
    }

    @Step("Press enter key")
    public void pressEnter() {
        new Actions(Browser.getBrowser().getDriver()).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
    }

    @Step(" Input data in the indicator field")
    public void inputIndicator(String indicator_t) {
        indicator.InputText(indicator_t);
    }

    @Step("Get the indicators value")
    public String getIndVal() {
        tempr.waitForVisible();
        return tempr.getText();
    }
}
