package tests.US_001;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.*;
public class TC_0005MainPageOurRoomsTest  {
    MainPage mainPage=new MainPage();
    //5- Our Rooms bolumu ve icerisindeki elementler gorunur ve tiklanabilir olmali
    @Test
    public void mainPageOurRoomsIsDisplayedTest(){
        //    extentTest=extentReports.createTest("mainPageOurRoomsIsDisplayedTest");
        mainPage.mainPageUrl();
        //   extentTest.info("HotelMy Camp sitesine gidildi.");
        ReusableMethods.waitFor(2);
        JSUtils.scrollIntoViewJS(mainPage.mainPageOurRoomsText);
        //  extentTest.info("OurRooms'a scrolldown yapildi");
        ReusableMethods.waitFor(15);
        Assert.assertTrue(mainPage.mainPageOurRoomsText.isDisplayed());
        //  extentTest.info("mainPageOurRoomsText'in gorunurlugu test edildi ");
        //
        //(//div[@class='col-sm col-md-6 col-lg-4 ftco-animate fadeInUp ftco-animated'])
        ReusableMethods.waitFor(5);
        for (int i = 1; i <=6 ; i++) {
            String ourRoomsXpath="(//div[@class='room'])["+i+"]";
            String ourRoomsviewRoomDetails="(//a[@class='btn-custom'])["+i+"]";
            ReusableMethods.waitFor(10);

            WebElement ourRoomsWebElement=Driver.getDriver().findElement(By.xpath(ourRoomsXpath));
            ReusableMethods.waitForVisibility(ourRoomsWebElement,20);
            Assert.assertTrue(ourRoomsWebElement.isDisplayed());
            //   extentTest.info("mainPageOurRooms'teki 6 odanin  gorunurlugu test edildi ");
            String ourRoomsWebElemetText=ourRoomsWebElement.getText();
            WebElement ourRoomsviewRoomDetailsWebElement=Driver.getDriver().findElement(By.xpath(ourRoomsviewRoomDetails));
            ourRoomsviewRoomDetailsWebElement.click();
            //   extentTest.info("mainPageOurRooms'teki 6 odaya tek tek click yapildi");
            String ourRoomsRoomTitle=Driver.getDriver().findElement(By.tagName("h1")).getText();
            Assert.assertTrue(ourRoomsWebElemetText.contains(ourRoomsRoomTitle));
            //   extentTest.info("mainPageOurRooms'teki 6 odanin  titlelari karsilastirildi ");
            System.out.println(ourRoomsRoomTitle);
            //   extentTest.info("mainPageOurRooms'teki 6 odanin  title'lari yazdirildi ");
            Driver.getDriver().navigate().back();
            //   extentTest.info("mainPageOurRooms'teki 6 odanin  gorunurlugunu test edebilmek icin her click'ten sonra driver geri alindi  ");
            ReusableMethods.waitFor(2);
        //    Driver.closeDriver();
            //   extentTest.info("Driver kapatildi");
        }
    }
}
