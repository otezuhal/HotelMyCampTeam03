package tests.US_0007;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_0002 extends TestBaseRapor {


    MainPage mainPage = new MainPage();
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void hotelListesiGorunurlukTesti() throws IOException {
        extentTest=extentReports.createTest("HotelRoom ","oda arama islemi test edildi");
        //Yonetici url ye gider
        //Sag ustteki Login butonuna tiklar
        //Yonetici olarak giris yapar
        mainPage.managerHotelMyCampGiris();
        extentTest.info("Siteye giris ve Login girisi yapildi");
        //  Hotel Management linkine tiklar
        hotelRoomsPage.hotelManagementLinki.click();
        extentTest.info("Hotel Management linkine tiklandi");
        //Hotel Rooms butonunu tiklar
        hotelRoomsPage.hotelRoomsLinki.click();
        extentTest.info("Hotel Rooms linkine tiklandi");
        //LIST OF HOTELROOMS yazisini gorur
        softAssert.assertTrue(hotelRoomsPage.listOfHotelRoomsYazisi.isDisplayed());
        extentTest.pass("Liste gorunurlugu test edildi");
        ReusableMethods.getScreenshot("RoomsLIst Gorunurluk");
        ReusableMethods.waitFor(3);

      //  Select select=new Select(hotelRoomsPage.managerLink);
      //  select.selectByIndex(0);
      //  Driver.closeDriver();
        ReusableMethods.waitFor(3);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();
        softAssert.assertAll();





    }
}