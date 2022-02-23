package tests.SmokeTest.US_02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC0001 extends TestBaseRapor {
        MainPage mainpage = new MainPage();
        SoftAssert softAssert=new SoftAssert();

    // Ana sayfadaki Log-in butonunun gorunurlugu
    // test edilmeli  ve button erisilebilir olmali.
    @Test
    public void ilkLoginTesti() throws IOException {
        extentTest=extentReports.createTest("TC_0001 Sayfaya Giris Testi","ilk login linki testi");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");
        softAssert.assertTrue(mainpage.firstLoginLinki.isDisplayed());
        extentTest.info("ilk login linkinin gorunurlugu test edildi");
        mainpage.firstLoginLinki.click();
        extentTest.info("ilk login linkine tiklandi");
        ReusableMethods.waitFor(2);
        String actuelTitle=Driver.getDriver().getTitle();
        String expectedTitle="Hotelmycamp - Log in";
        softAssert.assertEquals(actuelTitle,expectedTitle);
        extentTest.info("ilk login linkinin erisilebilir oldugu test edildi");
        ReusableMethods.getScreenshot("ilkLoginLink");
        softAssert.assertAll();


    }

}
