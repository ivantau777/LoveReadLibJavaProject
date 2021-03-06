package profileTests;

import baseTest.BaseTest;
import libs.TestData;
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

    private String newPassword = "1234567890";
    @Test
    public void changingPassword(){
        startPage.openStartPage()
                .loginWithValidCred()
                .clickOnMyProfileLink()
                .changePasswordOnSpecified(newPassword)

                .clickOnExitLink()
                .enterLoginIntoLoginField(TestData.VALID_LOGIN)
                .enterPasswordIntoPasswordField(newPassword)
                .clickOnEnterButtonWithValidCred()
                .checkIsExitLinkDisplayed()

                .clickOnMyProfileLink()
                .changePasswordOnSpecified(TestData.VALID_PASS);
    }
}
