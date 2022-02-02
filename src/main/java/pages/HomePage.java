package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//a[text()='Выход']")
    private WebElement linkExit;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private boolean isExitLinkDisplayed() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(linkExit));
        return isElementDisplayed(linkExit);
    }

    public HomePage checkIsExitLinkDisplayed() {
        Assert.assertTrue("Exit link is not displayed", isElementDisplayed(linkExit));
        return this;
    }

}
