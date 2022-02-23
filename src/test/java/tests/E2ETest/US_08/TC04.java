package tests.E2ETest.US_08;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelRoomsPage;
import pages.RoomReservationsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static utilities.JSUtils.scrollIntoVIewJS;

public class TC04 extends TestBaseRapor {

    RoomReservationsPage roomReservationsPage;
    SoftAssert softAssert;

    @Test
    public void createHotelRoomReservation(){
        softAssert = new SoftAssert();
        roomReservationsPage = new RoomReservationsPage();
            extentTest=extentReports.createTest("Create a New Hotel Room Reservation Test","Formdaki kutularin pozitif ve negatif senaryolarla doldurulmasi test edildi");
        roomReservationsPage.createRoomReservation();
    }
    @Test(dependsOnMethods ="createHotelRoomReservation" )
    public void aselectUserBox(){
        Select options = new Select(roomReservationsPage.selectIDUserBox);

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(3);
        roomReservationsPage.saveButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(roomReservationsPage.selectIDUserWarningText.isDisplayed(),"SelectIDUser Warning Text is not visible");
            extentTest.info("Select User ID Box bos birakilarak devam edilemedi");

        for (int i = 1; i < 3; i++) {
            options.selectByIndex(i);
        }
        Assert.assertFalse(roomReservationsPage.selectIDUserWarningText.isDisplayed(),"SelectIDUser Warning Text is visible");
            extentTest.info("Select User ID Box acilan dropdowndan secim yapilarak kutu dolduruldu");
    }
    @Test(dependsOnMethods = "createHotelRoomReservation")
    public void bselectHotelBox(){
        Select options = new Select(roomReservationsPage.selectHotelRoomBox);

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(3);
        roomReservationsPage.saveButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(roomReservationsPage.selectIDHotelRoomWarningText.isDisplayed(),"SelectIDHotelRoom Warning Text is not visible");
            extentTest.info("Select User ID Hotel Room Box bos birakilarak devam edilemedi");

        for (int i = 1; i < 10; i++) {
            options.selectByIndex(i);
        }
        Assert.assertFalse(roomReservationsPage.selectIDHotelRoomWarningText.isDisplayed(),"SelectIDHotelRoom Warning Text is visible");
            extentTest.info("Select User ID Hotel Room Box acilan dropdowndan secim yapilarak kutu dolduruldu");
    }

        @DataProvider
        public Object[][] wrongPrices(){

        Object[][] invalidPrices={{"abc"},{"-100"},{"0"},{"000"}};

        return invalidPrices;
        }
    @Test(dependsOnMethods = "createHotelRoomReservation",dataProvider = "wrongPrices")
    public void cpriceBoxNegativeTest(Object invalidPrices){

        roomReservationsPage.priceBox.sendKeys((CharSequence) invalidPrices);

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        roomReservationsPage.saveButton.click();
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(roomReservationsPage.priceBoxWarningText.isDisplayed(),"PriceBox Warning Text is not visible");
            extentTest.info("Price Box negatif senaryolarla form doldurmayi kabul etmedi");
        roomReservationsPage.priceBox.clear();
    }
    @Test(dependsOnMethods = "createHotelRoomReservation")
    public void dpriceBoxPositiveTest(){

        roomReservationsPage.priceBox.sendKeys("100");

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        roomReservationsPage.saveButton.click();
        ReusableMethods.waitFor(2);
        softAssert.assertFalse(roomReservationsPage.priceBoxWarningText.isDisplayed(),"PriceBox Warning Text is visible");

            extentTest.info("Price Box pozitif senaryo testini gecti");
    }

