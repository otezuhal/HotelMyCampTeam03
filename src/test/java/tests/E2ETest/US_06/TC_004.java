package tests.E2ETest.US_06;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_004   extends TestBaseRapor {


@Test
    public void createNewHotelRoomTesti() {
    extentTest =extentReports.createTest("createNewHotelTesti","otel room basari ile eklenebiliyor");


    MainPage mainPage = new MainPage();
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();


    mainPage.managerHotelMyCampGiris();
    hotelRoomsPage.hotelManagementLinki.click();
    hotelRoomsPage.hotelRoomsLinki.click();
    hotelRoomsPage.addHotelRoomButtonu.click();

    extentTest.info("addHotelRoom butonu basarili sekilde tiklandi");

    Select select = new Select(hotelRoomsPage.iDHotelDropBox);
    select.selectByIndex(1);
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    actions.click(hotelRoomsPage.hotelRoomListCodeBox)
            .sendKeys(faker.address().zipCode())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.name().name())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.address().fullAddress())
            .perform();
    actions.click(hotelRoomsPage.descriptionElementi).sendKeys("tatilkeyfi").perform();
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    WebElement tasinacakHedefElement = hotelRoomsPage.hotelRoomListPriceBox;
    for (int i = 2; i <= hotelRoomsPage.priceDragandDropListesi.size(); i++) {
        WebElement tasinacakElement = Driver.getDriver().findElement(By.xpath("(//a[@href='#'])[" + i + "]"));
        actions.dragAndDrop(tasinacakElement, tasinacakHedefElement).perform();
    }

    select = new Select(hotelRoomsPage.roomTypeElementi);
    select.selectByIndex(5);

    actions.sendKeys(Keys.TAB)
            .sendKeys("2")
            .sendKeys(Keys.TAB)
            .sendKeys("3")
            .sendKeys(Keys.TAB).perform();
    hotelRoomsPage.approvedElementi.click();
    hotelRoomsPage.addHotelSaveButonu.click();
    ReusableMethods.waitFor(5);
    String expectedStr="HotelRoom was inserted successfully";
    String actualStr=hotelRoomsPage.basariliSaveYazisi.getText();
    System.out.println(actualStr);

    Assert.assertTrue(hotelRoomsPage.basariliSaveYazisi.isDisplayed(),"Yazi görülmesine ragmen otomasyon olarak failed olmuştur");

    extentTest.pass("HotelRoom was inserted successfully  yazisi goruntulendi");

    hotelRoomsPage.okButton.click();

    extentTest.info("ok buttonuna basildi");



    actions.moveToElement(hotelRoomsPage.managerLink).perform();
    ReusableMethods.waitFor(2);
    hotelRoomsPage.logOutButton.click();




}
}











