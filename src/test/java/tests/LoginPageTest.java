package tests;

import BaseConfigs.BaseConditions;
import BaseConfigs.CsvDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Map;

public class LoginPageTest extends BaseConditions {

    @Test(priority = 2)
    public void login() throws InterruptedException {

        String expectedProfileLastName = "Robert Charls";

        LoginPage loginPage = new LoginPage(driver, logger);
        loginPage.openLoginWindow();
        loginPage.fullUpCredentials("Sir_Bobby@i.ua", "Aa!19141983");
        loginPage.loginToPage();
        Thread.sleep(4000);

        String actualProfileLastName = loginPage.getProfileName();
        System.out.println("AR- " + actualProfileLastName);
        System.out.println("ER- " + expectedProfileLastName);
        Assert.assertTrue(actualProfileLastName.equals(expectedProfileLastName));

    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 3, groups = {"incorrectLogin", "broken"})
    public void incorrectLogin(Map<String, String> testData) throws InterruptedException {

        String expectedErrorMessage = "You entered an email address/password combination that doesn't match. I forgot";


        String textNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        logger.info("T#0" + textNumber + " for " + description + " :"
                + email + " pass: " + password);

        LoginPage loginPage = new LoginPage(driver, logger);
        loginPage.openLoginWindow();
        loginPage.fullUpCredentials(email, password);
        loginPage.loginToPage();
        Thread.sleep(4000);

        String actualErrorMessage = loginPage.getLoginErrorMessage();
        System.out.println("AR- " + actualErrorMessage);
        System.out.println("ER- " + expectedErrorMessage);
        System.out.println("Text- " + loginPage.getMainLogo());
        Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));

    }
}
