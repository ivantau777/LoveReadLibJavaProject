package profileTests;

import baseTest.BaseTest;
import org.junit.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void changingEmailToTheSame(){
        startPage.openStartPage()
                .loginWithValidCred()
                .clickOnMyProfileLink()
                .checkIsRedirectToProfilePage()
                .enterEmailIntoInput("ivan.taurus777@gmail.com")
                .clickOnSaveNewEmailButton()
                .checkIsErrorEmailChangingMessageDisplayed();
    }
}
