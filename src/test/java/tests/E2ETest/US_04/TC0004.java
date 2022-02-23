package tests.E2ETest.US_04;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelListPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC0004 extends TestBaseRapor {
    MainPage mainPage;
    Actions actions;
    HotelListPage hotelListPage;

    @Test
    public void logIn () throws IOException {
        hotelListPage=new HotelListPage();
        actions=new Actions(Driver.getDriver());
        mainPage=new MainPage();

        //1-www.hotelmycamp.com url'sine gidiniz
        extentTest = extentReports.createTest("Sayfaya Yonetici olarak Giris Yapildi");

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");

        //2-Sağ üstteki "Login"butonuna tıklayın
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
        extentTest.info("Add Hotel Buttonuna tıklandiHotel List linkine gidildi");
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        String code=faker.code().asin();
        String hotelName=faker.name().firstName();
        String hotelAddress=faker.address().fullAddress();
        String hotelPhone=faker.phoneNumber().phoneNumber();
        String hotelMail="team3ortakhesap@gmail.com";
        actions.click(hotelListPage.addHotelCodeKutusu).perform();
        extentTest.info("Hotel List linkindeki Create Hotel CodeKutusuna gris yapildi");
        actions.sendKeys(code).sendKeys(Keys.TAB).sendKeys(hotelName).perform();
        extentTest.info("Hotel List linkindeki Create Hotel Name Kutusuna gris yapildi");
        actions.sendKeys(Keys.TAB).sendKeys(hotelAddress).perform();
        extentTest.info("Hotel List linkindeki Create Hotel Address Kutusuna gris yapildi");
        actions.sendKeys(Keys.TAB).sendKeys(hotelPhone).perform();
        extentTest.info("Hotel List linkindeki Create Hotel CodeKutusuna gris yapildi");
        actions.sendKeys(Keys.TAB).sendKeys(hotelMail).perform();
        extentTest.info("Hotel List linkindeki Create Hotel Mail Kutusuna gris yapildi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select select=new Select(hotelListPage.addHotelDropdown);
        select.selectByVisibleText("Hotel Type1");
        extentTest.info("Hotel List linkindeki Create HotelDropdown Kutusuna gris yapildi");

        mainPage.bekle(1);
        hotelListPage.addHotelSaveButonu.click();
        extentTest.info("Hotel List linkindeki Create Hotel Save butonuna tıklandi");

        ReusableMethods.getScreenshot("US04/Create Hotel Page,Hotel Save");
        String expectedResultText = "Hotel was inserted successfully";
        mainPage.bekle(3);
     //   String actualResultText = hotelListPage.addHotelAlertMesajiElementi.getText();

        String actualResultText= hotelListPage.addHotelAlertMesajiElementi.getAttribute("innerText");
        Assert.assertTrue(actualResultText.contains(expectedResultText));
        System.out.println("actualResultText = Hotel was inserted successfully " + actualResultText);

        hotelListPage.addHotelokButonu.click();
        extentTest.info("Hotel List linkindeki Create Hotel OK butonuna tıklandi");

        Assert.assertTrue(hotelListPage.basariliGirisYaziElementi.isDisplayed());
        extentTest.info("HotelRoom was inserted successfully yazısının görünürlüğü test edildi");

        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();



    }



}