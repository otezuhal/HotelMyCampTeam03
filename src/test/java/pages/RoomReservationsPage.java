package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class RoomReservationsPage {

    public RoomReservationsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement firstLoginLink;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginButton;


    @FindBy(xpath = "//a[@id='menuHotels']")
    public WebElement hotelManagementMenu;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[4]")
    public WebElement roomReservationsMenu;

    @FindBy(xpath = "//span[text()='Add Room Reservation '] ")
    public WebElement addRoomReservationButton;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement createHotelRoomReservationText;



    @FindBy(xpath = "//select[@id='IDUser']")
    public WebElement selectIDUserBox;
    @FindBy(xpath = "//label[@for='IDUser']")
    public WebElement selectIDUserWarningText;

    @FindBy(xpath = "//select[@id='IDHotelRoom']")
    public WebElement selectHotelRoomBox;
    @FindBy(xpath = "//label[@for='IDHotelRoom']")
    public WebElement selectIDHotelRoomWarningText;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement priceBox;
    @FindBy(xpath = "//label[@for='Price']")
    public WebElement priceBoxWarningText;

    @FindBy(xpath = "//input[@id='DateStart']")
    public WebElement dateStartBox;
    @FindBy(xpath = "//label[@for='DateStart']")
    public WebElement dateStartWarningText;

    @FindBy(xpath = "//input[@id='DateEnd']")
    public WebElement dateEndBox;
    @FindBy(xpath = "//label[@for='DateEnd']")
    public WebElement dateEndWarningText;

    @FindBy(xpath = "//input[@id='AdultAmount']")
    public WebElement adultAmountBox;
    @FindBy(xpath = "//label[@for='AdultAmount']")
    public WebElement adultAmountWarningText;

    @FindBy(xpath = "//input[@id='ChildrenAmount']")
    public WebElement childrenAmountBox;
    @FindBy(xpath = "//label[@for='ChildrenAmount']")
    public WebElement childrenAmountWarningText;

    @FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement contactNameSurnameBox;
    @FindBy(xpath = "//label[@for='ContactNameSurname']")
    public WebElement contactNameSurnameWarningText;

    @FindBy(xpath = "//input[@id='ContactPhone']")
    public WebElement contactPhoneBox;
    @FindBy(xpath = "//label[@for='ContactPhone']")
    public WebElement contactPhoneWarningText;

    @FindBy(xpath = "//input[@id='ContactEmail']")
    public WebElement contactEmailBox;
    @FindBy(xpath = "//label[@for='ContactEmail']")
    public WebElement contactEmailWarningText;

    @FindBy(xpath = "//input[@name='Notes']")
    public WebElement notesBox;
    @FindBy(xpath = "//label[@for='Notes']")
    public WebElement notesWarningText;

    @FindBy(xpath = "//div[@id='uniform-Approved']")
    public WebElement approvedCheckBox;

    @FindBy(xpath = "//div[@id='uniform-IsPaid']")
    public WebElement isPaidCheckBoxx;


    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement managerDropDownButton;
    @FindBy(xpath = "//i[@class='icon-key']")
    public WebElement logOutButtonn;


    public void managerLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        firstLoginLink.click();
        usernameTextBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordTextBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        loginButton.click();
    }
    public void roomReservationsMenu(){
        managerLogin();
        hotelManagementMenu.click();
        roomReservationsMenu.click();
    }
    public void createRoomReservation(){
        managerLogin();
        hotelManagementMenu.click();
        roomReservationsMenu.click();
        addRoomReservationButton.click();
    }
    public void logOut(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(managerDropDownButton).perform();
        ReusableMethods.waitFor(3);
        logOutButtonn.click();
        ReusableMethods.waitFor(3);
    }

    //After login ===> HotelManagement Button
    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementButton;

    //HotelManagemet ===> RoomReservation Button
    @FindBy(xpath = "//a[@href='/admin/RoomReservationAdmin']")
    public WebElement roomReservationButton;

    //List of Reservations ===> All recors
    @FindBy(xpath = "(//option[@value='-1'])[1]")
    public WebElement allRecorsButton;


    /* //List of Reservations ===> Details Button
     @FindBy(xpath = "(//a[text()=' Details'])[n]")
     public WebElement detailsButton;*/
    public WebElement detailsButtonLocate(int tablodanIstenenDetails){
        WebElement detailsButton=Driver.getDriver().findElement(By.xpath("(//a[text()=' Details'])["+tablodanIstenenDetails+"]"));
        return detailsButton;
    }

    //Details ===> General Data Button
    @FindBy(xpath = "//a[text()='General Data']")
    public WebElement generalDataButton;

    //Details ===> Properties Button
    @FindBy(xpath = "//a[@href='#tab_properties']")
    public WebElement propertiesButton;

    //Details ===> General Data Button ===> HotelRoom Select
    @FindBy(xpath = "//select[@id='IDHotelRoom']")
    public WebElement hotelRoomSelect;

    //Details ===> General Data Button ===> User Select
    @FindBy(xpath = "//select[@id='IDUser']")
    public WebElement userSelect;

    //Details ===> General Data Button ===> Price TextBox
    @FindBy(xpath = "//input[@id='Price']")
    public WebElement priceTextBox;

    //Details ===> General Data Button ===> DateStart
    @FindBy(xpath = "//input[@id='DateStart']")
    public WebElement dateStart;

    //Details ===> General Data Button ===> DateEnd
    @FindBy(xpath = "//input[@id='DateEnd']")
    public WebElement dateEnd;

    //Details ===> General Data Button ===> AdultAmount
    @FindBy(xpath = "//input[@id='AdultAmount']")
    public WebElement adultAmount;

    //Details ===> General Data Button ===> ChildrenAmount
    @FindBy(xpath = "//input[@id='ChildrenAmount']")
    public WebElement childrenAmount;

    //Details ===> General Data Button ===> ContactNameSurname
    @FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement contactNameSurname;

    //Details ===> General Data Button ===> ContactPhone
    @FindBy(xpath = "//input[@id='ContactPhone']")
    public WebElement contactPhone;

    //Details ===> General Data Button ===> ContactEmail
    @FindBy(xpath = "//input[@id='ContactEmail']")
    public WebElement contactEmail;

    //Details ===> General Data Button ===> Notes
    @FindBy(xpath = "//input[@id='Notes']")
    public WebElement notes;

    //Details ===> General Data Button ===> ApprovedCheckBox
    @FindBy(xpath = "//input[@id='Approved']")
    public WebElement aprrovedCheckBox;

    //Details ===> General Data Button ===> IsPaidCheckBox
    @FindBy(xpath = "//input[@id='IsPaid']")
    public WebElement isPaidCheckBox;

    //Details ===> General Data Button ===> Save Button
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    //Details ===> General Data Button ===> Delete Button
    @FindBy(xpath = "(//div//button[@class='btn blue'])[2]")
    public WebElement deleteButton;

    //Details ===> Properties ===> Tip TextBox
    @FindBy(xpath = "//select[@id='lkpBarcodeTypes']")
    public WebElement propertiesTipTextBox;

    //Details ===> Properties ===> Code TextBox
    @FindBy(xpath = "//input[@id='txtBarcodeCode']")
    public WebElement propertiesCodeTextBox;

    //Details ===> Properties ===> Value Text Box
    @FindBy(xpath = "//textarea[@id='txtBarcode']")
    public WebElement propertiesValueTextBox;

    //Details ===> Properties ===> Save Button
    @FindBy(xpath = "//*[@id=\"tab_properties\"]/div/div[2]/div[2]/div[4]/div[2]/button")
    public WebElement propertiesSaveButton;

    //Details ===> Properties ===> Barcodes Records
    @FindBy(xpath = "//div[@id='datatable_barcodes_info']")
    public WebElement propertiesBarcodesRecords;


    //Details ===> Properties ===> All Records
    @FindBy(xpath = "(//option[@value='-1'])[1]")
    public WebElement propertiesAllRecords;

    //Details ===> Properties ===> WebTable's webelements calling
    public WebElement propertiesDynamicRow(int rowNumber, int elementNumber){
        // elementnumber 2 ==> code / 3 ==> value

        String path="//tbody//tr["+rowNumber+"]//td["+elementNumber+"]//*";
        WebElement caodeOrValue=Driver.getDriver().findElement(By.xpath(path));
        return caodeOrValue;
    }


    //Details ===> Properties ===> WebTable's webelements calling
    public WebElement propertiesWebTableUpdateButton(int rowNumber){
        // elementnumber 2 ==> code / updateButon ==> 6
        String path="//tbody//tr["+rowNumber+"]//td[6]//i[@class='fa fa-check']";
        WebElement updateButtonInRow=Driver.getDriver().findElement(By.xpath(path));

        return updateButtonInRow;
    }



    //Details ===> Properties ===> WebTable "ok" popup
    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement popUpOkButton;

    //Delete ayrica locate edilmedi General Data ile ortak


    //Details ===> GeneralData ===> Delete popup message
    @FindBy(xpath = "//div[text()='Would you like to continue?']")
    public WebElement deletePopUpMessage;


    //savepopup message
    @FindBy(xpath = "//div//div[@class='bootbox-body']")
    public WebElement savePopUpMessage;

    //logout button
    @FindBy(xpath = "//a[@href='/Admin/Account/Logoff']")
    public WebElement logOutButton;
    //Manager dropdown
    @FindBy(xpath = "//li[@class='dropdown dropdown-user']")
    public WebElement managerDropDown;

}
