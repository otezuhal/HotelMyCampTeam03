package tests.E2ETest.US_08;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {
    // hey there!!!

    RoomReservationsPage roomReservationsPage;


    @Test
    public void managerLogIn() {
        roomReservationsPage = new RoomReservationsPage();
            extentTest=extentReports.createTest("HMC Manager Login Test ","HMC Url'e gidildi ve manager olarak login yapildi");

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
            extentTest.info("HMCUrl'e gidildi");

        roomReservationsPage.firstLoginLink.click();
            extentTest.info("Anasayfadaki Login linkine tiklandi.");

        roomReservationsPage.usernameTextBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
            extentTest.info("Username textbox'a gecerli Username girildi");

        roomReservationsPage.passwordTextBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
            extentTest.info("Password textbox'a gecerli Password girildi");

        roomReservationsPage.loginButton.click();
            extentTest.info("Sayfadaki Login butonu tiklandi");

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Admin - ListOfUsers"));
            extentTest.info("Gecerli HMCValidUsername ve HMCValidPassword ile basarili giris yapildi");

        roomReservationsPage.logOut();

      //  Driver.closeDriver();

    }
}
