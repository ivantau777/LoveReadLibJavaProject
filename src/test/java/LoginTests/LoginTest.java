package LoginTests;

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

}
