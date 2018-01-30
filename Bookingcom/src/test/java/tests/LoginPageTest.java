package tests;

import org.baseConfigs.BaseConditions;
import org.baseConfigs.CsvDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Map;
import java.util.logging.Logger;

public class LoginPageTest extends BaseConditions {

    @Test(priority = 1)
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, logger);
        String expectedPageTitle = "Booking.com Online Hotel Reservations";
        String expectedProfileLastName = "Charls";
        loginPage.openLoginWindow();
        loginPage.fullUpCredentials("Sir_Bobby@i.ua", "Aa!19141983");
        loginPage.loginToPage();
        Thread.sleep(3000);
        //String actualPageTitle = loginPage.getTitle();
        String actualPageTitle = loginPage.getMainLogo();
        System.out.println("AR- " + actualPageTitle);
        System.out.println("ER- " + expectedPageTitle);
        // Assert.assertTrue(actualPageTitle.equals(expectedPageTitle), "Success");
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 2)
    public void incorrectLogin(Map<String, String> testData) {
        LoginPage loginPage = new LoginPage(driver,logger);
        String expectedErrorMessage = "You entered an email address/password combination that doesn't match.";
        String textNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");
        logger.info("T#1" + textNumber + " for " + description + " email: "
                + email + " pass " + password);
        loginPage.openLoginWindow();
        loginPage.fullUpCredentials("Sir_Bobbyi.ua", "Aa!19141983");
        loginPage.loginToPage();
        String actualErrorMessage =loginPage.getLoginErrorMessage();
        System.out.println("AR- " + actualErrorMessage);
        System.out.println("ER- " + expectedErrorMessage);
        System.out.println("Text- " + loginPage.getMainLogo());
        //Assert.assertTrue(expectedErrorMessage.equals(actualErrorMessage));

    }
}
