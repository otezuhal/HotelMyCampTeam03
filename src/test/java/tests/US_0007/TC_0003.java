package tests.US_0007;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_0003 extends TestBaseRapor {


    MainPage mainPage = new MainPage();
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void odaAramaTesti() throws IOException {
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
        //Arama  otel bilgileri girilir
        hotelRoomsPage.listeEkranindaHotelRoomArama();
        String title=Driver.getDriver().getTitle();
        //Search butonuna tiklanir
        Assert.assertTrue(hotelRoomsPage.hotelRoomListSearchButton.isEnabled());
        extentTest.info("hotel Room search butonu erisilebilirligi test edildi");
        hotelRoomsPage.hotelRoomListSearchButton.click();
        //Aranan odanin bilgileri ekranina gidilmeli
        softAssert.assertFalse(Driver.getDriver().getTitle().equals(title),"Aranan odaya gecis testi Failed");
        extentTest.fail("hotel Rooms search butonu erisilmiyor.");
        ReusableMethods.getScreenshot("hotelRoomsSearchButonClicken");
        ReusableMethods.waitFor(3);



      //  Driver.closeDriver();
        ReusableMethods.waitFor(3);

        // Bu test manuelde failed
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();
        softAssert.assertAll();

    }





}
