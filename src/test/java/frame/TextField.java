package frame;

import org.openqa.selenium.By;
import testframework.baseframe.BaseElement;

public class TextField extends BaseElement {
    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void InputText(String text) {
        findElement().sendKeys(text);
    }
}
