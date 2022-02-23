package tests.E2ETest.US_09;

import org.testng.annotations.Test;
import pages.RoomReservationsPage;
import utilities.TestBaseRapor;

public class TC_002 extends TestBaseRapor {
    RoomReservationsPage roomReservationsPage;



    @Test
    public void roomReservationCategory(){
        roomReservationsPage=new RoomReservationsPage();
        extentTest=extentReports.createTest("TC_002","Hotel Management basligi altindan 'Room Reservations' kategorisine gecilebilmeli");
        roomReservationsPage.hotelManagementButton.click();
        extentTest.info("Acilan sayfadan 'Hotel Management' basligina tiklandi");
        roomReservationsPage.roomReservationButton.click();
        extentTest.info("'Hotel Management' basligina altindan 'Room Reservations' kategorisine gecildi");
        roomReservationsPage.allRecorsButton.click();
        extentTest.info("Tablodaki butun kayitlara ulasabilmek icin 'All' basligi secildi");
    }
}