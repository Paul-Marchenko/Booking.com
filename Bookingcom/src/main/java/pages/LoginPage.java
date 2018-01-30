package pages;

import org.baseConfigs.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class LoginPage extends BasePageObject <LoginPage> {
    private By signInButton=By.xpath("(//*[@class='sign_in_wrapper'])[2]");
    private By emailField=By.xpath("(//*[@name='username'])[1]");
    private By passwordField=By.xpath("(//*[@name='password'])[1]");
    private By loginSignIn=By.xpath("(//*[@value='Sign in'])[1]");
    private By profileName=By.xpath("//*[@class='header_name user_lastname']");
    private By mainLogo=By.xpath("//*[@id='logo_no_globe_new_logo']");
    private By errorMessage=By.xpath("//*[@class='alert alert-error alert-displayed']");

    public LoginPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void openLoginWindow(){
        openElement(signInButton);
    }
    public void fullUpCredentials(String emailAdress, String password){
        type(emailAdress, emailField);
        type(password, passwordField);

    }
    public void loginToPage(){
        openElement(loginSignIn);
    }
    public String getMainLogo(){

        return getText(mainLogo);
    }
    public String getLoginErrorMessage(){
        waitForVisibility(errorMessage, 10);

        return getText(errorMessage);
    }
    public String getProfileName(){

        return getText(profileName);
    }


}
