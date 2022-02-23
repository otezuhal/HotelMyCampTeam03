package tests.SmokeTest.US_02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC0005 extends TestBaseRapor {
    MainPage mainpage;
    SoftAssert softAssert;
    Actions actions;
    HotelRoomsPage hotelRoomsPage;



  // Gecerli bilgileri girdikten sonraki Log-in butonunun
  // gorunurlugu-erisiebilirligi test edilmeli ve
  // basarili bir sekilde giris yapilabildigi test edilmeli
    @Test
    public void yoneticiBasariliGirisTesti() throws IOException {
        mainpage = new MainPage();
        softAssert=new SoftAssert();
        actions=new Actions(Driver.getDriver());
        hotelRoomsPage=new HotelRoomsPage();

        extentTest=extentReports.createTest("TC_0005 Positive Test","ikinci login butonuna erisim");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");
        mainpage.firstLoginLinki.click();
        extentTest.info("ilk login linline tiklandi");
        mainpage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        mainpage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        extentTest.info("Gecerli username ve password girildi");
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(mainpage.secondLoginButonu.isDisplayed());
        extentTest.info("ikinci login butonunun gorunurlugu test edildi");
        mainpage.secondLoginButonu.click();
         extentTest.info("ikinci login butonuna tiklandi");
        softAssert.assertTrue(mainpage.managerTextboxKontrol.isDisplayed());
        ReusableMethods.getScreenshot("Basarili Giris");
        extentTest.info("yonetici olarak oturum acilabildigi test edildi");
        softAssert.assertAll();
        ReusableMethods.waitFor(2);
        actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();
        Driver.closeDriver();
    }
}
