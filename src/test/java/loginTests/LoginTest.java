package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest(){
        startPage.openStartPage()
                .enterLoginIntoLoginField("ivantau777")
                .enterPasswordIntoPasswordField("123456789")
                .clickOnCheckBoxRemember()
                .clickOnEnterButtonWithValidCred()
                .checkIsExitLinkDisplayed();
    }

    @Test
    public void invalidLoginTest(){
        startPage.openStartPage()
                .enterLoginIntoLoginField("ivantau7778")
                .enterPasswordIntoPasswordField("123456789")
                .clickOnCheckBoxRemember()
                .clickOnEnterButtonWithInvalidCred()
                .checkIsLoginErrorMessageDisplayed();

    }
}