        @DataProvider
        public Object[][] wrongDateDatas(){

        Object[][] invalidDateData=new Object[4][2];

        invalidDateData[0][0]="03/30/2022";
        invalidDateData[0][1]="03/15/2022";
        invalidDateData[1][0]="03/30/2021";
        invalidDateData[1][1]="03/30/2021";
        invalidDateData[2][0]="03/15/2021";
        invalidDateData[2][1]="03/30/2021";
        invalidDateData[3][0]="03/30/2022";
        invalidDateData[3][1]="03/30/2022";

        return invalidDateData;
        }
    @Test(dependsOnMethods = "createHotelRoomReservation",dataProvider = "wrongDateDatas")
    public void edateBoxesNegativeTest(String dateStart, String dateEnd){

        roomReservationsPage.dateStartBox.sendKeys(dateStart);
        roomReservationsPage.dateEndBox.sendKeys(dateEnd);

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        roomReservationsPage.saveButton.click();
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(roomReservationsPage.dateStartWarningText.isDisplayed(),"DateStart Warning Text is not visible");
        softAssert.assertTrue(roomReservationsPage.dateEndWarningText.isDisplayed(),"DateEnd Warning Text is not visible");
        ReusableMethods.waitFor(2);
            extentTest.info("(!)Date Box negatif senaryolarla form doldurmayi kabul etmemesi gerekirken kabul etti");
        roomReservationsPage.dateStartBox.clear();
        roomReservationsPage.dateEndBox.clear();
    }
    @Test(dependsOnMethods = "createHotelRoomReservation" )
    public void fdateBoxesPositiveTest(){

        DateTimeFormatter dateFormat= DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate tod = LocalDate.now();
        LocalDate today = tod.plusDays(1);
        LocalDate future = tod.plusDays(7);

        ReusableMethods.waitFor(2);
        roomReservationsPage.dateStartBox.sendKeys(dateFormat.format(today));
        ReusableMethods.waitFor(2);
        roomReservationsPage.dateEndBox.sendKeys(dateFormat.format(future));
        softAssert.assertFalse(roomReservationsPage.dateStartWarningText.isDisplayed(),"DateStart Warning Text is visible");
        softAssert.assertFalse(roomReservationsPage.dateEndWarningText.isDisplayed(),"DateEnd Warning Text is visible");
            extentTest.info("Date Boxes pozitif senaryolarla test edildi");
        scrollIntoVIewJS(roomReservationsPage.saveButton);
        roomReservationsPage.saveButton.click();
    }

        @DataProvider
        public Object[][] wrongAdultChildrenAmount(){

        Object[][] invalidPersonAmount=new Object[3][2];

        invalidPersonAmount[0][0]="abc";
        invalidPersonAmount[0][1]="abc";
        invalidPersonAmount[1][0]="2.4";
        invalidPersonAmount[1][1]="1.3";
        invalidPersonAmount[2][0]="0";
        invalidPersonAmount[2][1]="2";

        return invalidPersonAmount;
        }
    @Test(dependsOnMethods = "createHotelRoomReservation",dataProvider = "wrongAdultChildrenAmount")
    public void gadultChildrenAmountNegativeTest(String adult, String children){

        roomReservationsPage.adultAmountBox.sendKeys(adult);
        roomReservationsPage.childrenAmountBox.sendKeys(children);

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(1);
        roomReservationsPage.saveButton.click();
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(roomReservationsPage.adultAmountWarningText.isDisplayed(),"AdultAmount Warning Text is not visible");
        softAssert.assertTrue(roomReservationsPage.childrenAmountWarningText.isDisplayed(),"ChildrenAmount Warning Text is not visible");
        ReusableMethods.waitFor(2);
            extentTest.info("Person Amount Boxes negatif senaryolarla test edildi");
        ReusableMethods.waitFor(1);
        roomReservationsPage.adultAmountBox.clear();
        ReusableMethods.waitFor(1);
        roomReservationsPage.childrenAmountBox.clear();
    }
    @Test(dependsOnMethods = "createHotelRoomReservation")
    public void hadultChildrenAmountPositiveTest(){

        roomReservationsPage.adultAmountBox.sendKeys("2");
        roomReservationsPage.childrenAmountBox.sendKeys("1");
        softAssert.assertFalse(roomReservationsPage.adultAmountWarningText.isDisplayed(),"AdultAmount Warning Text is visible");
        softAssert.assertFalse(roomReservationsPage.childrenAmountWarningText.isDisplayed(),"ChildrenAmount Warning Text is visible");

            extentTest.info("Person Amount Boxes pozitif senaryolarla test edildi");

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(1);
        roomReservationsPage.saveButton.click();
    }

