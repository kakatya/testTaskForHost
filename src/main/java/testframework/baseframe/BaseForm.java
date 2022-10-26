package testframework.baseframe;

import testframework.browserfactory.basebrowser.Browser;

public abstract class BaseForm {
    private BaseElement baseElement;
    private String name;

    public BaseForm(BaseElement baseElement, String name) {
        this.baseElement = baseElement;
        this.name = name;
    }

    public void checkPage(String expectedHeader) {
        try {
            if (!expectedHeader.
                    equals(Browser.getBrowser().getDriver().getTitle()))
                throw new IllegalStateException();
        } catch (IllegalStateException ex) {

        }
    }

    public Boolean isDisplayed() {
        boolean displ = baseElement.isDisplayed();
        return displ;
    }

    public void waitForOpen() {
        baseElement.waitForVisible();
    }

    public String getName() {
        return name;
    }
}
