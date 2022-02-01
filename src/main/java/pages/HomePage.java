package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//a[text()='Выход']")
    private WebElement linkExit;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage checkIsExitLinkDisplayed(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(linkExit));
        isElementDisplayed(linkExit);
        return this;
    }

}
