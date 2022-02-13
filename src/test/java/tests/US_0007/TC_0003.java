package tests.US_0007;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;

public class TC_0003 {


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
        //Arama  otel bilgileri girilir
        hotelRoomsPage.listeEkranindaHotelRoomArama();
        //Search butonuna tiklanir
        hotelRoomsPage.hotelRoomListSearchButton.click();
        //Aranan odanin bilgileri ekranina gidilmeli



    }
}
