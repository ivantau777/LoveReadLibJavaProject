package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//a[text()='Выход']")
    private WebElement linkExit;

    @FindBy(xpath = ".//a[text()='Личный кабинет']")
    private WebElement linkProfile;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage checkIsExitLinkDisplayed() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(linkExit));
        Assert.assertTrue("Exit link is not displayed", isElementDisplayed(linkExit));
        return this;
    }

    public ProfilePage clickOnMyProfileLink(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(linkProfile));
        clickOnElement(linkProfile);
        return new ProfilePage(webDriver);
    }

}
