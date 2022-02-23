package tests.E2ETest.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_0001MainPageNavbarButtonTest extends TestBaseRapor {

    MainPage mainPage=new MainPage();


    //1-Home, rooms, Restaurant, About, Blog, Contact ve log in butonlari gorunur olmali
    @Test
    public void mainPageNavbarButtonsIsDisplayedTest(){
        extentTest=extentReports.createTest("mainPageNavbarButtonsIsDisplayedTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.mainPageNavbarHomeButton.isDisplayed());
        extentTest.info("mainPageNavbarHomeButton'un gorunurlugu test edildi ");
        Assert.assertTrue(mainPage.mainPageNavbarRoomsButton.isDisplayed());
        extentTest.info("mainPageNavbarRoomsButton'un gorunurlugu test edildi ");
        Assert.assertTrue(mainPage.mainPageNavbarRestaurantButton.isDisplayed());
        extentTest.info("mainPageNavbarRestaurantButton'un gorunurlugu test edildi ");
        Assert.assertTrue(mainPage.mainPageNavbarAboutButton.isDisplayed());
        extentTest.info("mainPageNavbarAboutButton'un gorunurlugu test edildi ");
        Assert.assertTrue(mainPage.mainPageNavbarContactButton.isDisplayed());
        extentTest.info("mainPageNavbarContactButton'un gorunurlugu test edildi ");
        Assert.assertTrue(mainPage.mainPageNavbarLoginButton.isDisplayed());
        extentTest.info("mainPageNavbarLoginButton'un gorunurlugu test edildi ");
//        Driver.closeDriver();
//        extentTest.info("Driver kapatildi");

    }


}
