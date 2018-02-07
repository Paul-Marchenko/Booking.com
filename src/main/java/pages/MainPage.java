package pages;

import BaseConfigs.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class MainPage extends BasePageObject<MainPage> {
    private static final String URL = "https://www.booking.com/";
    private By mainLogo = By.xpath("//*[@alt='Booking.com Online Hotel Reservations']");
    private By destinationPropertyNameOrAddressField = By.cssSelector("#ss");
    private By checkInDateSelection = By.cssSelector("#frm > div:nth-child(10) > div > div.sb-dates__grid.u-clearfix > div.sb-dates__col.--checkin-field");
    private By checkOutDateSelection = By.cssSelector("#frm > div:nth-child(10) > div > div.sb-dates__grid.u-clearfix > div.sb-dates__col.--checkout-field > div");
    private By adultsQuantityList = By.cssSelector("#group_adults");
    private By childrenQuantityList = By.cssSelector("#group_children");
    private By travelingForWorkConfirmationCheckBox = By.cssSelector(".sb-booker-type-checkbox > label:nth-child(1) > input:nth-child(1)");
    //x.path=//*[@value='business']
    private By roomsQuantityList = By.cssSelector("#no_rooms");
    private By searchButton = By.cssSelector("#div.sb-searchbox__row:nth-child(12) > div:nth-child(2) > button:nth-child(1)");

    public MainPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    protected String element;

    public void openMainPage() {
        getPage(URL);
    }

    public String getMainLogoName() {

        return getText(mainLogo);

    }

    public boolean isElementPresent() {
        confirmationPresentElement(mainLogo);
        return false;

    }

    public void fullUpData(String place, String startDate, String lastDate, String adults, String children, String room) {
        type(place, destinationPropertyNameOrAddressField);
        type(place, destinationPropertyNameOrAddressField);//*[@value='business']
        type(place, destinationPropertyNameOrAddressField);
        type(place, destinationPropertyNameOrAddressField);
    }


}