        @DataProvider
        public Object[][] wrongContactNameSurname() {

        Object[][] invalidContactNameSurname = {{"123"},{" "},{"!@#$%^&*()_+=-"}};

        return invalidContactNameSurname;
        }
    @Test(dependsOnMethods = "createHotelRoomReservation", dataProvider = "wrongContactNameSurname" )
    public void jcontactNameSurnameNegativeTest(String nameSurname){

        scrollIntoVIewJS(roomReservationsPage.contactNameSurnameBox);
        ReusableMethods.waitFor(3);
        roomReservationsPage.contactNameSurnameBox.sendKeys(nameSurname);

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(3);
        roomReservationsPage.saveButton.click();
        softAssert.assertTrue(roomReservationsPage.contactNameSurnameWarningText.isDisplayed(),"ContactNameSurname Warning Text is not visible");
            extentTest.info("Contact Name Surname Box negatif testi gecti");

        roomReservationsPage.contactNameSurnameBox.clear();
        ReusableMethods.waitFor(3);
    }
    @Test(dependsOnMethods = "createHotelRoomReservation")
    public void kcontactNameSurnamePositiveTest(){
        scrollIntoVIewJS(roomReservationsPage.contactNameSurnameBox);
        ReusableMethods.waitFor(3);
        roomReservationsPage.contactNameSurnameBox.sendKeys(Faker.instance().name().fullName());

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(3);
        roomReservationsPage.saveButton.click();
        softAssert.assertFalse(roomReservationsPage.contactNameSurnameWarningText.isDisplayed(),"ContactNameSurname Warning Text is visible");
            extentTest.info("Contact Name Surname Box pozitif testi gecti");
    }

        @DataProvider
        public Object[][] wrongContactPhone(){

        Object[][] invalidContactPhone={{"abc"},{""},{"123"},{"123456ab"},{"   "}};

        return invalidContactPhone;
        }
    @Test(dependsOnMethods = "createHotelRoomReservation",dataProvider = "wrongContactPhone")
    public void lcontactPhoneNegativeTest(String invalidPhone){
        scrollIntoVIewJS(roomReservationsPage.contactPhoneBox);
        ReusableMethods.waitFor(2);
        roomReservationsPage.contactPhoneBox.sendKeys(invalidPhone);

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(1);
        roomReservationsPage.saveButton.click();
        softAssert.assertTrue(roomReservationsPage.contactPhoneWarningText.isDisplayed(),"ContactPhone Warning Text is not visible");
            extentTest.info("Contact Phone Box negatif testi gecti");

        roomReservationsPage.contactPhoneBox.clear();
        ReusableMethods.waitFor(1);
    }
    @Test(dependsOnMethods = "createHotelRoomReservation")
    public void mcontactPhonePositiveTest(){
        scrollIntoVIewJS(roomReservationsPage.contactPhoneBox);
        ReusableMethods.waitFor(2);
        roomReservationsPage.contactPhoneBox.sendKeys("1231231234");

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(1);
        roomReservationsPage.saveButton.click();
        softAssert.assertFalse(roomReservationsPage.contactPhoneWarningText.isDisplayed(),"ContactPhone Warning Text is visible");
            extentTest.info("Contact Phone Box pozitif testi gecti");
    }

