package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ArchiveSearchPage extends ParentPageWithUserSideBlocks{

    @FindBy(xpath = ".//p[@class='take_h2']")
    private WebElement headerOfArchivePage;

    @Override
    String getRelativeUrl() {
        return "/index_book.php?id_genre=1&p=";
    }

    public ArchiveSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ArchiveSearchPage checkIsRedirectToArchiveSearchPage(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(headerOfArchivePage));
        Assert.assertTrue("Header of archive page is not displayed",isElementDisplayed(headerOfArchivePage));
        checkUrlWithPattern();
        return this;
    }

    public ArchiveSearchPage checkIsHeaderOfArchivePageCorrect(String numberOfThePage){
        Assert.assertEquals("Header of archive page is incorrect","Архив книг - страница № " + numberOfThePage,headerOfArchivePage.getText());
        return this;
    }


}
