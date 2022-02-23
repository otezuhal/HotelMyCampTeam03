package tests.E2ETest.US_09;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RoomReservationsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC_004 extends TestBaseRapor {

    SoftAssert softAssert;
    RoomReservationsPage roomReservationsPage;



    @Test(priority = 1)
    public void generalDataDelete(){
        roomReservationsPage=new RoomReservationsPage();
        softAssert=new SoftAssert();


        extentTest=extentReports.createTest("TC_004","List Of Reservations tablosundaki bilgieri silebilmeli");

        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
        roomReservationsPage.detailsButtonLocate(1).click();
        ReusableMethods.waitFor(3);
        roomReservationsPage.deleteButton.click();
        extentTest.info("'General Data' basligi altindaki 'Delete Hotel Room Reservation' kategorisinde yer alan 'Delete' butonuna tiklandi");
        try{
            softAssert.assertFalse(roomReservationsPage.deletePopUpMessage.isDisplayed());
        }catch (NoSuchElementException e){
            extentTest.fail("'General Data' basligi altindaki reservation bilgileri silinemedi");
        }

    }

    @Test(priority = 2)
    public void propertiesDelete(){
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
        roomReservationsPage.detailsButtonLocate(1).click();
        ReusableMethods.waitFor(3);
        roomReservationsPage.propertiesButton.click();
        roomReservationsPage.deleteButton.click();
        extentTest.info("'Properties' basligi altindaki 'Delete Hotel Room Reservation' kategorisinde yer alan 'Delete' butonuna tiklandi");
        try{
            softAssert.assertFalse(roomReservationsPage.deletePopUpMessage.isDisplayed());
        }catch (NoSuchElementException e){
            extentTest.fail("'Properties' basligi altindaki reservation bilgileri silinemedi");
        }
        Driver.closeDriver();
    }
}