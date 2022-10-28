import frame.LoginPage;
import frame.MainPage;
import frame.MainPageForAuthorUser;
import frame.PersonalAreaPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testframework.baseframe.BaseTest;
import testframework.browserfactory.basebrowser.Browser;
import utils.ApiApplicationRequest;
import utils.ConfigProperties;

import java.util.List;

@Listeners({TestListenerAdapter.class})
@Epic("Regression Tests")
@Feature("Personal area test")
public class TestM extends BaseTest {
    ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Step("Check login page")
    @Test
    public void myTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        MainPageForAuthorUser mainPageForAuthorUser = new MainPageForAuthorUser();
        PersonalAreaPage personalAreaPage = new PersonalAreaPage();
        Browser.getBrowser().getDriver().navigate().to(configProperties.baseUrl());
        Assert.assertTrue(mainPage.isDisplayed(), "Main page is not displayed");
        mainPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isDisplayed(), "Login page is not displayed");
        loginPage.inputCredentials(configProperties.login(),
                configProperties.password());
        loginPage.signIn();
        mainPageForAuthorUser.waitForOpen();
        mainPageForAuthorUser.openPersonalArea();
        mainPageForAuthorUser.waitForOpen();
        personalAreaPage.waitForOpen();
        personalAreaPage.openOtherPartition();
        personalAreaPage.openIndicatorsHealth();
        personalAreaPage.scrollPage();
        personalAreaPage.clickOnAddIndicator();
        personalAreaPage.scrollPage();
        personalAreaPage.inputIndicator(configProperties.indicator());
        personalAreaPage.pressEnter();

        Assert.assertEquals(personalAreaPage.getIndVal(), configProperties.indicator()
                , "Indicator value is not correct");
        List<String> strings = ApiApplicationRequest.getServicesName("https://pp86.hostco.ru/"
                , "api/pp/rest/services", 200, ContentType.JSON);
        Assert.assertTrue(strings.contains(configProperties.expected_service()), "Not found:" + configProperties.expected_service());
    }


}
