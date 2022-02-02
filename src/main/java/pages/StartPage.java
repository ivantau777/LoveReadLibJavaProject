package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends ParentPage{

    @FindBy(xpath = ".//input[@name='login']")
    private WebElement inputLogin;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//input[@name='submit_enter']")
    private WebElement buttonSubmitEnter;

    @FindBy(xpath = ".//input[@name='remember']")
    private WebElement checkBoxRemember;

    public StartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public StartPage openStartPage(){
        try{
            webDriver.get(baseURL + "/");
            logger.info("Start page was opened");
        } catch (Exception e) {
            logger.error("Can not open Start Page" + e);
            Assert.fail("Can not open Start Page" + e);
        } return this;
    }

    public StartPage enterLoginIntoLoginField(String login){
        enterTextIntoElement(inputLogin, login);
        return this;
    }

    public StartPage enterPasswordIntoPasswordField(String password){
        enterTextIntoElement(inputPassword, password);
        return this;
    }

    public StartPage clickOnCheckBoxRemember(){
        clickOnElement(checkBoxRemember);
        return this;
    }

    public HomePage clickOnEnterButtonWithValidCred(){
        clickOnElement(buttonSubmitEnter);
        return new HomePage(webDriver);
    }

    public LoginErrorPage clickOnEnterButtonWithInvalidCred(){
        clickOnElement(buttonSubmitEnter);
        return new LoginErrorPage(webDriver);
    }

}
