package tests.US_08;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RoomReservationsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03 extends TestBaseRapor {

    RoomReservationsPage roomReservationsPage;
    SoftAssert softAssert;

    @Test
    public void AddRoomReservationButton(){
        softAssert = new SoftAssert();
        roomReservationsPage = new RoomReservationsPage();

        roomReservationsPage.roomReservationsMenu();

            extentTest=extentReports.createTest("Add Room Reservation Butonu gorunurluk ve islevsellik  Testi","Add Room Reservation sayfasina gidildi");

        softAssert.assertTrue(roomReservationsPage.addRoomReservationButton.isDisplayed());
            extentTest.info("Add Room Reservation Butonu goruldu");
        softAssert.assertFalse(!roomReservationsPage.addRoomReservationButton.isEnabled());
            extentTest.info("Add Room Reservation Butonu aktif");

        roomReservationsPage.addRoomReservationButton.click();
        softAssert.assertTrue(roomReservationsPage.createHotelRoomReservationText.isDisplayed());
            extentTest.info("Add Room Reservation Butonu tiklandi ve 'Create Hotelroomreservatıon' yazisi goruldu");

        roomReservationsPage.logOut();

        softAssert.assertAll();

    }

}
