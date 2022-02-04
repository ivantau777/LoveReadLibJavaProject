package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends ParentPageWithUserSideBlocks{

    @FindBy(xpath = ".//h2[text()='Сменить пароль:']")
    private WebElement headerChangePassword;

    @FindBy(xpath = ".//input[@name='mail_new']")
    private WebElement inputNewEmail;

    @FindBy(xpath = ".//input[@name='ml_submit']")
    private WebElement buttonSubmitNewEmail;

    @FindBy(xpath = ".//a[@href='reminder.php']")
    private WebElement linkReminder;

    @FindBy(xpath = ".//input[@name='n_password']")
    private WebElement inputNewPassword;

    @FindBy(xpath = ".//input[@name='n_password_2']")
    private WebElement inputRepeatNewPassword;

    @FindBy(xpath = ".//input[@name='ps_submit']")
    private WebElement buttonSubmitNewPassword;

    @Override
    String getRelativeUrl() {
        return "/profile.php";
    }

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

    public ProfilePage enterNewPassword1IntoInput(String newPassword){
        enterTextIntoElement(inputNewPassword,newPassword);
        return this;
    }

    public ProfilePage enterNewPassword2IntoInput(String newPassword2){
        enterTextIntoElement(inputRepeatNewPassword,newPassword2);
        return this;
    }

    public EditPasswordPage clickOnSaveNewPasswordButton(){
        clickOnElement(buttonSubmitNewPassword);
        return new EditPasswordPage(webDriver);
    }

    public ProfilePage checkIsPasswordRemindLinkDisplayed(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(linkReminder));
        Assert.assertTrue("Password reminder link in the error massage was not displayed", isElementDisplayed(linkReminder));
        return this;
    }
}
