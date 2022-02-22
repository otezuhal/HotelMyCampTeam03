package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReusableMethods;

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
    public WebElement listOfUsersYazisi;
    @FindBy(xpath = "//div[@class='caption']")
    public WebElement listOfHotelYazisi;
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoomButtonu;
    @FindBy(xpath = "//div[@class='caption']")
    public WebElement createHotelRoomYazisi;
    @FindBy(xpath = "//select[@id='IDHotel']")
    public WebElement iDHotelDropBox;
    @FindBy ( xpath="//textarea[@dir='ltr']")
    public WebElement descriptionElementi;
    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement addHotelSaveButonu;
    @FindBy(xpath = "//input[@name='Code']")
    public WebElement hotelRoomListCodeBox;
    @FindBy(xpath = "//input[@name='Price']")
    public WebElement hotelRoomListPriceBox;
    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement managerLink;
    @FindBy(xpath = "//i[@class='icon-key']")
    public WebElement logOutButton;
    @FindBy(xpath = "//a[@href='#']")
    public List<WebElement> priceDragandDropListesi;//2 den başla
    @FindBy(xpath = "//select[@id='IDGroupRoomType']")
    public WebElement roomTypeElementi;
    @FindBy(xpath = "//input[@id='IsAvailable']")
    public WebElement approvedElementi;
    @FindBy (xpath = "//div[text()='HotelRoom was inserted successfully']")
    //div[@class='bootbox-body']
    public WebElement basariliSaveYazisi;
    @FindBy (xpath = "(//button[@type='button'])[6]")
    public WebElement okButton;



    @FindBy(xpath = "//div[@class='caption']")
    public WebElement listOfHotelRoomsYazisi;




    //US_0007 Loceted

    //  -->hotelManagement-->HotelRooms--> List Of Hotel Rooms


    @FindBy(xpath = "//select[@id='lkpGroupRoomTypes']")
    public WebElement hotelRoomsListIdGroupTypeBox;

    @FindBy(xpath = "(//a[@class='btn btn-xs default'])[1]")
    public WebElement hotelRoomListDetailButton;

    @FindBy(xpath = "//*[@id=\"datatable_ajax\"]/thead/tr[2]/td[9]/div/button")
    public WebElement hotelRoomListSearchButton;



    //  -->hotelManagement-->HotelRooms--> List Of Hotel Rooms-->(Edit Hotelroom)Details

    @FindBy(xpath = "//select[@id='IDHotel']")
    public WebElement hotelRoomsDetailsHotelbox;

    @FindBy(xpath = "//select[@name='IDHotel']//option")
    public  List<WebElement> hotelRoomsDetailsHotelboxHotelsList;

    @FindBy(xpath = "//button[@id='btnDelete']")
    public  WebElement hotelRoomsDetailsDeleteButton;

    @FindBy(xpath = "//button[text()='OK']")
    public  WebElement hotelRoomsDetailsDeleteButtondanSonrakiOkButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement basariliSilindiTestYazisi;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement hotelRoomsDetailsCodeBox;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement hotelRoomsDetailsPriceBox;

    @FindBy(id = "IDGroupRoomType")
    public WebElement hotelRoomsDetailsRoomType;

    @FindBy(xpath = "(//button)[4]")
    public WebElement hotelRoomsDetailsSaveButton;

    @FindBy(className = "bootbox-body")
    public  WebElement hotelRoomsDetailsSuccefullWort;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement hotelRommsDetailsOkButton;



    public void dataUpdate() {
        Select select = new Select(hotelRoomsDetailsHotelbox);
        Faker faker = new Faker();
        select.selectByIndex(faker.random().nextInt(0, hotelRoomsDetailsHotelboxHotelsList.size() - 1));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys("555").sendKeys(Keys.TAB)
                .sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).sendKeys(faker.letterify("Deneme"))
                .sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        for (int i = 1; i <= 6; i++) {
            WebElement priceButtons = Driver.getDriver().findElement(By.xpath("(//a[@class='label label-success'])[" + i + "]"));
            actions.dragAndDrop(priceButtons, hotelRoomsDetailsPriceBox).build().perform();

        }

        Select select1 = new Select(hotelRoomsDetailsRoomType);
        select1.selectByIndex(faker.random().nextInt(0, 8));
        actions.sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB)
                .click().perform();


    }

}


