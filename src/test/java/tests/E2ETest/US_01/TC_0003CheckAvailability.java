package tests.E2ETest.US_01;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class TC_0003CheckAvailability extends TestBaseRapor {
    MainPage mainPage=new MainPage();
    SoftAssert softAssert=new SoftAssert();
    Actions actions=new Actions(Driver.getDriver());

    //3- CHECK-IN DATE, CHECK-OUT DATE, ROOM, CUSTOMER elementleri gorunur ve update edilebilir olmali ve
    //Check Availability butonu kullaniciyi sectigi kriterlere gore uygun sayfaya yonlendirmeli.
    @Test
    public void inputAndCheckAvailabilityTest(){
        extentTest=extentReports.createTest("inputAndCheckAvailabilityTest");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(mainPage.mainPageCheckİnDateButton.isDisplayed(),"checkIn date buttonu gorunmuyor");
        extentTest.info("mainPageCheckİnDateButton'un gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageCheckOutDateButton.isDisplayed(),"checkOut date buttonu gorunmuyor");
        extentTest.info("mainPageCheckOutDateButton'un gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageRoomTypeButton.isDisplayed(),"room type button gorunmuyor");
        extentTest.info("mainPageRoomTypeButton'un gorunurlugu test edildi ");
        softAssert.assertTrue(mainPage.mainPageCustomerButton.isDisplayed(),"customer button gorunmuyor");
        extentTest.info("mainPageCustomerButton'un gorunurlugu test edildi ");


        ReusableMethods.waitFor(2);
        LocalDate localDate=LocalDate.now();

        LocalDate eklenmisLocalDate = localDate.plusDays(5);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String checkInDate = eklenmisLocalDate.format(duzenliDateStart);
        extentTest.info("Local date'e gore 5 gun sonrasina checkIn yapildi ");
        System.out.println(checkInDate);

        ReusableMethods.waitFor(2);
        LocalDate eklenmisLocalDateCheckOut = localDate.plusDays(15);
        String checkOutDate = eklenmisLocalDateCheckOut.format(duzenliDateStart);
        extentTest.info("Local date'e gore 15 gun sonrasina checkOut yapildi ");
        System.out.println(checkOutDate);
        System.out.println(localDate.toString());

        //CheckInDate Uptade
        Actions actions=new Actions(Driver.getDriver());
        mainPage.mainPageCheckInDateInput.clear();
        mainPage.mainPageCheckInDateInput.sendKeys(checkInDate);
        extentTest.info("check in date update edildi ");

        //CheckOutDate Uptade
        mainPage.getMainPageCheckOutDateInput.clear();
        mainPage.getMainPageCheckOutDateInput.sendKeys(checkOutDate);
        extentTest.info("check out date update edildi ");


        //Room box Uptade
        Select select=new Select(mainPage.mainPageRoomBox);
        select.selectByVisibleText("Double");
        extentTest.info("room type secildi ");

        // Adult box Uptade
        Select select1=new Select(mainPage.mainPageCustomerBox);
        select1.selectByVisibleText("2 Adult");
        extentTest.info("Customer secildi ");

        ReusableMethods.waitFor(2);
        mainPage.mainPageCheckAvailabiltyButton.click();
        extentTest.info("Ilk degerler girildi ve click yapildi");
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Hotelmycamp - Rooms";
        softAssert.assertEquals(actualTitle,expectedTitle,"sayfa title'i ayni degil");
        extentTest.info("ilgili sayfaya yonlendirdigi goruldu ");
        ReusableMethods.waitFor(2);

        String idHotelRoomType1=mainPage.checkAvailabilityRoomTypeFirst.getAttribute("value");
        String idHotelCustomer1=mainPage.checkAvailabilityCustomerFirst.getAttribute("value");
        String checkInDate2=mainPage.checkAvailabilityCheckInDate.getAttribute("value");
        String checkOutDate2=mainPage.checkAvailabilityCheckOutDate.getAttribute("value");
        String idHotelRoomType2=mainPage.checkAvailabilityRoomType.getAttribute("value");
        String idHotelCustomer2=mainPage.checkAvailabilityCustomer.getAttribute("value");
        String checkInDate1=mainPage.checkAvailabilityCheckInDateFirst.getAttribute("value");
        System.out.println(checkInDate1);
        String checkOutDate1=mainPage.checkAvailabilityCheckOutDateFirst.getAttribute("value");
        extentTest.info("Ilk girilen degerler ve yonlendirilen get attribute ile alindi ");
        System.out.println(checkOutDate1);

        ReusableMethods.waitFor(3);
        softAssert.assertEquals(checkInDate1,checkInDate2,"check in date tarihleri esit degi");
        softAssert.assertEquals(checkOutDate1 ,checkOutDate2,"checkout date tarihleri esit degil");
        softAssert.assertEquals(idHotelCustomer1,idHotelCustomer2,"Customer type'lari esit degil");
        softAssert.assertEquals(idHotelRoomType1,idHotelRoomType2,"room type'lar esit degil");
        extentTest.info("Ilk girilen degerler ve yonlendirilen bilgiler karsilastirildi ");
        softAssert.assertAll();
        extentTest.info("Ilk girilen degerler ve yonlendirilen bilgiler karsilastirildi ve ubdate edildigi goruldu ");

       // Driver.closeDriver();
      // extentTest.info("Driver kapatildi");

    }


}