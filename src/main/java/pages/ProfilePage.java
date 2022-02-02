package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends ParentPage{

    @FindBy(xpath = ".//h2[text()='Сменить пароль:']")
    private WebElement headerChangePassword;

    @FindBy(xpath = ".//input[@name='mail_new']")
    private WebElement inputNewEmail;

    @FindBy(xpath = ".//input[@name='ml_submit']")
    private WebElement buttonSubmitNewEmail;

    @FindBy(xpath = ".//div[@class = 'error_border_reg' ]")
    private WebElement messageChangingEmailError;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProfilePage checkIsRedirectToProfilePage(){
        Assert.assertTrue("Header of changing pass is not displayed", isElementDisplayed(headerChangePassword));
        return this;
    }

    public ProfilePage enterEmailIntoInput(String newEmail){
        enterTextIntoElement(inputNewEmail,newEmail);
        return this;
    }

    public ProfilePage clickOnSaveNewEmailButton(){
        clickOnElement(buttonSubmitNewEmail);
        return this;
    }

    public ProfilePage checkIsErrorEmailChangingMessageDisplayed(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(messageChangingEmailError));
        Assert.assertTrue("Error massage was not displayed", isElementDisplayed(messageChangingEmailError));
        return this;
    }
}
