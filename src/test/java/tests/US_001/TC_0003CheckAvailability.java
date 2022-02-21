package tests.US_001;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.html.HTMLInputElement;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TC_0003CheckAvailability {
    MainPage mainPage=new MainPage();
    SoftAssert softAssert=new SoftAssert();
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void checkInDateisDisplayed(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ReusableMethods.waitFor(2);
        WebElement mainPageCheckInDateElement=mainPage.mainPageCheckInDateText;
        String mainPageCheckInDateStr=mainPageCheckInDateElement.getText();
        System.out.println("mainPageCheckInDateStr =" +mainPageCheckInDateStr);
        softAssert.assertTrue(mainPageCheckInDateElement.isDisplayed());


        LocalDate localDate=LocalDate.now();
        LocalDate eklenmisLocalDate = localDate.plusDays(5);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String checkInDate = eklenmisLocalDate.format(duzenliDateStart);
        System.out.println(checkInDate);

        LocalDate eklenmisLocalDateCheckOut = localDate.plusDays(15);
        String checkOutDate = eklenmisLocalDateCheckOut.format(duzenliDateStart);
        System.out.println(checkOutDate);



        System.out.println(localDate.toString());
        //CheckInDate Uptade kismi

      mainPage.mainPageCheckInDateInput.clear();
        mainPage.mainPageCheckInDateInput.sendKeys(checkInDate);
      //  mainPage.mainPageCheckInDateInputNext.click();
      //  mainPage.mainPageCheckInDateInputSecilecekGun.click();
        //CheckOutDate Uptade kismi
        mainPage.getMainPageCheckOutDateInput.clear();
        mainPage.getMainPageCheckOutDateInput.sendKeys(checkOutDate);
     //   mainPage.mainPageCheckInDateOutputNext.click();
      //  mainPage.mainPageCheckInDateOutputSecilecekGun.click();
        //Room box Uptade kismi
        Select select=new Select(mainPage.mainPageRoomBox);
        select.selectByVisibleText("Double");
        // Adult box Uptade kismi
        Select select1=new Select(mainPage.mainPageCustomerBox);
        select1.selectByVisibleText("2 Adult");
        String idHotelRoomType1=mainPage.idHotelRoomTypeBox1.getAttribute("value");
        String adultCount1=mainPage.adultCountBox1.getAttribute("value");
        String checkInDate1=mainPage.checkInDateBox1.getAttribute("value");
        String checkOutDate1=mainPage.checkOutDateBox1.getAttribute("value");
        System.out.println("************************");

        System.out.println(checkInDate1.replace("0",""));
        System.out.println(checkInDate1);
        System.out.println(checkOutDate1);

        mainPage.checkAvailabilityButton.click();

        String checkInDate2=mainPage.checkInDateBox2.getAttribute("value");
        String checkOutDate2=mainPage.checkOutDateBox2.getAttribute("value");
        String idHotelRoomType2=mainPage.idHotelRoomTypeBox2.getAttribute("value");
        String adultCount2=mainPage.adultCountBox2.getAttribute("value");
        System.out.println(checkInDate2);
        System.out.println(checkOutDate2);


        softAssert.assertEquals(checkInDate1,checkInDate2);
        softAssert.assertEquals(checkOutDate1,checkOutDate2);
        softAssert.assertEquals(idHotelRoomType1,idHotelRoomType2);
        softAssert.assertEquals(adultCount1,adultCount2);

        softAssert.assertAll();


        ////td[.='10']
        //(//th[@class='next'])[1]
    }
    @Test
    public void checkOutDateisDisplayed(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ReusableMethods.waitFor(2);
        WebElement mainPageCheckOutDateElement=mainPage.mainPageCheckOutDateText;
        String mainPageCheckInDateStr=mainPageCheckOutDateElement.getText();
        System.out.println("mainPageCheckInDateStr =" +mainPageCheckInDateStr);
        softAssert.assertTrue(mainPageCheckOutDateElement.isDisplayed());
    }

    //dateStart
    public void dateStart() {
        LocalDate localDate = LocalDate.now();
        LocalDate eklenmisLocalDate = localDate.plusDays(5);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String localDateStr = eklenmisLocalDate.format(duzenliDateStart);
    //    dateStartWebElement.click();
     //   dateStartWebElement.sendKeys(localDateStr);
    }
    //dateEnd
    public void dateEnd() {
        LocalDate localDate = LocalDate.now();
        LocalDate eklenmisLocalDate = localDate.plusDays(15);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String localDateStr = eklenmisLocalDate.format(duzenliDateStart);
        HTMLInputElement dateStartWebElement;
      //  dateStartWebElement.click();
      //  dateEndWebElement.sendKeys(localDateStr);
    }

}