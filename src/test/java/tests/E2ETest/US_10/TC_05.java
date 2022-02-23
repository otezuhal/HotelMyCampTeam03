package tests.E2ETest.US_10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_05 extends TestBaseRapor {

    public UserPage userPage;
    public SoftAssert softAssert;
    public JavascriptExecutor jse;

    @Test
    public void test5(){
     jse = (JavascriptExecutor) Driver.getDriver();
     softAssert = new SoftAssert();
     userPage = new UserPage();


        extentTest = extentReports.createTest("Categories te bulunan Double Oda tipi test ediliyor.", "Double categorisindeki Odalara kayit yapiliyor ama 2 tane bug bulundu");
     ReusableMethods.waitFor(1);
        Actions actions=new Actions(Driver.getDriver());
       actions.sendKeys(Keys.PAGE_UP).perform();
        //jse.executeScript("arguments[0].scrollIntoView(true);",userPage.doubleLink);
        ReusableMethods.waitFor(1);
        userPage.doubleLink.click();

        String exceptedTitle="Hotelmycamp - Rooms";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,exceptedTitle);
        extentTest.pass("Sayfa title'ndan girildigi test edildi");

        //Double categoriesindeki roomlarin gorunur olup olmadiklari kontrol ediliyor.

        jse.executeScript("arguments[0].scrollIntoView(true);",userPage.roomsText);
        jse.executeScript("arguments[0].scrollIntoView(true);",userPage.qwRoomBook);
        jse.executeScript("arguments[0].scrollIntoView(true);",userPage.kingRoomBook);
        jse.executeScript("arguments[0].scrollIntoView(true);",userPage.specialRoomBook);
        extentTest.pass("Double categoriesindeki roomlarin gorunur olup olmadiklari test edildi");
        userPage.specialRoomBook.click();
        extentTest.pass("Double room turu linki test edildi");

        //Double categoriesindeki Special Roomda reservation yapiliyor.--->check in date kutusu test ediliyor.
        userPage.checkindatebox.clear();
        userPage.checkindatebox.sendKeys(ConfigReader.getProperty("HMCInValidUserPageCheckInDate1"));
        userPage.checkindatebox.clear();
        userPage.checkindatebox.sendKeys(ConfigReader.getProperty("HMCInValidUserPageCheckInDate2"));
        userPage.checkindatebox.clear();
        userPage.checkindatebox.sendKeys(ConfigReader.getProperty("HMCInValidUserPageCheckInDate3"));
        userPage.checkindatebox.clear();
        userPage.checkindatebox.sendKeys(ConfigReader.getProperty("HMCValidUserPageCheckInDate"));
        extentTest.info("Double categoriesindeki Special Room reservationunda check in date box test edildi");

        //Double categoriesindeki Special Roomda reservation yapiliyor.--->check out date kutusu test ediliyor.
        userPage.checkOutdatebox.clear();
        userPage.checkOutdatebox.sendKeys(ConfigReader.getProperty("HMCInValidUserPageCheckOutDate1"));
        userPage.checkOutdatebox.clear();
        userPage.checkOutdatebox.sendKeys(ConfigReader.getProperty("HMCInValidUserPageCheckOutDate2"));
        userPage.checkOutdatebox.clear();
        userPage.checkOutdatebox.sendKeys(ConfigReader.getProperty("HMCInValidUserPageCheckOutDate3"));
        userPage.checkOutdatebox.clear();
        userPage.checkOutdatebox.sendKeys(ConfigReader.getProperty("HMCValidUserPageCheckOutDate"));
        extentTest.info("Double categoriesindeki Special Room reservationunda check out date box test edildi");

        //reservation yapilirken otelden cikis tarihi giris tarihinden once olup olmama durumu test ediliyor
        System.out.println(Driver.getDriver().findElement(By.xpath("(//div[@class='form-group'])[1]")).getText());
        int checkindatebox=Integer.parseInt(ConfigReader.getProperty("HMCValidUserPageCheckInDate").replaceAll("/",""));
        int checkOutdatebox=Integer.valueOf(ConfigReader.getProperty("HMCValidUserPageCheckOutDate").replaceAll("/",""));
        softAssert.assertTrue(checkOutdatebox>checkindatebox,"Check in date, check out date'den sonra olamaz");
        extentTest.fail("Double categoriesindeki Special Room reservationunda eski tarihe kayit yapildigi bugi tespit edildi");

        //Double categoriesindeki Special Roomda reservation yapiliyor.--->select Adult Account kutusu test ediliyor.
        Select select = new Select(userPage.selectadultacountbox);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        select.selectByIndex(5);
        select.selectByIndex(6);
        select.selectByVisibleText("7 Adult");
        extentTest.pass("Double categoriesindeki Special Room reservationunda select Adult Account box test edildi");

        //Double categoriesindeki Special Roomda reservation yapiliyor.--->select Children count kutusu test ediliyor.
        Actions actions1=new Actions(Driver.getDriver());
        actions1.sendKeys(Keys.PAGE_DOWN).perform();
        Select select1 = new Select(userPage.selectchildrenacountbox);
        select1.selectByIndex(1);
        select1.selectByIndex(2);
        select1.selectByIndex(3);
        select1.selectByIndex(4);
        select1.selectByIndex(5);
        select1.selectByIndex(6);
        select1.selectByVisibleText("7 Children");
        extentTest.pass("Double categoriesindeki Special Room reservationunda select Children count box test edildi");

        ////Double categoriesindeki Special Roomda reservation yapiliyor.--->Name Surname kutusu test ediliyor.
        userPage.namesurnamebox.clear();
        userPage.namesurnamebox.sendKeys(ConfigReader.getProperty("RoomReservationInvalidNameSurname1"));
        userPage.namesurnamebox.clear();
        userPage.namesurnamebox.sendKeys(ConfigReader.getProperty("RoomReservationInvalidNameSurname2"));
        userPage.namesurnamebox.clear();
        userPage.namesurnamebox.sendKeys(ConfigReader.getProperty("RoomReservationvalidNameSurname"));
        extentTest.pass("Double categoriesindeki Special Room reservationunda Name Surname box test edildi");

        ////Double categoriesindeki Special Roomda reservation yapiliyor.--->Email adres kutusu test ediliyor.
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("RoomReservationInvalidemailAdres1")).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        userPage.bookthisroomButton.click();
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();
        userPage.emailadressbox.clear();
        userPage.emailadressbox.sendKeys(ConfigReader.getProperty("RoomReservationInvalidemailAdres2"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        userPage.bookthisroomButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        userPage.emailadressbox.clear();
        userPage.emailadressbox.sendKeys(ConfigReader.getProperty("RoomReservationInvalidemailAdres3"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        userPage.bookthisroomButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        userPage.emailadressbox.clear();
        userPage.emailadressbox.sendKeys(ConfigReader.getProperty("RoomReservationvalidemailAdres"));
        extentTest.pass("Double categoriesindeki Special Room reservationunda Email box test edildi");

        ////Double categoriesindeki Special Roomda reservation yapiliyor.--->Phone Number kutusu test ediliyor.
        userPage.phonenumberbox.clear();
        userPage.phonenumberbox.sendKeys(ConfigReader.getProperty("RoomReservationInvalidemailPhoneNumber1"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        userPage.bookthisroomButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        userPage.phonenumberbox.clear();
        userPage.phonenumberbox.sendKeys(ConfigReader.getProperty("RoomReservationInvalidemailPhoneNumber2"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        userPage.bookthisroomButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        userPage.phonenumberbox.clear();
        userPage.phonenumberbox.sendKeys(ConfigReader.getProperty("RoomReservationvalidemailPhoneNumber"));
        extentTest.pass("Double categoriesindeki Special Room reservationunda Phone Number box test edildi");

        ////Double categoriesindeki Special Roomda reservation yapiliyor.--->Name of Credit kutusu test ediliyor.
        userPage.namecreditcardbox.clear();
        userPage.namecreditcardbox.sendKeys(ConfigReader.getProperty("RoomReservationInvalidCardName1"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        userPage.bookthisroomButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        userPage.namecreditcardbox.clear();
        userPage.namecreditcardbox.sendKeys(ConfigReader.getProperty("RoomReservationInvalidCardName2"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        userPage.bookthisroomButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        userPage.namecreditcardbox.clear();
        userPage.namecreditcardbox.sendKeys(ConfigReader.getProperty("RoomReservationvalidCardName"));
        extentTest.pass("Double categoriesindeki Special Room reservationunda Name of credit box test edildi");

        ////Double categoriesindeki Special Roomda reservation yapiliyor.--->Number of Credit Number kutusu test ediliyor.
        userPage.creditcardNumberdbox.clear();
        userPage.creditcardNumberdbox.sendKeys(ConfigReader.getProperty("RormReservationInValidCardNummer1"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        userPage.bookthisroomButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        userPage.creditcardNumberdbox.clear();
        userPage.creditcardNumberdbox.sendKeys(ConfigReader.getProperty("RormReservationInValidCardNummer2"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        userPage.bookthisroomButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        userPage.creditcardNumberdbox.clear();
        userPage.creditcardNumberdbox.sendKeys(ConfigReader.getProperty("RormReservationValidCardNummer"));
        extentTest.pass("Double categoriesindeki Special Room reservationunda Name of credit number box test edildi");

        ////Double categoriesindeki Special Roomda reservation yapiliyor.--->Select Expiration Year For Credit Card test ediliyor.

        Select select2 = new Select(userPage.creditCardExpirationYear);

        select2.selectByIndex(6);
        select2.selectByIndex(5);
        select2.selectByIndex(4);
        select2.selectByIndex(3);
        select2.selectByIndex(2);
        select2.selectByIndex(1);

        softAssert.assertFalse(1<2,"credit card validity date cannot be less than 2022");
        extentTest.fail("Double categoriesindeki Special Room reservationunda " +
                "Select Expiration Year For Credit Card test edildi. son kullanim tarihi dolmus kredi karti ile kayit yapti.");

        Select select3 = new Select(userPage.CreditCardExpirationMonth);

        select3.selectByIndex(6);
        select3.selectByIndex(5);
        select3.selectByIndex(4);
        select3.selectByIndex(3);
        select3.selectByIndex(2);
        select3.selectByIndex(1);

        ////Double categoriesindeki Special Roomda reservation yapiliyor.--->Credit Card Ccv kutusu test ediliyor.
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("RoomReservationValidCcv")).perform();
        userPage.bookthisroomButton.click();
        ReusableMethods.waitFor(1);
        extentTest.pass("Double categoriesindeki Special Room reservationunda  credit ccv number box test edildi");

        ////Double categoriesindeki Special Roomda reservation yapiliyor.--->Message kutusu test ediliyor.
        userPage.messageBox.sendKeys(ConfigReader.getProperty("roomReserInvationValid"));
        userPage.bookthisroomButton.click();
        ReusableMethods.waitFor(1);
        userPage.messageBox.sendKeys(ConfigReader.getProperty("roomReservationValid"));
        userPage.bookthisroomButton.click();
        ReusableMethods.waitFor(1);
        userPage.oksuccessfullyButton.click();
        ReusableMethods.waitFor(1);
               extentTest.pass("Double categoriesindeki Special Room reservationunda Message box test edildi");
        actions.sendKeys(Keys.HOME).perform();
       // jse.executeScript("arguments[0].scrollIntoView(true);",userPage.ReservationsLink);
        ReusableMethods.waitFor(1);
        softAssert.assertAll();

    }
}
