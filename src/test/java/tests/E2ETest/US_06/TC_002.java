package tests.E2ETest.US_06;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_002  extends TestBaseRapor{
    //Hotel Management  a tıklanılmalı
    //HotelRooms a tıklanılmalı
    //'LIST OF HOTELROOMS' yazısının görünülürlüğü test edilmeli

    @Test
    public void hotelRoomsSayfasinaGirisTesti(){
        extentTest=extentReports.createTest("hotelRoomSayfasiTesti","hotelRooms sayfasina yontici olarak basarili giris yapildi");
        MainPage mainPage=new MainPage();
        HotelRoomsPage hotelRoomPage=new HotelRoomsPage();
        mainPage.managerHotelMyCampGiris();
        hotelRoomPage.hotelManagementLinki.click();
        extentTest.info("hotelManagement linkine tiklandi");
        hotelRoomPage.hotelRoomsLinki.click();
        extentTest.info("hotelRoom linkine tiklandi");
        Assert.assertTrue(hotelRoomPage.listOfHotelYazisi.isDisplayed());

       extentTest.pass("listOfHotel yazisi görüldü");

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hotelRoomPage.managerLink).perform();
        ReusableMethods.waitFor(2);
        hotelRoomPage.logOutButton.click();
        extentTest.info("basarili cikis yapildi");
    }


}