        @DataProvider
        public Object[][] wrongContactEmail(){

        Object[][] invalidContactEmail={{"asd@g.c"},{"asdgmail.com"},{"asd@gmailcom"},{"@gmail.com"},{"123"},{"abc"},{"   "}};

        return invalidContactEmail;
        }
    @Test(dependsOnMethods = "createHotelRoomReservation",dataProvider = "wrongContactEmail")
    public void ncontactEmailNegativeTest(String invalidEmail){
        scrollIntoVIewJS(roomReservationsPage.contactEmailBox);
        ReusableMethods.waitFor(2);
        roomReservationsPage.contactEmailBox.sendKeys(invalidEmail);

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(1);
        roomReservationsPage.saveButton.click();
        softAssert.assertTrue(roomReservationsPage.contactEmailWarningText.isDisplayed(),"ContactEmail Warning Text is not visible");
            extentTest.info("Contact Email Box negatif testi gecti");

        roomReservationsPage.contactEmailBox.clear();
        ReusableMethods.waitFor(1);
    }
    @Test(dependsOnMethods = "createHotelRoomReservation")
    public void ocontactEmailPositiveTest(){
        scrollIntoVIewJS(roomReservationsPage.contactEmailBox);
        ReusableMethods.waitFor(2);
        roomReservationsPage.contactEmailBox.sendKeys("khaleesi@gmail.com");

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(1);
        roomReservationsPage.saveButton.click();
        softAssert.assertFalse(roomReservationsPage.contactEmailWarningText.isDisplayed(),"ContactEmail Warning Text is visible");
            extentTest.info("Contact Email Box pozitif testi gecti");

    }
    @Test(dependsOnMethods = "createHotelRoomReservation")
    public void qnotesTest(){
        scrollIntoVIewJS(roomReservationsPage.notesBox);
        ReusableMethods.waitFor(3);
        roomReservationsPage.notesBox.sendKeys("denedim ama olmadi");
        softAssert.assertFalse(roomReservationsPage.notesWarningText.isDisplayed(),"Notes Warning Text is visible");
        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(3);
        roomReservationsPage.saveButton.click();
            extentTest.info("Notes Box testi gecti");
    }
    @Test(dependsOnMethods = "createHotelRoomReservation")
    public void rapprovedIsPaidButtons(){
        scrollIntoVIewJS(roomReservationsPage.approvedCheckBox);
        ReusableMethods.waitFor(3);
        Actions actions=new Actions(Driver.getDriver());
        actions.doubleClick(roomReservationsPage.approvedCheckBox).perform();
       // roomReservationsPage.approvedCheckBox.click();
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(roomReservationsPage.approvedCheckBox.isDisplayed(),"Approved checkbox is visible");
            extentTest.info("Approved Checkbox test edildi");

        actions.doubleClick(roomReservationsPage.isPaidCheckBox).perform();
        //roomReservationsPage.isPaidCheckBox.click();
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(roomReservationsPage.isPaidCheckBox.isDisplayed(),"IsPaid checkbox is visible");
            extentTest.info("Is Paid Checkbox test edildi");

        scrollIntoVIewJS(roomReservationsPage.saveButton);
        ReusableMethods.waitFor(3);
        actions.click(roomReservationsPage.saveButton).perform();
    }
    @Test(dependsOnMethods = "createHotelRoomReservation")
    public void ssuccessfullySaved() throws IOException {

        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("RoomReservation was inserted successfully");
            extentTest.info("'RoomReservation was inserted successfully' yazisi goruldu");
        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
        WebElement clickButton= Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']"));

        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();

            if (hotelRoomsPage.managerLink.isDisplayed()){
                Actions  actions=new Actions(Driver.getDriver());
                ReusableMethods.waitFor(3);
                actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();
            }else {
                Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();

                Actions  actions=new Actions(Driver.getDriver());
                ReusableMethods.waitFor(3);
                actions.moveToElement(hotelRoomsPage.managerLink).click(hotelRoomsPage.logOutButton).perform();

            }


        softAssert.assertAll();
       // Driver.closeDriver();
    }
}
