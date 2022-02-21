package tests.US_001;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class TC0009MainPageFooterTest extends TestBaseRapor{
    //9- Sayfanin en altinda bulunan footer bolumu gorunur ve icerisindeki uygun elementler tiklanabilir olmali.
    MainPage mainPage=new MainPage();
    SoftAssert softAssert=new SoftAssert();

    @BeforeClass
    public void setUp(){
        mainPage.mainPageUrl();
    }

    @Test(priority = 1)
    public void footerAllElementsIsDisplayedTest(){
        extentTest=extentReports.createTest("footerAllElementsIsDisplayedTest");
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        extentTest=extentReports.createTest("mainPageNavbarButtonsIsDisplayedTest");
        ReusableMethods.waitFor(20);
        softAssert.assertTrue(mainPage.mainPageUsefulLinkGiftCard.isDisplayed(),"mainPageUsefulLinkGiftCard gorunmemektedir");
        extentTest.info("mainPageUsefulLinkGiftCard'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageUsefulLinkBlog.isDisplayed(),"mainPageUsefulLinkBlog gorunmemektedir");
        extentTest.info("mainPageUsefulLinkBlog'un gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageUsefulLinkRooms.isDisplayed(),"mainPageUsefulLinkRooms gorunmemektedir");
        extentTest.info("mainPageUsefulLinkRooms'un gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageUsefulLinkAmentitiesTest.isDisplayed(),"mainPageUsefulLinkAmentitiesTest gorunmemektedir");
        extentTest.info("mainPageUsefulLinkAmentitiesTest'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPagePrivacyGiftCareer.isDisplayed(),"mainPagePrivacyGiftCareer gorunmemektedir");
        extentTest.info("mainPagePrivacyGiftCareer'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPagePrivacyAboutUs.isDisplayed(),"mainPagePrivacyAboutUs gorunmemektedir");
        extentTest.info("mainPagePrivacyAboutUs'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPagePrivacyContactUs.isDisplayed(),"mainPagePrivacyContactUs gorunmemektedir");
        extentTest.info("mainPagePrivacyContactUs'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPagePrivacyServices.isDisplayed(),"mainPagePrivacyServices gorunmemektedir");
        extentTest.info("mainPagePrivacyServices'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageTelephoneLink.isDisplayed(),"mainPageTelephoneLink gorunmemektedir");
        extentTest.info("mainPageTelephoneLink'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageEmailLink.isDisplayed(),"mainPageEmailLink gorunmemektedir");
        extentTest.info("mainPageEmailLink'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageFooterTwitterIkon.isDisplayed(),"mainPageFooterTwitterIkon gorunmemektedir");
        extentTest.info("mainPageFooterTwitterIkon'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageFooterFacebookIkon.isDisplayed(),"mainPageFooterFacebookIkon gorunmemektedir");
        extentTest.info("mainPageFooterFacebookIkon'in gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageFooterInstagramIkon.isDisplayed(),"mainPageFooterInstagramIkon gorunmemektedir");
        extentTest.info("mainPageFooterInstagramIkon'in gorunurlugu test edildi ");
        softAssert.assertAll();
    }
    @Test(priority = 3)
    public void giftCardLinkTest(){
        extentTest=extentReports.createTest("giftCardLinkTest");
        extentTest.info("HotelMy Camp sitesine gidildi.");
        //     JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPageUsefulLinkGiftCard.click();
        extentTest.info("mainPageUsefulLinkGiftCard linkine tiklandi ");
        String actualUrl= Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("GiftCard"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPageUsefulLinkGiftCard linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public void blogLinkTest(){
        extentTest=extentReports.createTest("blogLinkTest");
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPageUsefulLinkBlog.click();
        extentTest.info("mainPageUsefulLinkBlog linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("blog"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPageUsefulLinkBlog linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
    }
    @Test(priority = 4)
    public void roomsLinkTest(){
        extentTest=extentReports.createTest("roomsLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPageUsefulLinkRooms.click();
        extentTest.info("mainPageUsefulLinkRooms linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("rooms"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPageUsefulLinkRooms linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 5)
    public void amentitiesLinkTest(){
        extentTest=extentReports.createTest("amentitiesLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPageUsefulLinkAmentitiesTest.click();
        extentTest.info("mainPageUsefulLinkAmentitiesTest linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("amentities"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPageUsefulLinkAmentitiesTest linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 6)
    public void career(){
        extentTest=extentReports.createTest("career");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPagePrivacyGiftCareer.click();
        extentTest.info("mainPagePrivacyGiftCareer linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("career"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPagePrivacyGiftCareer linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 7)
    public void aboutUsLinkTest(){
        extentTest=extentReports.createTest("aboutUsLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPagePrivacyAboutUs.click();
        extentTest.info("mainPagePrivacyAboutUs linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("about us"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPagePrivacyAboutUs linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 8)
    public void contactUsLinkTest(){
        extentTest=extentReports.createTest("contactUsLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPagePrivacyContactUs.click();
        extentTest.info("mainPagePrivacyContactUs linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("contact us"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPagePrivacyContactUs linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 9)
    public void servicesLinkTest(){
        extentTest=extentReports.createTest("servicesLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPagePrivacyServices.click();
        extentTest.info("mainPagePrivacyServices linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("services"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPagePrivacyServices linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 10)
    public  void telephoneLinkTest(){
        extentTest=extentReports.createTest("telephoneLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPageTelephoneLink.click();
        extentTest.info("mainPageTelephoneLink linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("telephone"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPageTelephoneLink linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 11)
    public  void emailLinkTest(){
        extentTest=extentReports.createTest("emailLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPageEmailLink.click();
        extentTest.info("mainPageEmailLink linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("email"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPageEmailLink linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 12)
    public  void twitterLinkTest(){
        extentTest=extentReports.createTest("twitterLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPageFooterTwitterIkon.click();
        extentTest.info("mainPageFooterTwitterIkon linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("twitter"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPageFooterTwitterIkon linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 13)
    public  void facebookLinkTest(){
        extentTest=extentReports.createTest("facebookLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPageFooterFacebookIkon.click();
        extentTest.info("mainPageFooterFacebookIkon linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("facebook"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPageFooterFacebookIkon linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(priority = 14)
    public  void instagramLinkTest(){
        extentTest=extentReports.createTest("instagramLinkTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        JSUtils.scrollIntoViewJS(mainPage.mainPageFooter);
        extentTest.info("mainPageFooter'a scrolldown yapildi");
        ReusableMethods.waitFor(10);
        mainPage.mainPageFooterInstagramIkon.click();
        extentTest.info("mainPageFooterInstagramIkon linkine tiklandi ");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("instagram"),"link ilgili sayfaya yonlendirmemektedir");
        extentTest.info("mainPageFooterInstagramIkon linkine gitmedigi goruldu, bir bug tespit edildi ");
        softAssert.assertAll();
        Driver.closeDriver();
    }
//    @AfterClass
//    public void tearDown(){
//        Driver.closeDriver();
//        extentTest.info("Driver kapatildi");
//    }
}
