package loginTests;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest(){
        startPage.openStartPage()
                .loginWithValidCred()
                .checkIsExitLinkDisplayed();
    }

    @Test
    public void invalidLoginTest(){
        startPage.openStartPage()
                .enterLoginIntoLoginField("ivantau7778")
                .enterPasswordIntoPasswordField(TestData.VALID_PASS)
                .clickOnCheckBoxRemember()
                .clickOnEnterButtonWithInvalidCred()
                .checkIsLoginErrorMessageDisplayed();

    }
}
