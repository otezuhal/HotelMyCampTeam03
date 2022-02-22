package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import java.io.IOException;
import java.util.List;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.JSUtils;
import java.util.Set;

public class HotelListPage {

    public HotelListPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    MainPage mainPage = new MainPage();
    Actions actions = new Actions(Driver.getDriver());
    static String ilksayfahandle;
    static String windowHandleDegeri2;

    //Hotel Management, Hotel List, Add Hotel Search ve Clear sekmeleri

    //Main Page---->UserAdmin--->SystemManagement Link
    @FindBy(xpath="//span[.='System Management']")
    public WebElement systemManagementLink;

    //Main Page---->UserAdmin--->Hotel List Link
    @FindBy(xpath="(//a[@href=\"/admin/HotelAdmin\"])[1]")
    public WebElement hotelListLink;
//(//a[@href="/admin/HotelAdmin"])[1]
    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelListLinki;

    @FindBy(id = "Email")
    public WebElement emailHotelListKutusuWebElementi;

    @FindBy(id = "IDGroup")
    public WebElement idGroupKutusuWebElementi;

    //admin/HotelAdmin/Create
    @FindBy(xpath = "// div[@class='bootbox-body']")
    public WebElement basariliGirisYaziElementi;

    @FindBy(xpath = "//div[@class='bootbox modal fade bootbox-alert in']//div[@class='modal-body']")
    public WebElement addHotelAlertMesajiElementi;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[2]")
    public WebElement detailsHotelListButonu;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement IDHotelCodeKutusu;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement addHotelCodeKutusu;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement addHotelNameBoxKutusu;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement addHotelAddressBoxElementi;

    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement addHotelPhoneBoxKutusu;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement addHotelEmailBoxKutusu;

    @FindBy(xpath = "//*[@id=\"datatable_ajax\"]/thead/tr[2]/td[8]/div/button")
    public WebElement ListOfHotelsSearchButonu;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement managerDropDownButton;

    @FindBy(xpath = "//i[@class='icon-key']")
    public WebElement logOutButton;

    //******************  Main Page>>>Log In>>>Create Hotel Pages Webelements IN CORRECT WORDS *******************
    @FindBy(xpath = "(//label[@class='error'])[1]")
    public WebElement addHotelCodeKutusuIncorrect;

    @FindBy(xpath = "(//label[@class='error'])[2]")
    public WebElement addHotelNameBoxKutusuIncorrect;

    @FindBy(xpath = "(//label[@class='error'])[3]")
    public WebElement addHotelAddressBoxElementiIncorrect;

    @FindBy(xpath = "(//label[@class='error'])[4]")
    public WebElement addHotelPhoneBoxKutusuIncorrect;

    @FindBy(xpath = "(//label[@class='error'])[5]")
    public WebElement addHotelEmailBoxKutusuIncorrect;

    @FindBy(xpath = "//select[@id='lkpGroups']")
    public WebElement IDGroupCodeKutusuDropdawn;

    //Hotel Management, Hotel List, Add Hotel Search ve Clear sekmeleri
    //Main Page---->UserAdmin--->SystemManagement Link
    //Main Page---->UserAdmin--->Hotel Management Link
    @FindBy(xpath="//span[contains(text(),'Hotel Management')]")
    public WebElement hotelManagementLink;

    //Main Page---->UserAdmin--->Hotel List Link
    //@FindBy(xpath="(//a[@href='/admin/HotelAdmin'])[1]")
    ///public WebElement hotelListLink;

    @FindBy(xpath="(//li[@class='start open'])[1]")
    public WebElement systManagementMenusuAcik;

    @FindBy(xpath="(//li[@class='start'])[1]")
    public WebElement systManagementMenusuKapali;

    @FindBy(xpath="(//li[@class='start open'])[2]")
    public WebElement hotelManagementMenusuAciksa;

    @FindBy(xpath="(//li[@class='start'])[2]")
    public WebElement hotelManagementMenusuKapaliysa;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLinkpartialLinkTextIle;

    @FindBy(xpath ="//*[@id=\"datatable_ajax\"]/thead/tr[2]/td[8]/div/button")
    public WebElement searchLink;

    @FindBy(xpath="//*[text()='Clear']")
    public WebElement clearLink;

    @FindBy (xpath="//*[@id=\"datatable_ajax_wrapper\"]/div[3]/div[1]/div[1]/div/a[2]/i")
    public WebElement endpageNextButton;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement idHotelBox;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement codeBox;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement nameBox;

