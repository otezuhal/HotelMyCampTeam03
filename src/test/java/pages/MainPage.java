package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;


public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement firstLoginLinki;


    @FindBy(id = "UserName")
    public WebElement firstUserNameBox;


    @FindBy(id = "Password")
    public WebElement firstPasswordBox;


    @FindBy(id = "btnSubmit")
    public WebElement secondLoginButonu;


    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void managerHotelMyCampGiris() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        firstLoginLinki.click();
        ReusableMethods.waitFor(1);
        actions.
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                perform();
        firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        //ReusableMethods.waitFor(1);
        firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        //ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(secondLoginButonu);
        //secondLoginButonu.click();
    }

    //US001_TC0001 --> Navbar buttonlari icin locate'ler  <--------------

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

    //US001_TC0002 --> Navbar button larinin clik olmasi ve istenen sayfaya yonlendirmesi <------

    @FindBy(xpath = "(//div[@class='text mb-5 pb-3'])[4]")
    public WebElement homePageBasariliGiris;

    @FindBy(xpath = "//h1[@class='mb-4 bread']")
    public WebElement roomsPageBasariliGiris;

    @FindBy(xpath = "//h1[.='OurRestaurant']")
    public WebElement restaurantPageBasariliGiris;


    @FindBy(xpath = "//a[text()='About']")
    public WebElement aboutPageBasariliGiris;


    @FindBy(xpath = "//h2[text()='Blog']")
    public WebElement blogPageBasariliGiris;


    @FindBy(xpath = "//h1[.='Contact Form']")
    public WebElement contactPageBasariliGiris;

    @FindBy(xpath = "//h2[@class='mb-4']")
    public WebElement loginPageBasariliGiris;

    //US001_TC0003 --> ChechInDate button, CheckOutDate button, roomTypeButton, CustomerButton <-----
    @FindBy(xpath = "//input[@class='form-control checkin_date']")
    public WebElement mainPageCheckİnDateButton;

    @FindBy(xpath = "//input[@class='form-control checkout_date']")
    public WebElement mainPageCheckOutDateButton;

    @FindBy(xpath = "(//select[@class='form-control required'])[1]")
    public WebElement mainPageRoomTypeButton;

    @FindBy(xpath = "(//select[@class='form-control required'])[2]")
    public WebElement mainPageCustomerButton;

    @FindBy(xpath = "//input[@class='form-control checkin_date']")
    public WebElement mainPageCheckInDateInput;

    @FindBy(xpath = "//input[@id='checkout_date']")
    public WebElement getMainPageCheckOutDateInput;

    //CheckAvailability
    @FindBy(xpath = "//input[@id='checkin_date']")
    public WebElement checkAvailabilityCheckInDate;

    @FindBy(xpath = "//input[@id='checkout_date']")
    public WebElement checkAvailabilityCheckOutDate;

    @FindBy(xpath = "//select[@id='IDRoomType']")
    public WebElement checkAvailabilityRoomType;

    @FindBy(xpath = "//select[@id='AdultCount']")
    public WebElement checkAvailabilityCustomer;

    @FindBy(xpath = "//option[@value='7']")
    public WebElement checkAvailabilityRoomTypeFirst;

    @FindBy(xpath = "//select[@name='AdultCount']")
    public WebElement checkAvailabilityCustomerFirst;

    @FindBy(xpath = "//input[@id='checkin_date']")
    public WebElement checkAvailabilityCheckInDateFirst;

    @FindBy(xpath = "//input[@id='checkout_date']")
    public WebElement checkAvailabilityCheckOutDateFirst;

    //Customer Box
    @FindBy(id = "AdultCount")
    public WebElement mainPageCustomerBox;

    //Room Box
    @FindBy(id = "IDRoomType")
    public WebElement mainPageRoomBox;

    //Check Availability butonu
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement mainPageCheckAvailabiltyButton;

    //US001_TC0004 --> Welcome to Our Hotel  <-----------
    @FindBy(xpath = "//span[.='Welcome to Hotelmycamp']")    //h2[.='Welcome To Our Hotel'](//h2[@class='mb-4'])[1]
    public WebElement mainPageWelcomeToOurHotelText;

    //US001_TC0005 --> mainPage-->Our Rooms <----------------
    @FindBy(xpath = "//h2[.='Our Rooms']")
    public WebElement mainPageOurRoomsText;

    //US001_TC0006 --> mainPage--> Guests opinion Slide locate leri <------------

    @FindBy(xpath = "(//div[@class='row justify-content-center'])[2]")
    public WebElement mainPageSliderBolumu;

    @FindBy(xpath = "//div[@class='carousel-testimony owl-carousel ftco-owl owl-loaded owl-drag']")
    public List<WebElement> mainPageGuestsOpinionSlideIsDisplayed;

    @FindBy(tagName = "(//button)[6]")
    public WebElement mainPageGuestButton;

    //US001_TC0007 --> mainPage--> Recent Blog locatleri <-------------
    @FindBy(xpath = "//h2[text()='Recent Blog']")
    public WebElement mainPageRecentBlogText;

    //US001_TC0008 --> mainPage-->Instagram  <------------
    @FindBy(xpath = "//span[text()='Instagram']")
    public WebElement mainPageInstagramText;

    @FindBy(xpath = "//img[@class='mfp-img']")
    public WebElement mainPageInstagramFirstImg;

    @FindBy(xpath = "(//div[@class='icon d-flex justify-content-center'])[1]")
    public WebElement mainPageInstgramImg1;

    @FindBy(xpath = "(//div[@class='icon d-flex justify-content-center'])[2]")
    public WebElement mainPageInstgramImg2;

    @FindBy(xpath = "(//div[@class='icon d-flex justify-content-center'])[3]")
    public WebElement mainPageInstgramImg3;

    @FindBy(xpath = "(//div[@class='icon d-flex justify-content-center'])[4]")
    public WebElement mainPageInstgramImg4;

    @FindBy(xpath = "//button[@title='Next (Right arrow key)']")
    public WebElement mainPageInstagramNextButton;

    @FindBy(xpath = "//button[@title='Previous (Left arrow key)']")
    public WebElement mainPageInstagramPreviousButton;

    //US001_TC0009 --> MainPage--> Footer <-------------------------------
    @FindBy(xpath = "//footer[@class='ftco-footer ftco-bg-dark ftco-section']")
    public WebElement mainPageFooter;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[1]")
    public WebElement mainPageUsefulLinkBlog;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[2]")
    public WebElement mainPageUsefulLinkRooms;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[3]")
    public WebElement mainPageUsefulLinkAmentitiesTest;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[4]")
    public WebElement mainPageUsefulLinkGiftCard;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[5]")
    public WebElement mainPagePrivacyGiftCareer;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[6]")
    public WebElement mainPagePrivacyAboutUs;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[7]")
    public WebElement mainPagePrivacyContactUs;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[8]")
    public WebElement mainPagePrivacyServices;

    @FindBy(xpath = "(//span[@class='text'])[2]")
    public WebElement mainPageTelephoneLink;

    @FindBy(xpath = "(//span[@class='text'])[3]")
    public WebElement mainPageEmailLink;

    @FindBy(xpath = "//span[@class='icon-twitter']")
    public WebElement mainPageFooterTwitterIkon;

    @FindBy(xpath = "(//span[@class='icon-instagram'])[2]")
    public WebElement mainPageFooterInstagramIkon;

    @FindBy(xpath = "(//span[@class='icon-facebook'])[2]")
    public WebElement mainPageFooterFacebookIkon;

    @FindBy(id = "section-counter")
    public WebElement sectionCounterOtelBilgileriBolumu;

    public void mainPageUrl() {

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
    }

// US_02 locateler

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement managerTextboxKontrol;
    @FindBy(xpath = "//span[text()='Try again please']")
    public WebElement wrongLoginControl;

    public void pageDown() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                perform();

    }
}