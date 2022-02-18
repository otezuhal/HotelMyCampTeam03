package tests.US_0007;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import javax.swing.*;
import java.io.IOException;

public class TC_0001 extends TestBaseRapor {

    MainPage mainPage=new MainPage();
    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void roomButtonTest() throws IOException {
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
      ReusableMethods.getScreenshot("roomButtonTEst");
     extentTest.pass("hotelRooms linkinin gorulebilirligi test edildi");
      //normalde bu Webelment goruluyor ama otomasyonda failed cikiyor
        //Hotel Rooms butonu erisileblir olmalidir
       softAssert.assertTrue(hotelRoomsPage.hotelRoomsLinki.isEnabled(),"hotelRomms Butonu erisilebilirligi Testi Failed");
       extentTest.pass("hotelRomms Butonu erisilebilirligi test edildi");
       ReusableMethods.waitFor(3);

      //  Driver.closeDriver();
        ReusableMethods.waitFor(3);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();

        softAssert.assertAll();
    }

}
