package tests.SmokeTest.US_02;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;


public class TC0004 extends TestBaseRapor {
    MainPage mainpage = new MainPage();

    SoftAssert softAssert=new SoftAssert();
    Actions actions=new Actions(Driver.getDriver());

    //Gecersiz kullanici adi ve gecersiz sifre ile
    //sisteme giris yapilamadigi test edilmeli

    @Test(priority = 1)
    public void gecersizSifreIleGirisTesti() throws IOException {
        extentTest=extentReports.createTest("TC_0004 Negative Test-1", "Gecersiz Sifre ve Gecerli Kullanici adi ile giris testi");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");
        ReusableMethods.waitFor(2);
        mainpage.firstLoginLinki.click();
        extentTest.info("ilk login linkine tiklandi");
        softAssert.assertTrue(mainpage.firstUserNameBox.isDisplayed());
        softAssert.assertTrue(mainpage.firstPasswordBox.isDisplayed());
        extentTest.info("Username ve Password kutularinin gorunurlugu test edildi");
        mainpage.pageDown();
        ReusableMethods.waitFor(2);
        mainpage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        extentTest.info("Username kutusuna gecerli kullanici adi girildi");
        mainpage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        extentTest.info("Password kutusuna gecersiz sifre girildi");
        mainpage.secondLoginButonu.click();
        extentTest.info("Ikinci Login butonuna tiklandi");
        mainpage.pageDown();
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(mainpage.wrongLoginControl.isDisplayed());
        ReusableMethods.getScreenshot("YanlisGiris");
        extentTest.info("Sisteme giris yapilamadigi test edildi");

    }
    @Test(priority = 2)
    public void gecersizKullaniciAdiIleGirisTesti() throws IOException {
        extentTest=extentReports.createTest("TC_0004 Negative Test-2", "Gecerli Sifre ve gecersiz kullanici adi ile giris testi");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");
        ReusableMethods.waitFor(2);
        mainpage.firstLoginLinki.click();
        extentTest.info("ilk login linkine tiklandi");
        softAssert.assertTrue(mainpage.firstUserNameBox.isDisplayed());
        softAssert.assertTrue(mainpage.firstPasswordBox.isDisplayed());
        extentTest.info("Username ve Password kutularinin gorunurlugu test edildi");
        mainpage.pageDown();
        ReusableMethods.waitFor(2);
        mainpage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        extentTest.info("Username kutusuna gecersiz kullanici adi girildi");
        mainpage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        extentTest.info("Password kutusuna gecerli sifre girildi");
        mainpage.secondLoginButonu.click();
        extentTest.info("Ikinci Login butonuna tiklandi");
        mainpage.pageDown();
        softAssert.assertTrue(mainpage.wrongLoginControl.isDisplayed());
        ReusableMethods.getScreenshot("YanlisGiris");
        ReusableMethods.waitFor(2);
        extentTest.info("Sisteme giris yapilamadigi test edildi");
    }
    @Test(priority = 3)
    public void GecersizKullaniciAdiVeSifreIleGirisTesti() throws IOException {
        extentTest=extentReports.createTest("TC_0004 Negative Test-3", "Gecersiz Kullanici adi ve Gecersiz Sifre ile giris testi");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");
        ReusableMethods.waitFor(2);
        mainpage.firstLoginLinki.click();
        extentTest.info("ilk login linkine tiklandi");
        softAssert.assertTrue(mainpage.firstUserNameBox.isDisplayed());
        softAssert.assertTrue(mainpage.firstPasswordBox.isDisplayed());
        extentTest.info("Username ve Password kutularinin gorunurlugu test edildi");
        mainpage.pageDown();

        mainpage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        extentTest.info("Username kutusuna gecersiz kullanici adi girildi");

        mainpage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        extentTest.info("Password kutusuna gecersiz sifre girildi");
        mainpage.pageDown();
        mainpage.secondLoginButonu.click();
        extentTest.info("Ikinci Login butonuna tiklandi");
        mainpage.pageDown();
        softAssert.assertTrue(mainpage.wrongLoginControl.isDisplayed());
        ReusableMethods.getScreenshot("YanlisGiris");
        ReusableMethods.waitFor(2);
        extentTest.info("Sisteme giris yapilamadigi test edildi");


    }
}