    @FindBy(xpath = "(//input[@type='text'])[5]")
    public WebElement addressBox;

    @FindBy(xpath = "(//input[@type='text'])[6]")
    public WebElement phoneBox;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    public WebElement emailBox;

    @FindBy(xpath="//select[@class='form-control form-filter input-sm']\n")
    public WebElement idGroupDropDown;

    @FindBy(xpath = "(//div[.='No records found to show'])[1]")
    public WebElement searchButonuTiklandiktanSonraMesajKutusu;

    @FindBy(xpath="(//input[@class='pagination-panel-input form-control input-mini input-inline input-sm'])[2]")
    public WebElement sayfaninAltindakiSayfaninYeriKutusu;

    @FindBy(xpath="//div[@class='page-container']//div[@class='row']//div[3]//div[1]//div[1]//div[1][1]//input[1]")
    public WebElement sayfaninAltindakiKutuMehmetEminBey;

    @FindBy(xpath="document.querySelector(\"body > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)\")")
    public WebElement sayfaninAltindakiKutuMehmetEminBey2;

    @FindBy(xpath="(//select[@class='form-control input-xsmall input-sm input-inline'])[2]")
    public WebElement goruntulenenRecordSayisiDropDown;

    @FindBy(xpath="(//i[@class='fa fa-angle-left'])[2]")
    public WebElement previousButton;

    @FindBy(xpath = "//a[@class='btn btn-circle btn-default']")
    public WebElement addHotelLinki;

    @FindBy ( xpath="//select[@id='IDGroup']")
    public WebElement addHotelDropdown;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement addHotelSaveButonu;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement addHotelokButonu;

    //admin/HotelAdmin/Create
    @FindBy(xpath = "// div[@class='bootbox-body']")
    public WebElement basariliGirisYaziElementi2;

    //sayfanin en altindaki view elementi
    @FindBy(xpath = "(//div[@class='dataTables_length'])[2]")
    public WebElement endofPageView;

    //span[@class='username username-hide-on-mobile']
    //@FindBy (xpath="//span[@class='username username-hide-on-mobile']")
    //public WebElement managerDropDownButton;

    @FindBy(xpath = "(//a[@class='btn btn-xs default'])[2]")
    public WebElement detailsButton;

    @FindBy(xpath ="//input[@name='Code']")
    public WebElement editOtelCodeBox;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement editOtelNameBox;

    @FindBy(xpath = "(//input[@class='form-control input-lg required'])[3]")
    public WebElement editOtelAddressBox;

    @FindBy(xpath = "(//input[@class='form-control input-lg required'])[4]")
    public WebElement editOtelPhoneBox;

    @FindBy(xpath = "(//input[@class='form-control input-lg required'])[5]")
    public WebElement editOtelEmailBox;


    //========= Edit Hotel elementleri================
    @FindBy(xpath = "//*[@id=\"Code\"]")
    public WebElement codeKutusuWebElementi;

    @FindBy(xpath = "//*[@id=\"Name\"]")
    public WebElement nameKutusuWebElementi;

    @FindBy(xpath = "//input[@placeholder='Address']")
    public WebElement addressKutusuWebElementi;

    @FindBy(id = "Phone")
    public WebElement phoneKutusuWebElementi;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailKutusuWebElementi;

    @FindBy(xpath = "//*[@id='Name']")
    public WebElement ddNameBox;

    @FindBy(xpath = "//input[@placeholder='Code']")
    public WebElement hasanCodeWebElementi;

    @FindBy(xpath = "(//button[@class='btn green'])[1]")
    public WebElement saveButton;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div")
    public WebElement hotelwasupdatedsuccessfullyKutusu;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement hotelUpdatedSuccessfullyOkLinki;

    @FindBy(id = "btnDelete")
    public WebElement deleteButonu;

    @FindBy(xpath = "//button[@data-bb-handler='confirm']")
    public WebElement deletedenSonraConfirm;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement deletedenSonraGelenMesaj;

    @FindBy(xpath = "//a[.='Log out']")
    public WebElement logOutButonuAnaSayfa;

    @FindBy(id = "navHome")
    public WebElement anaSayfaHome;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement editorSayfasiManagerLinki;

    @FindBy(xpath = "//i[@class='icon-key']")
    public WebElement editorSayfasiLogOutLinki;

