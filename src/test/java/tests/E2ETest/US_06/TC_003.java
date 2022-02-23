package tests.E2ETest.US_06;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_003  extends TestBaseRapor {
    //ADD HOTELROOM butonuna tıklanılmalı
    //'Create Hotelroom' yazısının görünürlüğü test edilmeli
    @Test
    public void addHotelRoomTesti(){
        MainPage mainPage=new MainPage();
        extentTest=extentReports.createTest("addHotelRoomTesti","addHotelRoom butonu basarili sekilde tiklandi");
        HotelRoomsPage hotelRoomPage=new HotelRoomsPage();
        mainPage.managerHotelMyCampGiris();
        hotelRoomPage.hotelManagementLinki.click();
        hotelRoomPage.hotelRoomsLinki.click();
        hotelRoomPage.addHotelRoomButtonu.click();
        Assert.assertTrue(hotelRoomPage.createHotelRoomYazisi.isDisplayed());

        extentTest.pass("createHotelRoom yazisi goruldu");

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hotelRoomPage.managerLink).perform();
        ReusableMethods.waitFor(2);
        hotelRoomPage.logOutButton.click();
        extentTest.info("basarili cikis yapildi");
    }



}
