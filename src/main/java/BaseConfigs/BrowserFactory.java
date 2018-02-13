package BaseConfigs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.MainPage;

import java.util.logging.Logger;

public class BrowserFactory {
    public static WebDriver getDriver(String browser, Logger logger) {
        WebDriver driver = null;
        logger.info("Start " + browser);
        MainPage mainPage = null;
        switch (browser) {
            case "firefox":
                //System.setProperty("webdriver.firefox.bin","/Applications/Firefox.app/Contents/MacOS/firefox-bin");
                //System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                mainPage = new MainPage(driver, logger);
                mainPage.openMainPage();
                break;
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                mainPage = new MainPage(driver, logger);
                mainPage.openMainPage();
                break;
            case "safari":
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new SafariDriver();
                mainPage = new MainPage(driver, logger);
                mainPage.openMainPage();
                break;
            default:
                driver = new FirefoxDriver();
                mainPage = new MainPage(driver, logger);
                mainPage.openMainPage();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
