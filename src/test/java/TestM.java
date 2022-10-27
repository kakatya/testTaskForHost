import frame.LoginPage;
import frame.MainPage;
import frame.PersonalArea;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testframework.browserfactory.basebrowser.Browser;
import utils.ApiApplicationRequest;
import utils.ConfigProperties;

import java.util.List;

@Listeners({TestListenerAdapter.class})
@Epic("Regression Tests")
@Feature("Personal area test")
public class TestM {
    ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Step("Check login page")
    @Test
    public void myTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        PersonalArea personalArea = new PersonalArea();
        Browser.getBrowser().getDriver().navigate().to(configProperties.baseUrl());
        Assert.assertTrue(mainPage.isDisplayed(), "Main page is not displayed");
        mainPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isDisplayed(), "Login page is not displayed");
        loginPage.inputCredentials(configProperties.login(),
                configProperties.password());
        loginPage.signIn();
        personalArea.waitForOpen();
        personalArea.openPersonalArea();
        List<String> strings = ApiApplicationRequest.getServicesName("https://pp86.hostco.ru/"
                , "api/pp/rest/services", 200, ContentType.JSON);
        Assert.assertTrue(strings.contains(configProperties.expected_service()),"Not found:"+configProperties.expected_service());
    }

    @AfterTest
    public void tearDown() {
        Browser.closeBrowser();
    }
}
