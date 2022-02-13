package tests.US_0007;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;

public class TC_0005 {


    MainPage mainPage = new MainPage();
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void roomButtonTest() {

        //Yonetici url ye gider
        //Sag ustteki Login butonuna tiklar
        //Yonetici olarak giris yapar
        mainPage.managerHotelMyCampGiris();
        //  Hotel Management linkine tiklar
        hotelRoomsPage.hotelManagementLinki.click();

        //Hotel Rooms butonunu tiklar
        hotelRoomsPage.hotelRoomsLinki.click();
        //ilk oda icin DETAILS butonuna tiklanir
        //General Data kismindaki bilgiler degistirilir
        //SAVE butonuna tiklanir
        //HotelRoom was updated successfully yazisi gorulur
    }
}