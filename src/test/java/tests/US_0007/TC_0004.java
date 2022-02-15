package tests.US_0007;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_0004 {


    MainPage mainPage = new MainPage();
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void odaSilmeIslemitesti() {

        //Yonetici url ye gider
        //Sag ustteki Login butonuna tiklar
        //Yonetici olarak giris yapar
        mainPage.managerHotelMyCampGiris();
        //  Hotel Management linkine tiklar
        hotelRoomsPage.hotelManagementLinki.click();
        //Hotel Rooms butonunu tiklar
        hotelRoomsPage.hotelRoomsLinki.click();
        //ilk oda icin DETAILS butonuna tiklanir
        hotelRoomsPage.hotelRoomListDetailButton.click();
        //Sayfanin en altindaki DELETE butonuna tiklanir
        hotelRoomsPage.hotelRoomsDetailsDeleteButton.click();
        hotelRoomsPage.hotelRoomsDetailsDeleteButtondanSonrakiOkButton.click();
        //BAsarili bir sekilde silme isleminin yapildigini test eder
        softAssert.assertTrue(hotelRoomsPage.basariliSilindiTestYazisi
                .getText().contains("hotel has been deleted successfully"),"Oda silme islemi testi Failed");
        Driver.closeDriver();
        ReusableMethods.waitFor(3);
        softAssert.assertAll();


    }
}












