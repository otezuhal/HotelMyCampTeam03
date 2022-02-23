package tests.E2ETest.US_01;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_0004WelcomeToOurHotelIsDisplayedTest extends TestBaseRapor {

    MainPage mainPage=new MainPage();
    Actions actions = new Actions(Driver.getDriver());

    //4- Welcome to our hotel bolumu gorunur olmali.
    @Test
    public void welcomeToOurHotelIsDisplayedTest(){
        extentTest=extentReports.createTest("welcomeToOurHotelIsDisplayedTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        ReusableMethods.waitFor(2);
        JSUtils.scrollIntoVIewJS(mainPage.mainPageWelcomeToOurHotelText);
        extentTest.info("mainPage WelcomeToOurHotel'e scrolldown yapildi");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.mainPageWelcomeToOurHotelText.isDisplayed());
        extentTest.info("mainPageWelcomeToOurHotelText'in gorunurlugu test edildi ");

       // Driver.closeDriver();
      //  extentTest.info("Driver kapatildi");

    }


}
