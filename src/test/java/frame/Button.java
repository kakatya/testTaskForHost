package frame;

import org.openqa.selenium.By;
import testframework.baseframe.BaseElement;

public class Button extends BaseElement {
    public Button(By locator, String name) {
        super(locator, name);
    }
    public void simpleClick(){
        findElement().click();
    }


}
