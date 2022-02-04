package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditPasswordPage extends ParentPageWithUserSideBlocks{

    @FindBy(xpath = ".//p[contains(text(),'Смена пароля прошла успешно')]")
    private WebElement successChangePassMessage;

    @Override
    String getRelativeUrl() {
        return "/info.php?me=edit_password";
    }

    public EditPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public EditPasswordPage checkIsRedirectToChangePasswordPage(){
        checkUrl();
        return this;
    }

    public EditPasswordPage checkIsSuccessChangePassMessDisplayed(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(successChangePassMessage));
        Assert.assertTrue("Success change password message is not displayed", isElementDisplayed(successChangePassMessage));
        return this;
    }
}
