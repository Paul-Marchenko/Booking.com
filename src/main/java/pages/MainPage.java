package pages;

import org.baseConfigs.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class MainPage extends BasePageObject <MainPage> {
    private static final String URL = "https://www.booking.com/";
    private By mainLabel=By.xpath("//*[@id=\"logo_no_globe_new_logo\"]");
    public MainPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void openMainPage(){
        getPage(URL);
    }
}
