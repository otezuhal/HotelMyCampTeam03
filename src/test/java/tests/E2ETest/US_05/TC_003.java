package tests.E2ETest.US_05;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelListPage;
import pages.MainPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;

//1-System management linkinin erisilebilir ve tiklanabilir oldugu test edilir
//2-Hotel management linkinin erisilebilir ve tiklanabilir oldugu test edilir
//3-Hotel list linkinin erisilebilir ve tiklanabilir oldugu ve tiklandiginda
//4-mevcut butun otelleri gorebilmek icin sayfanin en altina gidilmesi test edilir
//5-page sekmesinin yanindaki next ve previous butonlarinin erisilebilir olmasi
//6-page sekmesinin yanindaki next ve previous butonlarinin fonksiyonel olmasi
//7-view yazisinin gozukmesi
//8-Add Hotel, search ve clear  butonlarinin erisilebilir ve fonksiyonel olmasi test edilir
public class TC_003 extends TestBaseRapor {
    //System Management, Hotel Management, Hotel List, Add Hotel Search ve Clear sekmeleri
    // tiklanabilir olmali
    MainPage mainPage;
    Actions actions;

    HotelListPage hotelListPage;
    @Test(priority=1 )
    public void displayedAndEnabledTest() {
        hotelListPage=new HotelListPage();
        actions=new Actions(Driver.getDriver());
        mainPage=new MainPage();

        extentTest=extentReports.createTest("Yonetici girisinden sonra linklerin displayedAndEnabled testi","Yonetici girisinden System Management, Hotel Management, Hotel List, Add Hotel Search ve Clear sekmelerinin gorunur ve tiklanabilir olmalari test edilir");
        extentTest.info("www.hotelmycamp.com sayfasina gidildi ve gecerli datalarla giris yapilarak linklerin testine baslandi");
        mainPage.managerHotelMyCampGiris();
        //1-System management linkinin erisilebilir ve tiklanabilir oldugu test edilir
        String systemManagementLinkStr=hotelListPage.systemManagementLink.getText();
        extentTest.info("System Management Linkinin gozukmesi ve erisilmesi test ediliyor");
        Assert.assertTrue(hotelListPage.systemManagementLink.isDisplayed(),"System Management Linki gozukmuyor");
        Assert.assertTrue(hotelListPage.systemManagementLink.isEnabled(),"System Management Linkine erisilemiyor");
        System.out.println("systemManagementLink = " + systemManagementLinkStr);
        extentTest.info("System Management Linkinin gozukmesi ve erisilmesi test ediliyor");
        extentTest.pass("System Management Linkinin gozuktugu ve tiklanabildigi test edildi");
//2-Hotel management linkinin erisilebilir ve tiklanabilir oldugu test edilir
        extentTest.info("Hotel Management Linkinin gozukmesi ve erisilmesi test ediliyor");
        String hotelManagementLinkStr=hotelListPage.hotelManagementLink.getText();
        ReusableMethods.waitForVisibility(hotelListPage.hotelManagementLink,20);
        Assert.assertTrue(hotelListPage.hotelManagementLink.isDisplayed(),"Hotel Management Linki gozukmuyor");
        Assert.assertTrue(hotelListPage.hotelManagementLink.isEnabled(),"Hotel Management Linkine erisilemiyor");
        System.out.println("hotelManagementLinkStr = " + hotelManagementLinkStr);
        extentTest.pass("Hotel Management Linkinin gozuktugu ve tiklanabildigi test edildi");
        //3-Hotel list linkinin erisilebilir ve tiklanabilir oldugu test edilir
hotelListPage.hotelManagementLink.click();
ReusableMethods.waitFor(2);
        //Hotel List Linki
        String hotelListLink=hotelListPage.hotelListLink.getText();
        System.out.println("hotelListLink = " + hotelListLink);
        ReusableMethods.waitForVisibility(hotelListPage.hotelListLink,20);
        Assert.assertTrue(hotelListPage.hotelListLink.isDisplayed(),"Hotel List Linki gozukmuyor");
        Assert.assertTrue(hotelListPage.hotelListLink.isEnabled(),"Hotel List Linkine erisilemiyor");
        extentTest.pass("Hotel List Linkinin gozuktugu ve tiklanabildigi test edildi");
        hotelListPage.hotelListLink.click();
//Add Hotel Linki
        String addHotelLinkiStr=hotelListPage.addHotelLinki.getText();
        System.out.println("addHotelLinkiStr = " + addHotelLinkiStr);
        Assert.assertTrue(hotelListPage.addHotelLinki.isDisplayed(),"Add Hotel Linki gozukmuyor");
        Assert.assertTrue(hotelListPage.addHotelLinki.isEnabled(),"Add Hotel Linkine erisilemiyor");
        extentTest.pass("Add Hotel Linkinin gozuktugu ve tiklanabildigi test edildi");
//8-search ve clear  butonlarinin erisilebilir olmasi test edilir
        //Search  button
        String searchButtonStr=hotelListPage.searchLink.getText();
        System.out.println("searchButtonStr = " + searchButtonStr);
        Assert.assertTrue(hotelListPage.searchLink.isDisplayed(),"Search Linki gozukmuyor");
        Assert.assertTrue(hotelListPage.searchLink.isEnabled(),"Search Linkine erisilemiyor");
        extentTest.pass("Search Linkinin gozuktugu ve tiklanabildigi test edildi");
        //Clear button
        String clearButtonStr=hotelListPage.clearLink.getText();
        System.out.println("clearButtonStr = " + clearButtonStr);
        Assert.assertTrue(hotelListPage.clearLink.isDisplayed(),"Clear Linki gozukmuyor");
        Assert.assertTrue(hotelListPage.clearLink.isEnabled(),"Clear Linkine erisilemiyor");
        extentTest.pass("Clear Linkinin gozuktugu ve tiklanabildigi test edildi");
                actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();
       // Driver.closeDriver();

        
        
    }
    @Test(priority=2 )
    public void endofPageButtonsVisibility (){
extentTest=extentReports.createTest("Yonetici girisinden sonra sayfanin en altinda bulunan butonlarin testi","Yonetici girisinden sayfanin en altinda bulunan view yazisinin gozukmesi ve next ve previous butonlarina erisilmesi ve gozukmeleri test edilir");
extentTest.info("www.hotelmycamp.com sayfasina gidildi ve gecerli datalarla giris yapilarak sayfanin en altina gidildi");
        mainPage.managerHotelMyCampGiris();
        ReusableMethods.waitFor(2);
        //4-mevcut butun otelleri gorebilmek icin sayfanin en altina gidilmesi test edilir

        JSUtils.scrollIntoVIewJS(hotelListPage.endpageNextButton);
        ReusableMethods.waitFor(3);
        //5-page sekmesinin yanindaki next ve previous butonlarinin erisilebilir olmasi
        Assert.assertTrue(hotelListPage.endpageNextButton.isEnabled(),"Sayfanin altindaki next Butonuna erisilemiyor");
        extentTest.pass("Sayfanin altindaki next Butonuna erisilebildigi test edildi");
        hotelListPage.endpageNextButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(hotelListPage.previousButton.isEnabled(),"sayfadaki previous Buttona erisilemiyor");
        extentTest.pass("Sayfanin altindaki previous Butonuna erisilebildigi test edildi");
//7-view yazisinin gozukmesi
        //view yazisi
        JSUtils.scrollIntoVIewJS(hotelListPage.endofPageView);
        ReusableMethods.waitForVisibility(hotelListPage.endofPageView,10);
        String viewYazisi=hotelListPage.endofPageView.getText();
        System.out.println("viewYazisi = " + viewYazisi);
        Assert.assertTrue(viewYazisi.contains("View"),"view yazisi gozukmuyor");
        extentTest.pass("Sayfanin altindaki view yazisinin gozuktugu test edildi");
        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();
//Driver.closeDriver();
    }

