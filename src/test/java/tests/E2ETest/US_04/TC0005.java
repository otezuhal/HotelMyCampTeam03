package tests.E2ETest.US_04;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelListPage;
import pages.MainPage;
import utilities.*;

import java.io.IOException;
import java.util.List;

public class TC0005 extends TestBaseRapor {
    MainPage mainPage;
    //JSUtils jse=new JSUtils();
    Actions actions;
    HotelListPage hotelListPage;

    @Test
    public void logIn() throws IOException {
        hotelListPage = new HotelListPage();
        actions = new Actions(Driver.getDriver());
        mainPage = new MainPage();

        extentTest = extentReports.createTest("Sayfaya Yonetici olarak Giris Yapildi");

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");

        mainPage.firstLoginLinki.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        extentTest.info("Log in sayfasindaki login butonuna tiklandi");

        mainPage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        extentTest.info("Username  kutusuna Manager! datasi gonderildi");
        ReusableMethods.waitFor(1);
        mainPage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        extentTest.info("password  kutusuna Manager! datasi gonderildi");

        mainPage.secondLoginButonu.click();
        extentTest.info("ilk login linkine tiklandi");

        hotelListPage.hotelManagementLinki.click();
        extentTest.info("Hotel Management linkine gidildi");

        hotelListPage.hotelListLinki.click();
        extentTest.info("Hotel List linkine gidildi");

        hotelListPage.addHotelLinki.click();
        extentTest.info("Hotel List linkine gidildi");

        Faker faker = new Faker();
        String code = faker.code().asin();
        hotelListPage.addHotelCodeKutusu.sendKeys(code);
        extentTest.info("Hotel List linkindeki Create Hotel CodeKutusuna gris yapildi");
        String hotelName = faker.name().firstName();
        hotelListPage.addHotelNameBoxKutusu.sendKeys(hotelName);
        extentTest.info("Hotel List linkindeki Create Hotel Name Kutusuna gris yapildi");
        String hotelAddress = faker.address().fullAddress();
        hotelListPage.addHotelAddressBoxElementi.sendKeys(hotelAddress);
        extentTest.info("Hotel List linkindeki Create Hotel Address Kutusuna gris yapildi");
        String hotelPhone = faker.phoneNumber().phoneNumber();
        hotelListPage.addHotelPhoneBoxKutusu.sendKeys(hotelPhone);
        extentTest.info("Hotel List linkindeki Create Hotel Phone Kutusuna gris yapildi");
        String hotelMail = "team3ortakhesap@gmail.com";
        hotelListPage.addHotelEmailBoxKutusu.sendKeys(hotelMail);
        extentTest.info("Hotel List linkindeki Create Hotel Mail Kutusuna gris yapildi");

        Select select = new Select(hotelListPage.addHotelDropdown);
        List<WebElement> addHotelDropDown = select.getOptions();
        for (WebElement each : addHotelDropDown
        ) {
            System.out.println("record sayisi : " + each.getText());
        }
        for (int i = 0; i < 2; i++) {
            JSUtils.scrollIntoVIewJS(hotelListPage.addHotelDropdown);
            ReusableMethods.waitFor(0);
            select.selectByIndex(i + 1);
            //ReusableMethods.waitFor(0);
            //ReusableMethods.getScreenshot("en altta dropdown menusunde "+(i+1)+" nci record secildi");
        }
        extentTest.info("Hotel List linkindeki Create HotelDropdown Kutusuna gris yapildi");
        mainPage.bekle(1);
        hotelListPage.addHotelSaveButonu.click();
        extentTest.info("Hotel List linkindeki Create Hotel Save butonuna tıklandi");
        ReusableMethods.getScreenshot("US04/Create Hotel Page");
        extentTest.info("Hotel List linkindeki Create Hotel Save butonuna tıklandiginin resmi alindi");
        String expectedResultText = "Hotel was inserted successfully";
        String actualResultText = hotelListPage.addHotelAlertMesajiElementi.getText();
        extentTest.info("HotelRoom was inserted successfully yazısının görünürlüğü test edildi");
        hotelListPage.addHotelokButonu.click();
        extentTest.info("Hotel List linkindeki Create Hotel OK butonuna tıklandi");
        //16-"HotelRoom was inserted successfully" yazısının görünürlüğü test edilmeli
        Assert.assertTrue(hotelListPage.basariliGirisYaziElementi.isDisplayed(), "HotelRoom was inserted successfully Yazisigorunmedi");

        hotelListPage.detailsHotelListButonu.click();
        hotelListPage.IDHotelCodeKutusu.click();

        actions.click(hotelListPage.IDHotelCodeKutusu)
                .sendKeys(Keys.TAB).sendKeys("1620")
                .sendKeys(Keys.TAB).sendKeys("Shelton Schumm Jr.")
                .sendKeys(Keys.TAB).sendKeys("1294 Sang Well, North Bernie, MS 47011-9638")
                .sendKeys(Keys.TAB).sendKeys("040.682.3356")
                .sendKeys(Keys.TAB).sendKeys("team3ortakhesap@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        hotelListPage.ListOfHotelsSearchButonu.click();
        ReusableMethods.getScreenshot("US04/Search Page");
        extentTest.info("Hotel List linkindeki Create Hotel CodeKutusuna kod bilgisi ile arama sonucunun dogru olup olmadıgi kontrol edildi");
        extentTest.info("Hotel List linkindeki Create Hotel'e Shelton Schumm Jr. isim bilgisi ile arama sonucunun dogru olup olmadıgi kontrol edildi");
        extentTest.info("Hotel List linkindeki Create Hotel'e 1294 Sang Well, North Bernie, MS 47011-9638 adres bilgisi ile arama sonucunun dogru olup olmadıgi kontrol edildi");
        extentTest.info("Hotel List linkindeki Create Hotel'e 040.682.3356 telefen no bilgisi ile arama sonucunun dogru olup olmadıgi kontrol edildi");
        extentTest.info("Hotel List linkindeki Create Hotel'e team3ortakhesap@gmail.com mail adres bilgisi ile arama sonucunun dogru olup olmadıgi kontrol edildi");

        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();

    }
}
