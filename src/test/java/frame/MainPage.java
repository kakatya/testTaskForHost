package frame;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import testframework.baseframe.BaseForm;


public class MainPage extends BaseForm {

    private final Button personalAreaButton = new Button(By.xpath("//a[contains(@class,'login-menu')]"),
            "Personal Area button");

    public MainPage() {
        super(new TextLabel(By.xpath("//div[contains(@class,'logo')]/a"), "Main page Logo"),
                "Main page");
    }


    @Step("Go to login page")
    public void clickOnLoginButton() {
        personalAreaButton.waitForVisible();
        personalAreaButton.click();
    }

}
