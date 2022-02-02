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

    @FindBy(xpath = ".//a[@href='reminder.php']")
    private WebElement linkReminder;

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

    public ProfilePage checkIsPasswordRemindLinkDisplayed(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(linkReminder));
        Assert.assertTrue("Password reminder link in the error massage was not displayed", isElementDisplayed(linkReminder));
        return this;
    }
}
