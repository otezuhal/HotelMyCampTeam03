package tests.E2ETest.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_0002NavBarButtonClickAndSwichTest extends TestBaseRapor{
    MainPage mainPage=new MainPage();

    //2-Navbar'da bulunan butonlar kullaniciyi ilgili sayfaya yonlendirmeli.
    @Test
    public void NavBarButtonClickAndSwichTest() {
        extentTest=extentReports.createTest("NavBarButtonClickAndSwichTest");
        mainPage.mainPageUrl();
        ReusableMethods.waitFor(2);
        extentTest.info("HotelMy Camp sitesine gidildi.");
        mainPage.mainPageNavbarHomeButton.click();
        extentTest.info("mainPageNavbarHomeButton'a click yapildi .");
        System.out.println(Driver.getDriver().getTitle());

        extentTest.info("Main page home page title'i alindi .");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.homePageBasariliGiris.isDisplayed());
        extentTest.info("Main page home page'e basarili bir sekilde giris yapildigi goruldu.");
        //   ReusableMethods.getScreenshot("Main Page, HomePage ScreenShot");

        ReusableMethods.waitFor(2);
        mainPage.mainPageNavbarRoomsButton.click();
        extentTest.info("mainPageNavbarRoomsButton'a click yapildi .");
        System.out.println(Driver.getDriver().getTitle());
        extentTest.info("Main page rooms page title'i alindi .");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.roomsPageBasariliGiris.isDisplayed());
        extentTest.info("Main page rooms page'e basarili bir sekilde giris yapildigi goruldu.");
        //        ReusableMethods.getScreenshot("Main Page, RoomsPage ScreenShot");

        ReusableMethods.waitFor(2);
        mainPage.mainPageNavbarRestaurantButton.click();
        extentTest.info("mainPageNavbarRestaurantButton'a click yapildi .");
        System.out.println(Driver.getDriver().getTitle());
        extentTest.info("Main page restaurant page title'i alindi .");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.restaurantPageBasariliGiris.isDisplayed());
        extentTest.info("Main page restaurant page'e basarili bir sekilde giris yapildigi goruldu.");
        //        ReusableMethods.getScreenshot("Main Page, RestaurantPage ScreenShot");

        ReusableMethods.waitFor(2);
        mainPage.mainPageNavbarAboutButton.click();
        extentTest.info("mainPageNavbarAboutButton'a click yapildi .");
        System.out.println(Driver.getDriver().getTitle());
        extentTest.info("Main page about page title'i alindi .");
        // mainPage.aboutPageBasariliGiris.getText();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.aboutPageBasariliGiris.isDisplayed());
        extentTest.info("Main page about page'e basarili bir sekilde giris yapildigi goruldu.");
        //       ReusableMethods.getScreenshot("Main Page, AboutPage ScreenShot");

        ReusableMethods.waitFor(2);
        mainPage.mainPageNavbarBlogButton.click();
        extentTest.info("mainPageNavbarBlogButton'a click yapildi .");
        System.out.println(Driver.getDriver().getTitle());
        extentTest.info("Main page blog page title'i alindi .");
        // mainPage.blogPageBasariliGiris.getText();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.blogPageBasariliGiris.isDisplayed());
        extentTest.info("Main page blog page'e basarili bir sekilde giris yapildigi goruldu.");
        //        ReusableMethods.getScreenshot("Main Page, BlogPage ScreenShot");

        ReusableMethods.waitFor(2);
        mainPage.mainPageNavbarContactButton.click();
        extentTest.info("mainPageNavbarContactButton'a click yapildi .");
        System.out.println(Driver.getDriver().getTitle());
        extentTest.info("Main page contact page title'i alindi .");
        //  mainPage.contactPageBasariliGiris.getText();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.contactPageBasariliGiris.isDisplayed());
        extentTest.info("Main page contact page'e basarili bir sekilde giris yapildigi goruldu.");


        ReusableMethods.waitFor(2);
        mainPage.mainPageNavbarLoginButton.click();
        extentTest.info("mainPageNavbarLoginButton'a click yapildi .");
        System.out.println(Driver.getDriver().getTitle());
        extentTest.info("Main page login page title'i alindi .");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.loginPageBasariliGiris.isDisplayed());
        extentTest.info("Main page login page'e basarili bir sekilde giris yapildigi goruldu.");

      //  Driver.closeDriver();
      //  extentTest.info("Driver kapatildi");

    }
}
