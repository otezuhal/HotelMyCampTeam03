package tests.US_0007;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;

public class TC_0001 {

    MainPage mainPage=new MainPage();
    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void roomButtonTest(){

        //Yonetici url ye gider
        //Sag ustteki Login butonuna tiklar
        //Yonetici olarak giris yapar
        mainPage.managerHotelMyCampGiris();
      //  Hotel Management linkine tiklar
        hotelRoomsPage.hotelManagementLinki.click();
        //Hotel Rooms butonu gorulebilir olmalidir
      softAssert.assertTrue(hotelRoomsPage.hotelRoomsLinki.isDisplayed());
        //Hotel Rooms butonu secilebilir olmalidir
       softAssert.assertTrue(hotelRoomsPage.hotelRoomsLinki.isSelected());
        softAssert.assertAll();
        Driver.closeDriver();

    }



}
