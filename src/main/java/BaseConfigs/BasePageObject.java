package BaseConfigs;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

public class BasePageObject <T> {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;

    protected BasePageObject(WebDriver driver, Logger logger){
        this.driver=driver;
        this.logger=logger;
        wait = new WebDriverWait(driver, 30);

    }
    protected T getPage(String url){
        driver.get(url);
        return (T)this;
    }
    protected WebElement find(By element){
        return driver.findElement(element);
    }

    protected void type(String text, By element){
        find(element).sendKeys(text);
    }
    protected void openElement(By selector){
        find(selector).click();
    }
    public String getTitle() {
        return driver.getTitle();
    }
    protected String getText(By element){

        return find(element).getText();

    }
    public boolean confirmationPresentElement(By element){
        if(find(element).isDisplayed()){
            System.out.println("Element " + element +" is present");
        }
        else
            System.out.println("Element " + element +" not found");
        return true;
    }
    protected void selectEnteredElementFromDropDownList(By element, String text)  {
        List<WebElement> allElements;
        find(element).sendKeys(text);
        find(element).click();
        waitForVisibility(element,20);
        allElements = driver.findElements(By.tagName("li"));
        for (int i = 0; i < allElements.size(); i = i + 1)
        {
            WebElement item=allElements.get(i);
            if (allElements.contains(text) && item.isDisplayed())
            {
                item.click();
            }
        }

    }
    protected void chooseElementFromDropDownList(By element, By text){
        List<WebElement> allElements;
        find(element).click();
        waitForVisibility(element,20);
        allElements = driver.findElements(By.tagName("li"));
        for (int i = 0; i < allElements.size(); i = i + 1)
        {
            WebElement item=allElements.get(i);
            if (allElements.contains(text) && item.isDisplayed())
            {
                item.click();
            }
        }
    }
    private void waitFor (ExpectedCondition<WebElement> condition, Integer timeOutInSec){
        timeOutInSec = timeOutInSec !=null ? timeOutInSec:30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        wait.until(condition);



    }
    protected void waitForVisibility(By locator, Integer ...timeOutInSec){
        int attempt = 0;
        while(attempt >2){
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSec.length>0) ? timeOutInSec[0]:null);
            break;
            }
            catch (StaleElementReferenceException e){

            }
            attempt++;
        }

    }
    public Date currentDay(){
        Date currentDayValue;
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd.MM.yyyy");

        currentDayValue = calendar.getTime();
        System.out.println(currentDayValue);
        return currentDayValue;
    }


}