    @Test(priority=3 )
    public void managementLinkleriFonksiyonelTesti () throws IOException {
        extentTest=extentReports.createTest("Yonetici girisinden sonra linklerin fonksiyonel olmasi testi","Yonetici girisinden System Management, Hotel Management, Hotel List, Add Hotel Search ve Clear linklerinin fonksiyonel olmasi olmalari test edilir");
        extentTest.info("www.hotelmycamp.com sayfasina gidildi ve gecerli datalarla giris yapilarak linklerin testine baslandi");

mainPage.managerHotelMyCampGiris();

        //1-System management linki  tiklanmissa "start open" WebElement'i locate edilebiliyor
        Assert.assertTrue(hotelListPage.systManagementMenusuAcik.isDisplayed(),"System Management linki tiklanabiliyor");

        ReusableMethods.waitFor(1);
       ReusableMethods.getScreenshot("US05/System Management Menusu Acik");
        hotelListPage.systemManagementLink.click();
Assert.assertTrue(hotelListPage.systManagementMenusuKapali.isDisplayed(),"System Management Menusu kapanmadi");
        extentTest.pass("Sayfadaki System Management linkinin fonksiyonel oldugu test edildi");
ReusableMethods.waitFor(1);
ReusableMethods.getScreenshot("US05/System Management Menusu Kapali");

        hotelListPage.systemManagementLink.click();
        hotelListPage.hotelManagementLink.click();
        Assert.assertTrue(hotelListPage.hotelManagementMenusuAciksa.isDisplayed(),"Hotel Management Menusu acilmadi");
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("US05/Hotel Management Menusu acik");

        hotelListPage.hotelManagementLink.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(hotelListPage.systManagementMenusuKapali.isDisplayed(),"Hotel Management Menusu hala acik");
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("US05/Hotel Management Menusu Kapali");
        extentTest.pass("Sayfadaki Hotel Management linkinin fonksiyonel oldugu test edildi");
        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();

     //   Driver.closeDriver();
    }

