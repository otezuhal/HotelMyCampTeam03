package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class HotelRoomsPage {

    public HotelRoomsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    //  -->hotelManagement-->HotelRooms--> List Of Hotel Rooms

    @FindBy(xpath = "//a[@id='menuHotels']")
    public WebElement hotelManagementLinki;


    @FindBy(xpath = "(//i[@class='icon-calendar'])[3]")
    public WebElement hotelRoomsLinki;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement listOfHotelRoomsYazisi;


    //US_0007 Loceted

    @FindBy(xpath = "(//tr)[3]//td")
    public List<WebElement> listedekiILkHotelBilgileriListesi;

    @FindBy(xpath = "//input[@name='IDHotelRoom']")
    public WebElement hotelRoomsLinkiListeIdBox;

    @FindBy(xpath = "//select[@id='lkpHotels']")
    public WebElement hotelRoomListIdHotelBox;

    @FindBy(xpath = "//input[@name='Code']")
    public WebElement hotelRoomListCodeBox;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement hotelRoomListNameBox;

    @FindBy(xpath = "//input[@name='Location']")
    public WebElement hotelRoomListLocationBox;

    @FindBy(xpath = "//input[@name='Price']")
    public WebElement hotelRoomListPriceBox;

    @FindBy(xpath = "//select[@id='lkpGroupRoomTypes']")
    public WebElement hotelRoomsListIdGrouoTypeBox;

    @FindBy(xpath = "//select[@name='IsAvailable']")
    public WebElement hotelRoomListIsAvaibleBox;

    @FindBy(xpath = "//button[@class='btn btn-sm red filter-cancel']")
    public WebElement hotelRoomListClearButton;

    @FindBy(xpath = "(//a[@class='btn btn-xs default'])[1]")
    public WebElement hotelRoomListDetailButton;

    @FindBy(xpath = "//select[@name='IsAvailable']")
    public WebElement hotelRoomListSearchButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement hotelRoomListChecked;


    public void listeEkranindaHotelRoomArama() {

        hotelRoomsLinkiListeIdBox.sendKeys(listedekiILkHotelBilgileriListesi.get(0).getText());
        hotelRoomListIdHotelBox.sendKeys(listedekiILkHotelBilgileriListesi.get(1).getText());
        hotelRoomListCodeBox.sendKeys(listedekiILkHotelBilgileriListesi.get(2).getText());
        hotelRoomListNameBox.sendKeys(listedekiILkHotelBilgileriListesi.get(3).getText());
        hotelRoomListLocationBox.sendKeys(listedekiILkHotelBilgileriListesi.get(4).getText());
        hotelRoomListPriceBox.sendKeys(listedekiILkHotelBilgileriListesi.get(5).getText());
        hotelRoomsListIdGrouoTypeBox.sendKeys(listedekiILkHotelBilgileriListesi.get(6).getText());
        Select select = new Select(hotelRoomListIsAvaibleBox);
        if (hotelRoomListChecked.isSelected()) {
            select.selectByVisibleText("True");
        } else {
            select.selectByVisibleText("False");
        }
    }

        //  -->hotelManagement-->HotelRooms--> List Of Hotel Rooms
        // @FindBy(xpath = "//a[@id='menuHotels']")
        // public WebElement hotelManagementLinki;

        // @FindBy(xpath = "(//i[@class='icon-calendar'])[3]")
        // public WebElement hotelRoomsLinki;

        @FindBy(xpath = "//div[@class='caption']")
        public WebElement listOfUsersYazisi;

        @FindBy(xpath = "//div[@class='caption']")
        public WebElement listOfHotelYazisi;

        @FindBy(xpath = "//span[@class='hidden-480']")
        public WebElement addHotelRoomButtonu;

        @FindBy(xpath = "//div[@class='caption']")
        public WebElement createHotelRoomYazisi;

        @FindBy(xpath = "//select[@id='IDHotel']")
        public WebElement iDHotelDropBox;

        @FindBy(xpath = "//option[text()='Select Hotel']")
        public List<WebElement> selectHotelListesi;


    }

