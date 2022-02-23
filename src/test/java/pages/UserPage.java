package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UserPage {

    public UserPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // https://www.hotelmycamp.com/ main page log in click button
    @FindBy(xpath = "//li[@id='navLogon']")
    public WebElement mainLoginLink;

    // https://www.hotelmycamp.com/ main page------>Profil Link
    @FindBy(xpath = "(//a[@class='nav-link'])[7]")
    public WebElement profilLink;

    //login page login userName box
    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement loginUserBox;

    //login page login password box
    @FindBy(xpath = "//input[@name='Password']")
    public WebElement loginPasswordBox;

    //login page login login button
    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginButton;

    //Profil Page ---->Kullanici bilgileri webelemntleri
    @FindBy(xpath = "//div[@class='form-group']")
    public List<WebElement> profilPageList;

    @FindBy(xpath = "//div/li/a")
    public List<WebElement> userMenuCategoriesList;

    //Profil Page---> Reservations Link
    @FindBy(xpath = "//a[text()='Reservations']")
    public WebElement ReservationsLink;

    //Profil Page---> Single Link
    @FindBy(xpath = "//a[@href='/Rooms/6']")
    public WebElement SingleLink;
      //   /html/body/section[1]/div/div/div[2]/div[2]/div/li[1]/a
    //a[@href='/Rooms/6']

    //Profil Page---> double Link
    @FindBy(xpath = "//a[@href='/Rooms/7']")
    public WebElement doubleLink;

    //Profil Page---> reservation Text
    @FindBy(xpath = "/html/body/section[1]/div/div/div[1]/div/h2")
    public WebElement reservationText;

    //Profil Page---->Reservations
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> reservationList;

    //Profil Page---->User Menu--->Reservation---> First Detail
    @FindBy(xpath = "/html/body/section[1]/div/div/div[1]/div/div/table/tbody/tr/td[6]/a")
    public List<WebElement> detailLinkList;


    //Profil Page---->User Menu--->Reservation--->First Reservation Details Table
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> firstReservationDetailTable;


    //Profil Page---->Categories------>Single Link----->Rooms Text
    @FindBy(xpath = "//h1[text()='Rooms']")
    public WebElement roomsText;

    //Profil Page---->Categories------>Single Link----->Special Room Book Now Link
    @FindBy(xpath = "(//a[@class='btn-custom'])[3]")
    public WebElement specialRoomBook;


    //Profil Page---->Categories------>Single Link----->King Room Book Now Link
    @FindBy(xpath = "(//a[@class='btn-custom'])[4]")
    public WebElement kingRoomBook;

    //Profil Page---->Categories------>Single Link----->Qw Room Book Now Link
    @FindBy(xpath = "(//a[@class='btn-custom'])[4]")
    public WebElement qwRoomBook;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->check in date box
    @FindBy(xpath = "(//input[@data-val='true'])[2]")
    public WebElement checkindatebox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->check out date box
    @FindBy(xpath = "(//input[@data-val='true'])[3]")
    public WebElement checkOutdatebox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->select adult acount box
    @FindBy(xpath = "//select[@id='AdultCount']")
    public WebElement selectadultacountbox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->select children acount box
    @FindBy(xpath = "//select[@id='ChildrenCount']")
    public WebElement selectchildrenacountbox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->name surname box
    @FindBy(xpath = "//input[@id='NameSurname']")
    public WebElement namesurnamebox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->email adress box
    @FindBy(xpath = "//input[@name='EmailAddress']")
    public WebElement emailadressbox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->phone number box
    @FindBy(xpath = "//input[@id='PhoneNumber']")
    public WebElement phonenumberbox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->name credit card box
    @FindBy(xpath = "//input[@id='NameOnCreditCard']")
    public WebElement namecreditcardbox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->credit card number box
    @FindBy(xpath = "//input[@id='CreditCardNumber']")
    public WebElement creditcardNumberdbox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->Select Expiration Year For Credit Card
    @FindBy(xpath = "//select[@id='CreditCardExpirationYear']")
    public WebElement creditCardExpirationYear;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->Select Expiration Month For Credit Card
    @FindBy(xpath = "//select[@id='CreditCardExpirationMonth']")
    public WebElement CreditCardExpirationMonth;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->credit card cvv box
    @FindBy(xpath = "//input[@id='cvv']")
    public WebElement cvvbox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->message box
    @FindBy(xpath = "//textarea[@id='Message']")
    public WebElement messageBox;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->book this room button
    @FindBy(xpath = "//input[@value='Book this room']")
    public WebElement bookthisroomButton;

    //Profil Page---->Categories------>Single Link----->Special Room Book Link---->book this room button----->successfully button
    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement oksuccessfullyButton;

    //Home Page---->Log-in
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement firstLoginLinki;
    @FindBy(xpath = "//span[@class='btn btn-primary py-3 px-5']")
    public WebElement createNewAccountButonu;
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement userNameTextbox;
    @FindBy(xpath = "//label[@for='UserName']")
    public WebElement userNameTextboxFailed;
    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordTextbox;
    @FindBy(xpath = "//label[@for='Email']")
    public WebElement passwordTextboxFailed;
    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailTextbox;
    @FindBy(xpath = "//label[@for='Email']")
    public WebElement emailTextboxFailed;
    @FindBy(xpath = "//input[@id='NameSurname']")
    public WebElement fullNameTextbox;
    @FindBy(xpath = "//label[@for='NameSurname']")
    public WebElement fullNameTextboxFailed;
    @FindBy(xpath = "//input[@id='PhoneNo']")
    public WebElement PhoneNoTextbox;
    @FindBy(xpath = "//label[@for='PhoneNo']")
    public WebElement PhoneNoTextboxFailed;
    @FindBy(xpath = "//input[@id='SSN']")
    public WebElement SSNTextbox;
    @FindBy(xpath = "//label[@for='SSN']")
    public WebElement SSNTextboxFailed;
    @FindBy(xpath = "//input[@id='DrivingLicense']")
    public WebElement DrivingLicenseTextbox;
    @FindBy(xpath = "//label[@for='DrivingLicense']")
    public WebElement DrivingLicenseTextboxFailed;
    @FindBy(xpath = "//select[@id='IDCountry']")
    public WebElement IDCountryTextbox;
    @FindBy(xpath = "//label[@for='IDCountry']")
    public WebElement IDCountryTextboxFailed;
    @FindBy(xpath = "//select[@id='IDState']")
    public WebElement IDStateTextbox;
    @FindBy(xpath = "//input[@id='Address']")
    public WebElement AddressTextbox;
    @FindBy(xpath = "//label[@for='Address']")
    public WebElement AddressTextboxFailed;
    @FindBy(xpath = "//input[@id='WorkingSector']")
    public WebElement WorkingSectorTextbox;
    @FindBy(xpath = "//label[@for='WorkingSector']")
    public WebElement WorkingSectorTextboxFailed;
    @FindBy(xpath = "//input[@id='BirthDate']")
    public WebElement BirthDateTextbox;
    @FindBy(xpath = "//label[@for='BirthDate']")
    public WebElement BirthDateTextboxFailed;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement savebutonu;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okbutonu;
    @FindBy(tagName= "h1")
    public WebElement registertext;

}
