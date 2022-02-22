package tests.US_08;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RoomReservationsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02 extends TestBaseRapor {


    RoomReservationsPage roomReservationsPage;

    @Test
    public void RoomReservationsPage(){
        roomReservationsPage = new RoomReservationsPage();
        roomReservationsPage.managerLogin();

            extentTest=extentReports.createTest("Room Reservation Sayfasina Gitme Testi","Room Reservation sayfasina gidildi");
        roomReservationsPage.hotelManagementMenu.click();
            extentTest.info("Hotel Management Menusune Tiklandi.");
        roomReservationsPage.roomReservationsMenu.click();
            extentTest.info("Room Reservations Menusu Tiklandi.");

        String expectedTitle="Admin - List Of Reservations";
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
            extentTest.info("Room Reservation sayfasina gidildi.");

        roomReservationsPage.logOut();

       // Driver.closeDriver();

    }

}
