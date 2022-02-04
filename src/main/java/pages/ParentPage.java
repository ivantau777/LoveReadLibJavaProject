package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;


abstract public class ParentPage {

    Logger logger = Logger.getLogger(getClass());

    WebDriver webDriver;

    WebDriverWait webDriverWait10;

    protected String baseUrl = "http://loveread.ec";

    abstract String getRelativeUrl();

    protected void  checkUrl(){
        Assert.assertEquals("Invalid page", baseUrl + getRelativeUrl(),webDriver.getCurrentUrl());
    }

    protected void checkUrlWithPattern(){
        Assert.assertThat("Invalid page",webDriver.getCurrentUrl(),containsString(baseUrl + getRelativeUrl()));
    }

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, 10);
    }

    protected void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into field");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            if (webElement.isDisplayed()) {
                logger.info("Element is displayed");
                return true;
            } else {
                logger.info("Element is not displayed");
                return false;
            }
        } catch (Exception e) {
            logger.info("The element was not found");
            return false;
        }
    }


    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
}
