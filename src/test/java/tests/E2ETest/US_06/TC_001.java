package tests.E2ETest.US_06;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_001  extends TestBaseRapor {
    //Yönetici olarak basarili Log in yapılması
    //'ListofUsers' yazısı var mı test edilmeli

    @Test
    public void girisYapildiTesti(){
        MainPage mainPage=new MainPage();
        extentTest=extentReports.createTest("girisYapidiTesti","yonetici girisi test edildi");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("hotelmycamp sayfasina gidildi");

        ReusableMethods.waitForClickablility(mainPage.firstLoginLinki,15);

        mainPage.firstLoginLinki.click();
        mainPage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        mainPage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        //ReusableMethods.waitForClickablility(mainPage.loginButonu,20);
        mainPage.secondLoginButonu.click();
        extentTest.info("yonetici girisi yapildi");

        HotelRoomsPage hotelRoomPage=new HotelRoomsPage();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(hotelRoomPage.listOfUsersYazisi.isDisplayed());

        extentTest.pass("listofUsers yazisinin gorunurlugu test edildi");

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hotelRoomPage.managerLink).perform();
        ReusableMethods.waitFor(2);
        hotelRoomPage.logOutButton.click();
        extentTest.info("basarili cikis yapildi");
    }

}
