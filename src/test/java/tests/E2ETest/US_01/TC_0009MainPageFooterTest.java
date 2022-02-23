package tests.E2ETest.US_01;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_0009MainPageFooterTest extends TestBaseRapor{

    //9- Sayfanin en altinda bulunan footer bolumu gorunur ve icerisindeki uygun elementler tiklanabilir olmali.


    @Test
    public void mainPageFooterTest() {
        extentTest=extentReports.createTest("mainPageFooterTest");
        MainPage mainPage=new MainPage();
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) Driver.getDriver();
        mainPage.mainPageUrl();
        JSUtils.scrollIntoVIewJS(mainPage.mainPageFooter);
        ReusableMethods.waitFor(2);
        extentTest.info("HotelMy Camp sitesine gidildi.");
        Assert.assertTrue(mainPage.mainPageFooter.isDisplayed());
        extentTest.info("mainPageFooter'in gorunurlugu test edildi ");

        JSUtils.clickElementByJS(mainPage.mainPageEmailLink);
        extentTest.info("mainPageFooter'a scrolldown yapildi ve mainPageEmailLink'e click yapildi");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.info("expectedUrl'nin gorunurlugu test edildi ");

        JSUtils.clickElementByJS(mainPage.mainPageTelephoneLink);
        extentTest.info("mainPageFooter'a scrolldown yapildi ve mainPageTelephoneLink'a click yapildi");
        String actualUrl1=Driver.getDriver().getCurrentUrl();
        String expectedUrl1="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl1,expectedUrl1);
        extentTest.info("expectedUrl'nin gorunurlugu test edildi ");

        JSUtils.clickElementByJS(mainPage.mainPagePrivacyAboutUs);
        extentTest.info("mainPageFooter'a scrolldown yapildi ve mainPagePrivacyAboutUs'a click yapildi");
        String actualUrl2=Driver.getDriver().getCurrentUrl();
        String expectedUrl2="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl2,expectedUrl2);
        extentTest.info("expectedUrl'nin gorunurlugu test edildi ");

        JSUtils.scrollIntoVIewJS(mainPage.mainPagePrivacyGiftCareer);
        extentTest.info("mainPageFooter'a scrolldown yapildi ve mainPagePrivacyGiftCareer'e click yapildi");
        String actualUrl3=Driver.getDriver().getCurrentUrl();
        String expectedUrl3="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl3,expectedUrl3);
        extentTest.info("expectedUrl'nin gorunurlugu test edildi ");

        JSUtils.clickElementByJS(mainPage.mainPagePrivacyContactUs);
        extentTest.info("mainPageFooter'a scrolldown yapildi ve mainPagePrivacyContactUs'a click yapildi");
        String actualUrl4=Driver.getDriver().getCurrentUrl();
        String expectedUrl4="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl4,expectedUrl4);
        extentTest.info("expectedUrl'nin gorunurlugu test edildi ");

        JSUtils.clickElementByJS(mainPage.mainPagePrivacyServices);
        extentTest.info("mainPageFooter'a scrolldown yapildi ve mainPagePrivacyServices'e click yapildi");
        String actualUrl5= Driver.getDriver().getCurrentUrl();
        String expectedUrl5="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl5,expectedUrl5);
        extentTest.info("expectedUrl'nin gorunurlugu test edildi ");

//        Driver.closeDriver();
//        extentTest.info("Driver kapatildi");








    }
    }