    @Test(priority=4 )
    public void prevNextveDropdownElementlerininFonksiyonelOlmasiTesti () throws IOException {
        extentTest=extentReports.createTest("Yonetici girisinden sonra linklerin fonksiyonel olmasi testi","Yonetici girisinden sonra sayfanin en altinda bulunan next ve previous butonlari ile dropdown elementlerinin fonksiyonel olmasi test edilir");
        extentTest.info("www.hotelmycamp.com sayfasina gidildi ve gecerli datalarla giris yapilarak linklerin testine baslandi");
        ReusableMethods.waitFor(2);
        mainPage.managerHotelMyCampGiris();

        hotelListPage.hotelManagementLink.click();

//6-page sekmesinin yanindaki next ve previous butonlarinin fonksiyonel olmasi

        String nextebasmadansayfa=hotelListPage.sayfaninAltindakiSayfaninYeriKutusu.getText();
         ReusableMethods.getScreenshot("US05/sayfanin altindaki next butonuna basilmadan once");
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(hotelListPage.endpageNextButton);

        actions.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitFor(1);
           ReusableMethods.getScreenshot("US05/next butonu tiklandi ve sonraki sayfaya gecildi");
        extentTest.pass("Sayfanin en altinda bulunan Next butonunun fonksiyonel oldugu test edildi");
        actions.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN);
        JSUtils.clickElementByJS(hotelListPage.previousButton);
        ReusableMethods.waitFor(1);
         ReusableMethods.getScreenshot("US05/previous butonuna basildi ve onceki sayfaya gecildi");
        extentTest.pass("Sayfanin en altinda bulunan previous butonunun fonksiyonel oldugu test edildi");
        ReusableMethods.waitFor(1);

        Select select=new Select(hotelListPage.goruntulenenRecordSayisiDropDown);
        List<WebElement> optionListDropDown=select.getOptions();
        for (WebElement each: optionListDropDown
        ) {
            System.out.println("record sayisi : " + each.getText());
        }
        for (int i = 0; i <6 ; i++) {
            JSUtils.scrollIntoVIewJS(hotelListPage.goruntulenenRecordSayisiDropDown);
            ReusableMethods.waitFor(1);
            select.selectByIndex(i);
            ReusableMethods.waitFor(2);
            ReusableMethods.getScreenshot("US05/en altta dropdown menusunde "+(i+1)+" nci record secildi");
        }
        extentTest.pass("Sayfa en altinda bulunan dropdown elementinin fonksiyonel oldugu test edildi");
        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();

