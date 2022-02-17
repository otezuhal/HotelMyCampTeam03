package tests.US_0007;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_0005 extends TestBaseRapor {


    MainPage mainPage = new MainPage();
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void roomUpdateTesti() throws IOException {
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
        //General Data kismindaki bilgiler degistirilir
        hotelRoomsPage.dataUpdate();
        extentTest.info("oda bilgileri degistirildi");
        //SAVE butonuna tiklanir
        hotelRoomsPage.hotelRoomsDetailsSaveButton.click();
        extentTest.info("save butonuna tiklandi");
        //HotelRoom was updated successfully yazisi gorulur
        softAssert.assertTrue(hotelRoomsPage.hotelRoomsDetailsSuccefullWort.isDisplayed(),"HotelRoom was updated successfully gorulebilir degil");
        extentTest.fail("Oda bilgilerinin basarili bir sekild degismesi testi failed");
       String actualResult=hotelRoomsPage.hotelRoomsDetailsSuccessfullyUpdateWort.getText();
        System.out.println(actualResult);
       String expectedresult="HotelRoom was updated successfully";
       softAssert.assertTrue(actualResult.contains(expectedresult),"actualResult HotelRoom was updated successfully icermiyor");
        extentTest.fail("Oda bilgilerinin basarili bir sekild degismesi testi failed");
       //normalde bu yazi goruluyor ama otomasyonda failed cikiyor
        ReusableMethods.getScreenshot("Oda bilgileri Update");
        ReusableMethods.waitFor(3);
        hotelRoomsPage.hotelRoomsDetailsDeleteButtondanSonrakiOkButton.click();
        ReusableMethods.waitFor(3);
       // Driver.closeDriver();
        softAssert.assertAll();
        ReusableMethods.waitFor(3);


    }
}