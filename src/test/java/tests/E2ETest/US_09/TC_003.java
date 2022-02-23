package tests.E2ETest.US_09;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RoomReservationsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_003 extends TestBaseRapor {
    RoomReservationsPage roomReservationsPage;
    Faker faker;
    SoftAssert softAssert;


    @Test(priority = 1)
    public void generalDataAndPropertiesClicks(){
        softAssert=new SoftAssert();
        faker=new Faker();
        roomReservationsPage=new RoomReservationsPage();
        extentTest=extentReports.createTest("TC_003","List Of Reservations tablosundaki bilgileri guncelleyerek kaydedebilmeli");

        roomReservationsPage.detailsButtonLocate(1).click();
        extentTest.info("Tablodaki bilgileri guncelleyebilmek icin herhangi bir reservationa ait 'Details' butonuna tiklandi");
        roomReservationsPage.propertiesButton.click();
        extentTest.info("Acilan sayfada 'Properties' butonuna tiklandi");
        roomReservationsPage.generalDataButton.click();
        extentTest.info("Acilan sayfada 'General Data' butonuna tiklandi");
    }

    @Test(priority = 2)
    public void generalDataChanges(){

        Select hotelRoomSelect=new Select(roomReservationsPage.hotelRoomSelect);
        hotelRoomSelect.selectByIndex(3);
        Select userSelect=new Select(roomReservationsPage.userSelect);
        userSelect.selectByIndex(3);
        roomReservationsPage.priceTextBox.sendKeys("303303030");
        roomReservationsPage.dateStart.sendKeys(faker.date().birthday(10,30).toString());
        roomReservationsPage.dateEnd.sendKeys(faker.date().birthday(10,30).toString());
        roomReservationsPage.adultAmount.sendKeys("65656");
        roomReservationsPage.childrenAmount.sendKeys("65454");
        roomReservationsPage.contactNameSurname.sendKeys(faker.name().fullName());
        roomReservationsPage.contactPhone.sendKeys(faker.phoneNumber().cellPhone());
        roomReservationsPage.contactEmail.sendKeys(faker.internet().emailAddress());
        roomReservationsPage.notes.sendKeys(Keys.BACK_SPACE);
        roomReservationsPage.aprrovedCheckBox.click();
        ReusableMethods.waitFor(3);
        roomReservationsPage.isPaidCheckBox.click();
        extentTest.info("'General Data' basligi altindaki reservation bilgileri degistirildi");
        roomReservationsPage.saveButton.click();
        extentTest.info("'General Data' basligi altinda bulunan save butonuna tiklandi");

        try{
            softAssert.assertFalse(roomReservationsPage.savePopUpMessage.isDisplayed());
        }catch (NoSuchElementException e){
            extentTest.fail("'General Data' basligi altindaki degisikliklerin kaydedilmedigi goruldu.");
        }

    }

    @Test(priority = 3)
    public void propertiesChanges(){

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",roomReservationsPage.hotelManagementButton);

        roomReservationsPage.propertiesButton.click();
        String isWebTableExist=roomReservationsPage.propertiesBarcodesRecords.getText();
        String noWebTables="No records found to show";
        if (!isWebTableExist.equals(noWebTables)){
            roomReservationsPage.propertiesAllRecords.click();
            ReusableMethods.waitFor(1);
            roomReservationsPage.propertiesDynamicRow(1,2).sendKeys("asdsad");
            ReusableMethods.waitFor(1);
            roomReservationsPage.propertiesDynamicRow(1,3).sendKeys("asdasd");
            extentTest.info("'Properties' basligi altindaki reservation bilgileri degistirildi");
            roomReservationsPage.propertiesWebTableUpdateButton(1).click();
            extentTest.info("'Properties' basligi altinda bulunan update butonuna tiklandi");
            roomReservationsPage.popUpOkButton.click();
            extentTest.info("'Properties' basligi altindaki degisikliklerin kaydedildigi goruldu.");
        }else{
            Select select=new Select(roomReservationsPage.propertiesTipTextBox);
            select.selectByIndex(1);
            roomReservationsPage.propertiesCodeTextBox.sendKeys(faker.numerify("12345"));
            roomReservationsPage.propertiesValueTextBox.sendKeys(faker.howIMetYourMother().highFive());
            extentTest.info("'Properties' basligi altindaki reservation bilgileri degistirildi");
            roomReservationsPage.propertiesSaveButton.click();
            extentTest.info("'Properties' basligi altinda bulunan save butonuna tiklandi");
            roomReservationsPage.popUpOkButton.click();
            extentTest.info("'Properties' basligi altindaki degisikliklerin kaydedildigi goruldu.");
        }

    }
}