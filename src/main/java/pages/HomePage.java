package pages;


import org.openqa.selenium.WebDriver;


public class HomePage extends ParentPageWithUserSideBlocks {


    @Override
    String getRelativeUrl() {
        return "";
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


}
