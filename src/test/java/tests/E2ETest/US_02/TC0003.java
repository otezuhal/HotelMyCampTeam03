package tests.E2ETest.US_02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC0003 extends TestBaseRapor {

        MainPage mainpage = new MainPage();
        SoftAssert softAssert=new SoftAssert();

       // "Password" kutusunun gorunurlugu test edilmeli ve
       // veri girisi yapilabilmeli
        @Test
        public void passworbBoxTesti() throws IOException {
            extentTest=extentReports.createTest("TC_0003 PasswordBox","PasswordBox Kontrol");
            Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
            extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");
            mainpage.firstLoginLinki.click();
            ReusableMethods.waitFor(1);
            softAssert.assertTrue(mainpage.firstPasswordBox.isDisplayed());
            extentTest.info("Password bolumunun gorunurlugu test edildi");
            mainpage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
            ReusableMethods.waitFor(2);
            softAssert.assertFalse(mainpage.firstPasswordBox.toString().isEmpty());
            ReusableMethods.getScreenshot("PasswordBox");
            extentTest.info("Password bolumune veri girisi yapilabildigi test edildi");
            softAssert.assertAll();
         //   Driver.closeDriver();
        }
    }

