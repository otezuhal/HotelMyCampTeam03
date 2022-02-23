package tests.E2ETest.US_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_0005MainPageOurRoomsTest extends TestBaseRapor {
    MainPage mainPage=new MainPage();

    //5- Our Rooms bolumu ve icerisindeki elementler gorunur ve tiklanabilir olmali
    @Test
    public void mainPageOurRoomsIsDisplayedTest(){
       extentTest=extentReports.createTest("mainPageOurRoomsIsDisplayedTest");
        mainPage.mainPageUrl();
       extentTest.info("HotelMy Camp sitesine gidildi.");
        ReusableMethods.waitFor(2);
        JSUtils.scrollIntoVIewJS(mainPage.mainPageOurRoomsText);
        extentTest.info("OurRooms'a scrolldown yapildi");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.mainPageOurRoomsText.isDisplayed());
        extentTest.info("mainPageOurRoomsText'in gorunurlugu test edildi ");


        //(//div[@class='col-sm col-md-6 col-lg-4 ftco-animate fadeInUp ftco-animated'])
        for (int i = 1; i <=6 ; i++) {
           String ourRoomsXpath="(//div[@class='room'])["+i+"]";
            String ourRoomsviewRoomDetails="(//a[@class='btn-custom'])["+i+"]";
            ReusableMethods.waitFor(2);
            WebElement ourRoomsWebElement=Driver.getDriver().findElement(By.xpath(ourRoomsXpath));
            Assert.assertTrue(ourRoomsWebElement.isDisplayed());
           extentTest.info("mainPageOurRooms'teki 6 odanin  gorunurlugu test edildi ");
            String ourRoomsWebElemetText=ourRoomsWebElement.getText();
            WebElement ourRoomsviewRoomDetailsWebElement=Driver.getDriver().findElement(By.xpath(ourRoomsviewRoomDetails));
            ourRoomsviewRoomDetailsWebElement.click();
            extentTest.info("mainPageOurRooms'teki 6 odaya tek tek click yapildi");
            String ourRoomsRoomTitle=Driver.getDriver().findElement(By.tagName("h1")).getText();
            Assert.assertTrue(ourRoomsWebElemetText.contains(ourRoomsRoomTitle));extentTest.info("mainPageOurRooms'teki 6 odanin  titlelari karsilastirildi ");
            System.out.println(ourRoomsRoomTitle);
            extentTest.info("mainPageOurRooms'teki 6 odanin  title'lari yazdirildi ");
            Driver.getDriver().navigate().back();
           extentTest.info("mainPageOurRooms'teki 6 odanin  gorunurlugunu test edebilmek icin her click'ten sonra driver geri alindi  ");
            ReusableMethods.waitFor(2);


        }
      //  Driver.closeDriver();
        //   extentTest.info("Driver kapatildi");

    }


}