      //   Driver.closeDriver();
    }


    @Test(priority=5 )
    public void addHotelbutonununFonksiyonelOlmasiTesti () throws IOException {
        extentTest=extentReports.createTest("Yonetici girisinden sonra add hotel butonunun fonksiyonel olmasi testi","Yonetici girisinden sonra add hotel butonunun fonksiyonel olmasi test edilir");
        extentTest.info("www.hotelmycamp.com sayfasina gidildi ve gecerli datalarla giris yapilarak linklerin testine baslandi");
        ReusableMethods.waitFor(2);
        //8-Add Hotel butonunun fonksiyonel olmasi test edilir
        mainPage.managerHotelMyCampGiris();

        hotelListPage.hotelManagementLink.click();
        hotelListPage.hotelListLink.click();
hotelListPage.addHotelLinki.click();
String actualTitle=Driver.getDriver().getTitle();
String expectedTitle="Admin - List Of Hotels";
ReusableMethods.getScreenshot("US05/Add hotel linkine tiklandi ve yeni sayfaya gecildi");
Assert.assertEquals(actualTitle,expectedTitle);

Driver.getDriver().navigate().back();
ReusableMethods.getScreenshot("US05/onceki sayfaya donuldu");

        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        extentTest.pass("Sayfadaki ADD HOTEL butonunun fonksiyonel oldugu test edildi");
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();
      //   Driver.closeDriver();
    }

    @Test(priority=6 )
    public void searchveClearButonlarininFonksiyonelOlmasiTesti () throws IOException {
        extentTest=extentReports.createTest("Yonetici girisinden sonra Search ve Clear butonlarinin fonksiyonel olmasi testi","Yonetici girisinden sonra Search ve Clear butonlarinin fonksiyonel olmasi test edilir");
        extentTest.info("www.hotelmycamp.com sayfasina gidildi ve gecerli datalarla giris yapilarak linklerin testine baslandi");
        ReusableMethods.waitFor(2);
        //8-search ve clear  butonlarinin fonksiyonel olmasi test edilir
        mainPage.managerHotelMyCampGiris();
        ReusableMethods.waitFor(3);
        hotelListPage.hotelManagementLink.click();
       hotelListPage.hotelListLink.click();
       ReusableMethods.waitFor(2);
hotelListPage.idHotelBox.sendKeys("1234");
hotelListPage.codeBox.sendKeys("79520-8128");
hotelListPage.nameBox.sendKeys(Faker.instance().lorem().characters(5,25));
        hotelListPage.addressBox.sendKeys(Faker.instance().address().fullAddress());
hotelListPage.phoneBox.sendKeys(Faker.instance().phoneNumber().cellPhone());
hotelListPage.emailBox.sendKeys(Faker.instance().internet().emailAddress());
        extentTest.pass("Sayfada add hotel sayfasindaki bos kutulara data gonderilebildigi test edildi");
        Select select=new Select(hotelListPage.idGroupDropDown);

select.selectByIndex(2);
ReusableMethods.waitFor(2);
  hotelListPage.searchLink.click();
  String searchButonMessage=hotelListPage.searchButonuTiklandiktanSonraMesajKutusu.getText();
        System.out.println("searchButonMessage = " + searchButonMessage);
        String expectedsearchButtonClickMessage="No records found to show";
        String actualsearchButtonClickMessage=hotelListPage.searchButonuTiklandiktanSonraMesajKutusu.getText();
        ReusableMethods.getScreenshot("US05/Search Butonu tiklandiktan sonra");
        Assert.assertEquals(actualsearchButtonClickMessage,expectedsearchButtonClickMessage,"search butonu tiklanmadi");
        extentTest.pass("Sayfadaki Search butonunun fonksiyonel oldugu test edildi");

 String nameBoxStr=hotelListPage.nameBox.getAttribute("value");
        System.out.println("nameBoxStr = " + nameBoxStr);
    String emailBoxStr=hotelListPage.emailBox.getAttribute("value");
        System.out.println("emailBoxStr = " + emailBoxStr);
        String phoneBoxSTr=hotelListPage.phoneBox.getAttribute("value");
        System.out.println("phoneBoxSTr = " + phoneBoxSTr);
        Assert.assertFalse(emailBoxStr.equals(""),"email bos degil");
        ReusableMethods.getScreenshot("US05/clear butonuna basmadan once");
      hotelListPage.clearLink.click();
      String emailBoxStrsildiktensonra=hotelListPage.emailBox.getAttribute("value");
      System.out.println("emailBoxStrsildiktensonra = " + emailBoxStrsildiktensonra);
      Assert.assertTrue(emailBoxStrsildiktensonra.equals(""),"email box hala dolu ?");
      ReusableMethods.waitFor(2);
      ReusableMethods.getScreenshot("US05/clear butonuna bastiktan sonra");
        extentTest.pass("Sayfadaki Clear butonunun fonksiyonel oldugu test edildi");
        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();

    }


}
