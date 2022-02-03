package profileTests;

import baseTest.BaseTest;
import org.junit.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void changingEmailToTheAlreadyExisting(){
        startPage.openStartPage()
                .loginWithValidCred()
                .clickOnMyProfileLink()
                .checkIsRedirectToProfilePage()
                .enterEmailIntoInput("ivan.taurus777@gmail.com")
                .clickOnSaveNewEmailButton()
                .checkIsPasswordRemindLinkDisplayed();
    }

    @Test
    public void changingPassword(){
        startPage.openStartPage()
                .loginWithValidCred()
                .clickOnMyProfileLink()
                .checkIsRedirectToProfilePage()
                .enterNewPassword1IntoInput("123456789")
                .enterNewPassword2IntoInput("123456789")
                .clickOnSaveNewPasswordButton()
                .checkIsSuccessChangePassMessDisplayed();
    }
}
