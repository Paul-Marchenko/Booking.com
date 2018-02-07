package tests;

import BaseConfigs.BaseConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.logging.Logger;

public class MainPageTest extends BaseConditions {


    @Test(priority = 1)
    public void displayLogo() {
        MainPage mainPage = new MainPage(driver, logger);
        mainPage.openMainPage();

        Assert.assertTrue(mainPage.isElementPresent());

    }
    @Test(priority = 1)
    public void correctMainLogo() {
        String expectedMainLogo = "Booking.com Online Hotel Reservations";

        MainPage mainPage = new MainPage(driver, logger);
        mainPage.openMainPage();

        String actualMainLogo = mainPage.getMainLogoName();
        System.out.println("AR- " + actualMainLogo);
        System.out.println("ER- " + expectedMainLogo);
        Assert.assertTrue(actualMainLogo.equals(expectedMainLogo));


    }
}
