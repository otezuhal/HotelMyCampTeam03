package tests.E2ETest.US_04;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HotelListPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC0001 extends TestBaseRapor{
    MainPage mainPage;
    HotelListPage hotelListPage;
    Actions actions;



    @Test
    public void logIn  (){
        actions=new Actions(Driver.getDriver());
        hotelListPage= new HotelListPage();
        mainPage=new MainPage();
        mainPage=new MainPage();
        //1-www.hotelmycamp.com url'sine gidiniz
        extentTest = extentReports.createTest("Sayfaya Yonetici olarak Giris Yapildi");

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");

        //2-Sağ üstteki "Login"butonuna tıklayın
        mainPage.firstLoginLinki.click();
        actions.
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                perform();

        //3-username  kutusuna manager datasi gonderilir (sendkeys)
        extentTest.info("Log in sayfasindaki login butonuna tiklandi");
        mainPage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        extentTest.info("Username  kutusuna Manager! datasi gonderildi");
        ReusableMethods.waitFor(1);

        //4-ve password  kutusuna Manager! datasi gonderilir sendkeys)
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

        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();

    }

}