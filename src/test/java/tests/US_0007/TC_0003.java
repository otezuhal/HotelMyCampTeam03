package tests.US_0007;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_0003 {


    MainPage mainPage = new MainPage();
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void odaAramaTesti() throws IOException {

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
        String title=Driver.getDriver().getTitle();
        //Search butonuna tiklanir
        Assert.assertTrue(hotelRoomsPage.hotelRoomListSearchButton.isEnabled());
        hotelRoomsPage.hotelRoomListSearchButton.click();
        //Aranan odanin bilgileri ekranina gidilmeli
        softAssert.assertFalse(Driver.getDriver().getTitle().equals(title),"Aranan odaya gecis testi Failed");
        ReusableMethods.getScreenshot("hotelRoomsSearchButonClicken");
        ReusableMethods.waitFor(3);
        softAssert.assertAll();
        Driver.closeDriver();
        ReusableMethods.waitFor(3);

        // Bu test manuelde failed
    }
}