    public WebElement detailsButonlariDinamik (int detailsButton) throws IOException {
        String dinamikXpath = "(//a[@class='btn btn-xs default'])[" + detailsButton + "]";

        WebElement detailsButon = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        String ilkSayfaHandleDegeri = Driver.getDriver().getWindowHandle();
        detailsButon.click();
        ReusableMethods.getScreenshot("US05/yeni tab acildi");
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().window(ilkSayfaHandleDegeri);
        ReusableMethods.waitFor(2);
        return detailsButon;
    }

    public void editHotelSayfasinaGecis() {
        mainPage.managerHotelMyCampGiris();
        ReusableMethods.waitFor(3);
        hotelManagementLink.click();
        hotelListLink.click();
        ReusableMethods.waitFor(2);
        ilksayfahandle = Driver.getDriver().getWindowHandle();
        detailsButton.click();

        Set<String> handleDegerleriSeti = Driver.getDriver().getWindowHandles();
        windowHandleDegeri2 = "";
        for (String each : handleDegerleriSeti
        ) {
            if (!each.equals(ilksayfahandle)) {
                windowHandleDegeri2 = each;
            }
        }
        Driver.getDriver().switchTo().window(windowHandleDegeri2);
    }

    public void kutulariClear() {
        hasanCodeWebElementi.clear();
        nameKutusuWebElementi.clear();
        addressKutusuWebElementi.clear();
        phoneKutusuWebElementi.clear();
        emailKutusuWebElementi.clear();
    }


    public void kutuyaRandomSayiYolla(WebElement Kutu) {

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(1);
        String randomSayi = randomSayiUret(2500);
        actions.click(hasanCodeWebElementi).sendKeys(randomSayi).perform();
        randomSayi = randomSayiUret(3500);
        actions.click(nameKutusuWebElementi).sendKeys(randomSayi).perform();
        randomSayi = randomSayiUret(3500);
        actions.click(addressKutusuWebElementi).sendKeys(randomSayi).perform();
        randomSayi = randomSayiUret(6500);
        actions.click(phoneKutusuWebElementi).sendKeys(randomSayi).perform();
        randomSayi = randomSayiUret(7500);
        actions.click(emailKutusuWebElementi).sendKeys(randomSayi).perform();
        ReusableMethods.waitFor(1);
    }

    public void kutuyaRandomKarakterYolla(WebElement Kutu) {

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(1);
        actions.click(hasanCodeWebElementi).sendKeys(Faker.instance().lorem().characters(2, 20)).perform();
        actions.click(nameKutusuWebElementi).sendKeys(Faker.instance().lorem().characters(2, 30)).perform();
        actions.click(addressKutusuWebElementi).sendKeys(Faker.instance().lorem().characters(2, 20)).perform();
        actions.click(phoneKutusuWebElementi).sendKeys(Faker.instance().lorem().characters(2, 20)).perform();
        actions.click(emailKutusuWebElementi).sendKeys(Faker.instance().lorem().characters(2, 10)).perform();
    }

    public void kutularinAslinaUygunDoldurulmasi(WebElement Kutu) {

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(1);
        String randomSayi = randomSayiUret(10000);
        actions.click(hasanCodeWebElementi).sendKeys(randomSayi).perform();
        actions.click(nameKutusuWebElementi).sendKeys(Faker.instance().name().fullName()).perform();
        actions.click(addressKutusuWebElementi).sendKeys(Faker.instance().address().fullAddress()).perform();
        actions.click(phoneKutusuWebElementi).sendKeys(Faker.instance().phoneNumber().phoneNumber()).perform();
        actions.click(emailKutusuWebElementi).sendKeys(Faker.instance().internet().emailAddress()).perform();
    }

    public String harfUret(int uzunluk) {
        String kelime = Faker.instance().lorem().fixedString(uzunluk);

        return kelime;
    }

    public void deleteHotel(String testinAdi) throws InterruptedException, IOException {
        JSUtils.scrollIntoVIewJS(deleteButonu);
        deleteButonu.click();
        deletedenSonraConfirm.click();
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(500);
        ReusableMethods.getScreenshot(testinAdi + "Otel sildikten sonra ekran goruntusu");

    }


    public static String randomSayiUret(int maxSayi) {
        int uretilenSayi = (int) (Math.random() * maxSayi + 1);


        return ""+uretilenSayi;
    }



}