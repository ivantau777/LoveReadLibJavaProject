package bookArchiveTests;

import baseTest.BaseTest;
import org.junit.Test;


public class BookArchiveTests extends BaseTest {

    private String numberOfPageForSearch = "13";
    @Test
    public void searchArchivePageByUserTest(){
        startPage.openStartPage()
                .loginWithValidCred()
                .enterNumberOfPageForSearch(numberOfPageForSearch)
                .clickOnSearchPageInArchiveButton()
                .checkIsHeaderOfArchivePageVisible()
                .checkIsHeaderOfArchivePageCorrect(numberOfPageForSearch);
    }
}
