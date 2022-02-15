package tests.US_0007;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_0005 {


    MainPage mainPage = new MainPage();
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void roomUpdateTesti() {

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
        //General Data kismindaki bilgiler degistirilir
        hotelRoomsPage.dataUpdate();
        //SAVE butonuna tiklanir
        hotelRoomsPage.hotelRoomsDetailsSaveButton.click();
        //HotelRoom was updated successfully yazisi gorulur
        softAssert.assertTrue(hotelRoomsPage.hotelRoomsDetailsSuccefullWort.isDisplayed(),"HotelRoom was updated successfully gorulebilir degil");
        ReusableMethods.waitFor(3);
        hotelRoomsPage.hotelRoomsDetailsDeleteButtondanSonrakiOkButton.click();
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        softAssert.assertAll();





    }
}