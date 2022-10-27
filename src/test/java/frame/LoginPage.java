package frame;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import testframework.baseframe.BaseForm;

public class LoginPage extends BaseForm {
    private TextField loginField = new TextField(By.name("username"), "Login Field");
    private TextField passwordField = new TextField(By.name("password"), "Password Field");
    private Button signIn = new Button(By.name("login"), "Login Button");

    public LoginPage() {
        super(new TextLabel(By.xpath("//header[contains(@class,'login')]"), "Title for loginPage"),
                "LoginPage");
    }

    @Step("Input credentials")
    public void inputCredentials(String login, String password) {
        loginField.InputText(login);
        passwordField.InputText(password);
    }

   @Step("Sign in")
    public void signIn() {
        signIn.click();
    }

}
