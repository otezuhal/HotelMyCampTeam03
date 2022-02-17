package tests.US_0007;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_0004 extends TestBaseRapor {


    MainPage mainPage = new MainPage();
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void odaSilmeIslemitesti() throws IOException {
        extentTest=extentReports.createTest("HotelRoom ","oda arama islemi test edildi");
        //Yonetici url ye gider
        //Sag ustteki Login butonuna tiklar
        //Yonetici olarak giris yapar
        mainPage.managerHotelMyCampGiris();
        extentTest.info("Siteye giris ve Login girisi yapildi");
        //  Hotel Management linkine tiklar
        hotelRoomsPage.hotelManagementLinki.click();
        //Hotel Rooms butonunu tiklar
        hotelRoomsPage.hotelRoomsLinki.click();
        extentTest.info("Hotel Rooms linkine tiklandi");
        //ilk oda icin DETAILS butonuna tiklanir
        hotelRoomsPage.hotelRoomListDetailButton.click();
        extentTest.info(" Room details botonuna tiklandi");
        //Sayfanin en altindaki DELETE butonuna tiklanir
        hotelRoomsPage.hotelRoomsDetailsDeleteButton.click();
        extentTest.info("Hotel delete butonuna tiklandi");
        ReusableMethods.waitFor(3);
        hotelRoomsPage.hotelRoomsDetailsDeleteButtondanSonrakiOkButton.click();
        //BAsarili bir sekilde silme isleminin yapildigini test eder
        softAssert.assertTrue(hotelRoomsPage.basariliSilindiTestYazisi
                .getText().contains("hotel has been deleted successfully"),"Oda silme islemi testi Failed");
       extentTest.fail("oda silme islemi failed");
       ReusableMethods.getScreenshot("Oda silme islemi");
        Driver.closeDriver();
        softAssert.assertAll();
        ReusableMethods.waitFor(3);

        //BU test manueldede failed



    }
}












