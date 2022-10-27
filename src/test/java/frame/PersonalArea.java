package frame;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import testframework.baseframe.BaseElement;
import testframework.baseframe.BaseForm;

public class PersonalArea extends BaseForm {
    private Button userButton = new Button(By.xpath("//div[contains(@tooltipposition,'bottom')]/a[@data-testid='userBtn' and contains(@style,'margin: 0px')]"),
            "userButton");
    private Button personalAreaBt = new Button(By.xpath("//li[contains(@class,'padding-0-42')][1]"),
            "personalAreaBt");

    public PersonalArea() {
        super(new TextLabel(By.xpath("//div[contains(@class,'logo')]/a"), "BaseElement"),
                PersonalArea.class.getName());
    }

    @Step("Open personal area")
    public void openPersonalArea() {
        userButton.waitForVisible();
        userButton.click();
        personalAreaBt.waitForVisible();
        personalAreaBt.waitForVisible();
        personalAreaBt.click();
    }

}
