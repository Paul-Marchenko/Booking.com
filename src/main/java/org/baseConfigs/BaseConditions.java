package org.baseConfigs;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;

public class BaseConditions {
    protected WebDriver driver;
    protected Logger logger;

    @BeforeClass(alwaysRun=true)
    protected void setUpClass(ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        logger = Logger.getLogger(testName);

    }
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun=true)
    protected void setUp(String browser){
        driver=BrowserFactory.getDriver(browser,logger);
    }
    @AfterMethod(alwaysRun = true)
    protected void tearDown(){
        driver.quit();
    }
}
