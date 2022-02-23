package tests.E2ETest.US_07;

import org.openqa.selenium.By;
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


    MainPage mainPage;
    HotelRoomsPage hotelRoomsPage;
    SoftAssert softAssert;

    @Test
    public void odaAramaTesti() throws IOException {
        softAssert = new SoftAssert();
        hotelRoomsPage = new HotelRoomsPage();
        mainPage = new MainPage();
        extentTest = extentReports.createTest("HotelRoom ", "oda arama islemi test edildi");
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
        //hotel Room search butonu erisilebilirligi test edilir
        Assert.assertTrue(hotelRoomsPage.hotelRoomListSearchButton.isEnabled());
        extentTest.pass("hotel Room search butonu erisilebilirligi test edildi");
        //istenen ozellikteki oda bilgisi girilir
        Select select = new Select(hotelRoomsPage.hotelRoomsListIdGroupTypeBox);
        select.selectByValue("6");
        //Search butonuna tiklanir
        hotelRoomsPage.hotelRoomListSearchButton.click();
        ReusableMethods.waitFor(4);
        searchButtonTest();
        extentTest.pass("Oda arama testi yapildi");
        ReusableMethods.waitFor(2);

        Actions actions = new Actions(Driver.getDriver());
         actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();
        extentTest.info("Logout yapildi");
        softAssert.assertAll();

    }

    public void searchButtonTest() {
        for (int i = 3; i < 9; i++) {
            String dinamikRoomTypeXpath = "//tr["+i+"]/td[7]";
            WebElement dinamikRoomTypeElement = Driver.getDriver().findElement(By.xpath(dinamikRoomTypeXpath));
            String actualResult = dinamikRoomTypeElement.getText();
            String expectedresult = "Single";
            softAssert.assertEquals(actualResult, expectedresult);

        }


    }
}
