package pages;

import BaseConfigs.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class LoginPage extends MainPage {
    private By signInButton = By.xpath("(//*[@class='sign_in_wrapper'])[2]");
    private By emailField = By.xpath("(//*[@name='username'])[1]");
    private By passwordField = By.xpath("(//*[@name='password'])[1]");
    private By loginSignIn = By.cssSelector("#b2indexPage > div.modal-wrapper.user-access-menu-lightbox.user-access-menu-lightbox--user-center > div > div > div.user_access_signin_menu.form-section.form-shown-section > form.user_access_form.js-user-access-form--signin.form-subsection.user_access_menu__password--compact.user_access_form_js.user_access_form-user_avatar--circle > input.bootstrapped-input.btn.btn-primary");
    //private By loginSignIn = By.cssSelector("input.bootstrapped-input:nth-child(16)");
    private By profileLastName = By.cssSelector("#current_account");
    //private By profileLastName = By.xpath("//*[@id='current_account']/a/span[1]/img");

    private By errorMessage = By.cssSelector(".alert-displayed");

    public LoginPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openLoginWindow() {
        openElement(signInButton);
    }

    public void fullUpCredentials(String emailAdress, String password) {
        waitForVisibility(emailField,30);
        type(emailAdress, emailField);
        type(password, passwordField);

    }

    public void loginToPage() {
        openElement(loginSignIn);
    }


    public String getLoginErrorMessage() {
        waitForVisibility(errorMessage, 30);
        return getText(errorMessage);
    }

    public String getProfileName() {
        waitForVisibility(profileLastName,10);
        return getText(profileLastName);
    }


}
