package tests.E2ETest.US_04;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelListPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC0003 extends TestBaseRapor {
    MainPage mainPage;
    HotelListPage hotelListPage;
    Actions actions;
    SoftAssert softAssert;

    @BeforeClass
    public void baslangicTest(){
        actions = new Actions(Driver.getDriver());
        softAssert = new SoftAssert();
        hotelListPage = new HotelListPage();
        mainPage = new MainPage();
        extentTest = extentReports.createTest("Sayfaya Yonetici olarak Giris Yapildi");
        //1-www.hotelmycamp.com url'sine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
       extentTest.info("Log in sayfasindaki login butonuna tiklandi");
        //2-Sağ üstteki "Login"butonuna tıklayın
        mainPage.firstLoginLinki.click();
        actions.
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                perform();

        extentTest.info("Username  kutusuna Manager! datasi gonderildi");
        //3-username  kutusuna manager datasi gonderilir (sendkeys)
        mainPage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        ReusableMethods.waitFor(1);

        //4-ve password  kutusuna Manager! (datasi gonderilir sendkeys)
        mainPage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        extentTest.info("password  kutusuna Manager! datasi gonderildi");

        //5-"Login" Butonuna tıklayın
        mainPage.secondLoginButonu.click();
        extentTest.info("ilk login linkine tiklandi");

        //6-"Hotel Management" menüsüne tıklayın
        hotelListPage.hotelManagementLinki.click();
        extentTest.info("Hotel Management linkine gidildi");

        //7-"Hotel List" menüsüne tıklayın
        hotelListPage.hotelListLinki.click();
        extentTest.info("Hotel List linkine gidildi");

        //8-"Add Hotel" Buttonuna tıklayın
        hotelListPage.addHotelLinki.click();
        extentTest.info("Hotel List linkine gidildi");
    }

    @Test(priority = 1)
    public void codeNegativeTest() throws IOException, InterruptedException {
        hotelListPage.addHotelCodeKutusu.sendKeys(ConfigReader.getProperty("HMCAddUserWrongCode"));
        actions.sendKeys(Keys.END).perform();
        hotelListPage.addHotelSaveButonu.click();
        softAssert.assertTrue(hotelListPage.addHotelCodeKutusu.isDisplayed());
        ReusableMethods.getScreenshot("tumSayfa");
        hotelListPage.addHotelCodeKutusu.clear();
    }

    @Test(priority = 2)
    public void codePositiveTest() throws InterruptedException, IOException {
        Driver.getDriver().getCurrentUrl();
        //ReusableMethods.waitForVisibility(hotelListPage.addHotelCodeKutusu, 5);

       hotelListPage.addHotelCodeKutusu.sendKeys(ConfigReader.getProperty("HMCAddUSerTrueCode"));
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       mainPage.bekle(1);
       hotelListPage.addHotelSaveButonu.click();
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       softAssert.assertFalse(hotelListPage.addHotelCodeKutusuIncorrect.isDisplayed());
       ReusableMethods.getScreenshot("tumSayfa");
    }

    @Test(priority = 3)
    public void userNameNegativeTest() throws IOException, InterruptedException {
        hotelListPage.addHotelNameBoxKutusu.sendKeys(ConfigReader.getProperty("HMCCreateHotelWrongUserName"));
        actions.sendKeys(Keys.END).perform();
        hotelListPage.addHotelSaveButonu.click();
        softAssert.assertTrue(hotelListPage.addHotelNameBoxKutusuIncorrect.isDisplayed());
        ReusableMethods.getScreenshot("tumSayfa");
        hotelListPage.addHotelNameBoxKutusu.clear();
    }

    @Test(priority = 4)
    public void userNamePositiveTest() throws InterruptedException, IOException {
        hotelListPage.addHotelNameBoxKutusu.sendKeys(ConfigReader.getProperty("HMCCreateHotelTrueUserName"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        mainPage.bekle(1);
        hotelListPage.addHotelSaveButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertFalse(hotelListPage.addHotelNameBoxKutusuIncorrect.isDisplayed());
        ReusableMethods.getScreenshot("tumSayfa");
    }

    @Test(priority = 5)
    public void adresNameNegativeTest() throws IOException, InterruptedException {
        hotelListPage.addHotelAddressBoxElementi.sendKeys(ConfigReader.getProperty("HMCAddUserWrongAdres"));
        actions.sendKeys(Keys.END).perform();
        hotelListPage.addHotelSaveButonu.click();
        softAssert.assertTrue(hotelListPage.addHotelAddressBoxElementiIncorrect.isDisplayed());
        ReusableMethods.getScreenshot("tumSayfa");
        hotelListPage.addHotelAddressBoxElementi.clear();
    }

    @Test(priority = 6)
    public void adresNamePositiveTest() throws InterruptedException, IOException {
        hotelListPage.addHotelAddressBoxElementi.sendKeys(ConfigReader.getProperty("HMCAddUserTrueAdres"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        mainPage.bekle(1);
        hotelListPage.addHotelSaveButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertFalse(hotelListPage.addHotelAddressBoxElementiIncorrect.isDisplayed());
        ReusableMethods.getScreenshot("tumSayfa");
    }

    @Test(priority = 7)
    public void phoneNameNegativeTest() throws IOException, InterruptedException {
        hotelListPage.addHotelPhoneBoxKutusu.sendKeys(ConfigReader.getProperty("HMCCreateHotelWrongPhone"));
        actions.sendKeys(Keys.END).perform();
        hotelListPage.addHotelSaveButonu.click();
        softAssert.assertTrue(hotelListPage.addHotelPhoneBoxKutusuIncorrect.isDisplayed());
        ReusableMethods.getScreenshot("tumSayfa");
        hotelListPage.addHotelPhoneBoxKutusu.clear();
    }

    @Test(priority = 8)
    public void phoneNamePositiveTest() throws InterruptedException, IOException {
        hotelListPage.addHotelPhoneBoxKutusu.sendKeys(ConfigReader.getProperty("HMCCreateHotelTruePhone"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        mainPage.bekle(1);
        hotelListPage.addHotelSaveButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertFalse(hotelListPage.addHotelPhoneBoxKutusuIncorrect.isDisplayed());
        ReusableMethods.getScreenshot("tumSayfa");
    }

    @Test(priority = 9)
    public void emailNameNegativeTest() throws IOException, InterruptedException {
        hotelListPage.addHotelEmailBoxKutusu.sendKeys(ConfigReader.getProperty("HCMAddUserWrongEmail1"));
        actions.sendKeys(Keys.END).perform();
        hotelListPage.addHotelSaveButonu.click();
        softAssert.assertTrue(hotelListPage.addHotelEmailBoxKutusuIncorrect.isDisplayed());
        ReusableMethods.getScreenshot("tumSayfa");
        hotelListPage.addHotelEmailBoxKutusu.clear();
    }

    @Test(priority = 10)
    public void emailNamePositiveTest() throws InterruptedException, IOException {
        hotelListPage.addHotelEmailBoxKutusu.sendKeys(ConfigReader.getProperty("hcmaddusertrueemail"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        mainPage.bekle(1);
        hotelListPage.addHotelSaveButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertFalse(hotelListPage.addHotelEmailBoxKutusuIncorrect.isDisplayed());
        ReusableMethods.getScreenshot("tumSayfa");

    }

    @Test(priority = 11)
    public void geriyekalanTest() {
        Select select = new Select(hotelListPage.addHotelDropdown);
        select.selectByVisibleText("Hotel Type1");


        //15-"Save" butonuna tıklayın
        mainPage.bekle(1);
        hotelListPage.addHotelSaveButonu.click();

        //16-"HotelRoom was inserted successfully" yazısının görünürlüğü test edilmeli
        mainPage.bekle(2);
//        Assert.assertFalse(hotelListPage.basariliGirisYaziElementi.isDisplayed());

        //17. OK butonuna tıklayın.
    //    hotelListPage.addHotelokButonu.click();


        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();

    }



}
