package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //.....Navbar buttonlari icin locate'ler......
    @FindBy(xpath = "//a[text()='Home']")
    public WebElement mainPageNavbarHomeButton;
    @FindBy(xpath = "(//a[text()='Rooms'])[1]")
    public WebElement mainPageNavbarRoomsButton;
    @FindBy(xpath = "//a[text()='Restaurant']")
    public WebElement mainPageNavbarRestaurantButton;
    @FindBy(xpath = "//a[text()='About']")
    public WebElement mainPageNavbarAboutButton;
    @FindBy(xpath = "(//a[text()='Blog'])[1]")
    public WebElement mainPageNavbarBlogButton;
    @FindBy(xpath = "//a[text()='Contact']")
    public WebElement mainPageNavbarContactButton;
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement mainPageNavbarLoginButton;
    //Navbar button larinin clik olmasi ve istenen sayfaya yonlendirmesi
    @FindBy(xpath = "(//h1[text()='Welcome To Hotelmycamp'])[2]")
    public WebElement mainPageHomeButtonBasariliGirisYazisi;
    //CHECK-IN DATE
    @FindBy(xpath = "//label[text()='Check-in Date']")
    public WebElement mainPageCheckInDateText;
    @FindBy(xpath = "//input[@id='checkin_date']")
    public WebElement mainPageCheckInDateInput;

    @FindBy(xpath = "//body//tr//td[.='10']")
    public WebElement mainPageCheckInDateInputSecilecekGun;
    @FindBy(xpath = "(//th[@class='next'])[1]")
    public WebElement mainPageCheckInDateInputNext;


    //CHECK-OUT DATE
    @FindBy(xpath = "//label[text()='Check-out Date']")
    public WebElement mainPageCheckOutDateText;
    @FindBy(xpath = "//input[@id='checkout_date']")
    public WebElement getMainPageCheckOutDateInput;
    @FindBy(xpath = "//body//tr//td[.='25']")
    public WebElement mainPageCheckInDateOutputSecilecekGun;
    @FindBy(xpath = "(//th[@class='next'])[1]")
    public WebElement mainPageCheckInDateOutputNext;

    @FindBy (xpath = "//select[@name='IDRoomType']")
    public WebElement idHotelRoomTypeBox1;

    @FindBy(xpath = "//select[@name='AdultCount']")
    public  WebElement adultCountBox1;

    @FindBy(xpath = "//input[@value='Check Availability']")
    public WebElement checkAvailabilityButton;


    // Check Avibility Page
    @FindBy(xpath = "//input[@id='checkin_date']")
    public WebElement checkInDateBox2;

    @FindBy(xpath = "//input[@id='checkout_date']")
    public WebElement checkOutDateBox2;

    @FindBy(xpath = "//select[@id='IDRoomType']")
    public WebElement idHotelRoomTypeBox2;

    @FindBy(xpath = "//select[@id='AdultCount']")
    public WebElement adultCountBox2;








    //Room Box

    @FindBy(id = "IDRoomType")
    public WebElement mainPageRoomBox;

    //Customer Box

    @FindBy(id="AdultCount")
    public WebElement mainPageCustomerBox;





    //Home Page---->Log-in
    @FindBy(xpath="//a[text()='Log in']")
    public WebElement firstLoginLinki;


    //Home Page---->Log-in------>Username TextBox
    @FindBy(id="UserName")
    public WebElement firstUserNameBox;


    //Home Page---->Log-in------>Password TextBox
    @FindBy(id="Password")
    public WebElement firstPasswordBox;


    //Home Page---->Log-in------>Log-in Button
    @FindBy(id="btnSubmit")
    public WebElement secondLoginButonu;

    @FindBy(xpath = "//a[.='Log out']")
    public WebElement logOutLink;
    public void managerHotelMyCampGiris (){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
       ReusableMethods.waitFor(3);
        firstLoginLinki.click();
        ReusableMethods.waitFor(1);
        firstUserNameBox.clear();
        firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCManagerValidUsername"));
        ReusableMethods.waitFor(1);
        firstPasswordBox.clear();
        firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCManagerValidPassword"));
        ReusableMethods.waitFor(1);
        secondLoginButonu.click();

    }

}