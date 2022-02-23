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

public class TC_0005 extends TestBaseRapor {


    MainPage mainPage;
    HotelRoomsPage hotelRoomsPage;
    SoftAssert softAssert;
    Actions actions;

    @Test
    public void roomUpdateTesti() throws IOException {
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
        //General Data kismindaki bilgiler degistirilir
        hotelRoomsPage.dataUpdate();
        extentTest.info("oda bilgileri degistirildi");
        //SAVE butonuna tiklanir
        hotelRoomsPage.hotelRoomsDetailsSaveButton.click();
        extentTest.info("save butonuna tiklandi");
        //HotelRoom was updated successfully yazisi gorulur
        String actualSaveText= hotelRoomsPage.hotelRoomsDetailsSuccefullWort.getAttribute("innerText");
        String expectedSaveText="HotelRoom was updated successfully";
        softAssert.assertTrue(actualSaveText.equals(expectedSaveText));
        extentTest.pass("Oda bilgilerinin basarili bir sekilde degistirildi yazisi goruldu");
        ReusableMethods.getScreenshot("US07/Oda bilgileri Update");
        ReusableMethods.waitFor(2);
        hotelRoomsPage.hotelRoomsDetailsDeleteButtondanSonrakiOkButton.click();
        extentTest.info("OK BUTONU CLICK LENDI");
        ReusableMethods.waitFor(2);
        extentTest.info("Logout yapildi");
        actions=new Actions(Driver.getDriver());
        actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();
        softAssert.assertAll();
       // Driver.closeDriver();


    }


    }