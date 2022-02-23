package tests.SmokeTest.US_02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC0002 extends TestBaseRapor {
    MainPage mainpage = new MainPage();
    SoftAssert softAssert=new SoftAssert();

   // "Username" kutusunun gorunurlugu test
   // edilmeli ve veri girisi yapilabilmeli
    @Test
    public void usernameBoxTesti() throws IOException {
        extentTest=extentReports.createTest("TC_0002 UsernameBox","UsernameBox Kontrol");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");
        mainpage.firstLoginLinki.click();
        ReusableMethods.waitFor(1);
        softAssert.assertTrue(mainpage.firstUserNameBox.isDisplayed());
        extentTest.info("Username  bolumunun gorunurlugu test edildi");
        mainpage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        ReusableMethods.waitFor(2);
        softAssert.assertFalse(mainpage.firstUserNameBox.toString().isEmpty());
        ReusableMethods.getScreenshot("UsernameBox");
        extentTest.info("Username  bolumune veri girisi yapilabildigi test edildi");
        ReusableMethods.waitFor(2);
        softAssert.assertAll();
        //Driver.closeDriver();
    }
}
