package frame;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import testframework.baseframe.BaseForm;
import utils.LoggerUtils;

public class MainPageForAuthorUser extends BaseForm {
    private Button userButton = new Button(By.xpath("//app-login-menu"),
            "userButton");
    private Button personalAreaBt = new Button(By.xpath("//li[contains(@class,'padding-0-42')][1]"),
            "personalAreaBt");

    public MainPageForAuthorUser() {
        super(new TextLabel(By.xpath("//div[contains(@class,'logo')]/a"), "BaseElement"),
                MainPageForAuthorUser.class.getName());
    }

    @Step("Open personal area")
    public void openPersonalArea() {
        LoggerUtils.logInfo(MainPageForAuthorUser.class.getName(),"Go to personal area");
        userButton.waitForVisible();
        userButton.simpleClick();
        personalAreaBt.waitForVisible();
        personalAreaBt.simpleClick();
    }

}
