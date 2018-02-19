package pages;

import BaseConfigs.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;
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
    private String adults;
    private String children;
    private String room;

    public MainPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

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

    public void fullUpData(String place) {
        waitForVisibility(searchButton, 10);
        chooseDestiantion(place);
        selectDataFromCalendar(checkInDateSelection);
        selectDataFromCalendar(checkOutDateSelection);
        chooseElementFromDropDownList(adultsQuantityList, adults);
        chooseElementFromDropDownList(childrenQuantityList, children);
        chooseElementFromDropDownList(roomsQuantityList, room);
        selectCheckBox();
        openElement(searchButton);
    }
    protected void chooseDestiantion(String placeName){
        selectEnteredElementFromDropDownList(destinationPropertyNameOrAddressField,placeName);
    }

    protected void selectCheckBox() {
        checkCheckBox(travelingForWorkConfirmationCheckBox);
    }

    protected void choiseCheckIbDate(By checkInDateSelection) {
        waitForVisibility(checkInDateSelection, 10);

    }

    protected void choiseCheckOutDate() {
        waitForVisibility(checkOutDateSelection, 10);

    }

    private void selectDataFromCalendar(By field) {
        find(field).click();
        defineCurrentDayFromCalendar();
        //selectFutureMonth


    }

    private Date defineCurrentDayFromCalendar() {
       // WebElement correctCurrentDay = find(By.cssSelector(By element));
        Date currentDayFromCalendar = null;
        return currentDayFromCalendar;
    }


}
