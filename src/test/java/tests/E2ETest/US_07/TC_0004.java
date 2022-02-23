package tests.E2ETest.US_07;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_0004 extends TestBaseRapor {

    Actions actions;
    MainPage mainPage;
    HotelRoomsPage hotelRoomsPage;
    SoftAssert softAssert;

    @Test
    public void odaSilmeIslemiTesti() throws IOException {
        softAssert = new SoftAssert();
        hotelRoomsPage = new HotelRoomsPage();
        mainPage = new MainPage();

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
        //Sayfanin en altindaki DELETE butonuna tiklanir
        hotelRoomsPage.hotelRoomsDetailsDeleteButton.click();
        extentTest.info("Hotel delete butonuna tiklandi");
        ReusableMethods.waitFor(2);
        hotelRoomsPage.hotelRoomsDetailsDeleteButtondanSonrakiOkButton.click();
        //BAsarili bir sekilde silme isleminin yapildigini test eder
        softAssert.assertTrue(hotelRoomsPage.basariliSilindiTestYazisi
                .getText().contains("hotel has been deleted successfully"),"Oda silme islemi testi Failed");
       extentTest.fail("oda silme islemi failed");
        hotelRoomsPage.hotelRoomsDetailsDeleteButtondanSonrakiOkButton.click();
        ReusableMethods.waitFor(3);
        actions=new Actions(Driver.getDriver());
        actions.doubleClick(hotelRoomsPage.hotelRommsDetailsOkButton).perform();
        actions.click(hotelRoomsPage.hotelRommsDetailsOkButton).perform();
        actions.click(hotelRoomsPage.hotelRommsDetailsOkButton).perform();
        extentTest.info("hotelRommsDetailsOkButton uzun ugraslar sonucu tiklanabildi");
        ReusableMethods.waitFor(2);
        actions=new Actions(Driver.getDriver());
        actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();
        extentTest.info("Logout yapildi");
        softAssert.assertAll();


    }
}












