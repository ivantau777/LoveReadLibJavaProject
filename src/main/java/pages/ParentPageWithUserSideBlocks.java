package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

abstract public class ParentPageWithUserSideBlocks extends ParentPage{

    @FindBy(xpath = ".//a[text()='Выход']")
    private WebElement linkExit;

    @FindBy(xpath = ".//a[text()='Личный кабинет']")
    private WebElement linkProfile;

    @FindBy(xpath = ".//input[@name='p']")
    private WebElement inputPageForSearch;

    @FindBy(xpath = ".//input[@value='Перейти']")
    private WebElement buttonSearchPageInArchive;

    public ParentPageWithUserSideBlocks(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage checkIsExitLinkDisplayed() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(linkExit));
        Assert.assertTrue("Exit link is not displayed", isElementDisplayed(linkExit));
        return new HomePage(webDriver);
    }

    public ProfilePage clickOnMyProfileLink(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(linkProfile));
        clickOnElement(linkProfile);
        return new ProfilePage(webDriver);
    }

    public StartPage clickOnExitLink(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(linkExit));
        clickOnElement(linkExit);
        return new StartPage(webDriver);
    }

    public HomePage enterNumberOfPageForSearch(String number){
        enterTextIntoElement(inputPageForSearch,number);
        return new HomePage(webDriver);
    }

    public ArchiveSearchPage clickOnSearchPageInArchiveButton(){
        clickOnElement(buttonSearchPageInArchive);
        return new ArchiveSearchPage(webDriver);
    }
}
