package tests.E2ETest.US_07;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_0001 extends TestBaseRapor {

    MainPage mainPage;
    HotelRoomsPage hotelRoomsPage;
    SoftAssert softAssert;

    @Test
    public void roomButtonTest() throws IOException {
        softAssert=new SoftAssert();
        hotelRoomsPage=new HotelRoomsPage();
        mainPage=new MainPage();
        extentTest=extentReports.createTest("HotelRoom ","oda arama islemi test edildi");
        //Yonetici url ye gider
        //Sag ustteki Login butonuna tiklar
        //Yonetici olarak giris yapar
        mainPage.managerHotelMyCampGiris();
        extentTest.info("Siteye giris ve Login girisi yapildi");
      //  Hotel Management linkine tiklar
        hotelRoomsPage.hotelManagementLinki.click();
        extentTest.info("Hotel Management linkine tiklandi");
        //Hotel Rooms butonu gorulebilir olmalidir
        ReusableMethods.waitFor(3);
      softAssert.assertTrue(hotelRoomsPage.hotelRoomsLinki.isDisplayed(),"hotelRooms butonu gorulebilirlik testi Failed");
     extentTest.pass("hotelRooms linkinin gorulebilirligi test edildi");
        //Hotel Rooms butonu erisileblir olmalidir
       softAssert.assertTrue(hotelRoomsPage.hotelRoomsLinki.isEnabled(),"hotelRomms Butonu erisilebilirligi Testi Failed");
       extentTest.pass("hotelRomms Butonu erisilebilirligi test edildi");
       ReusableMethods.waitFor(3);
        ReusableMethods.waitFor(3);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();
        extentTest.info("Logout yapildi");
        softAssert.assertAll();
    }

}
