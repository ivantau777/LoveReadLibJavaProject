package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditPasswordPage extends ParentPage{

    @FindBy(xpath = ".//p[contains(text(),'Смена пароля прошла успешно')]")
    private WebElement successChangePassMessage;

    public EditPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public EditPasswordPage checkIsSuccessChangePassMessDisplayed(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(successChangePassMessage));
        Assert.assertTrue("Success change password message is not displayed", isElementDisplayed(successChangePassMessage));
        return this;
    }
}
