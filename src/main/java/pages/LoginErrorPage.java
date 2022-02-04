package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginErrorPage extends ParentPage {

    @FindBy(xpath = ".//p[contains(text(),'Возникла ошибка при вводе ')]//b[text()='Логина']")
    private WebElement messageLoginError;

    @Override
    String getRelativeUrl() {
        return "/info.php?me=login_error";
    }

    public LoginErrorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginErrorPage checkIsRedirectToLoginErrorPage(){
        checkUrl();
        return this;
    }

    public LoginErrorPage checkIsLoginErrorMessageDisplayed(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(messageLoginError));
        Assert.assertTrue("Login error message is not displayed",isElementDisplayed(messageLoginError));
        return this;
    }
}
