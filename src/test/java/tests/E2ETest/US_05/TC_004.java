package tests.E2ETest.US_05;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HotelListPage;
import pages.MainPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class TC_004 extends TestBaseRapor {
    //Details linki tiklandiginda bilgiler aslina uygun olarak girilebilmeli
    // ve save butonuna basildiginda kaydedilebilir olmali

    //1-details butonu tiklandiginda https://www.hotelmycamp.com/admin/HotelAdmin/Edit?Id=1069 urlsinin
    // yeni tab olarak acildigi
    //2-https://www.hotelmycamp.com/admin/HotelAdmin/Edit?Id=1069 sekmesinde bulunan
    //3-butun kutularin aslina uygun olarak duzenlenebildigi test edilir
    //4-silme ve duzenleme isleminden sonra save butonuna basilabildigi ve bilgilerin kaydedildigi test edilir
    //5-ayni tab'da delete butonunun gorunur ve fonksiyonel oldugu test edilir
    MainPage mainPage;
    Actions actions;
    HotelListPage hotelListPage;


    @Test (priority = 1)
    public void detailsButonuTiklandigindaYeniTabAcilmasi () throws IOException {
        hotelListPage=new HotelListPage();
        actions=new Actions(Driver.getDriver());
        mainPage=new MainPage();
        //1-details butonu tiklandiginda https://www.hotelmycamp.com/admin/HotelAdmin/Edit?Id=1069 urlsinin
        // yeni tab olarak acildigi
        extentTest=extentReports.createTest("Manager sayfasinda Details butonunun fonksiyonel olmasi testi","Manager sayfasinda Details butonunun fonksiyonel olmasi test edilir");
        extentTest.info("www.hotelmycamp.com sayfasina gidildi ve gecerli datalarla giris yapilarak details butonlarinin testine baslandi");

        mainPage.managerHotelMyCampGiris();
        ReusableMethods.waitFor(3);
        hotelListPage.hotelManagementLink.click();
        hotelListPage.hotelListLink.click();
        ReusableMethods.waitFor(2);
        String ilkSayfaHandleDegeri=Driver.getDriver().getWindowHandle();

        for (int i = 1; i <2; i++) {
            hotelListPage.detailsButonlariDinamik(i);
            ReusableMethods.waitFor(1);
            ReusableMethods.getScreenshot("US05/Detail butonu tiklandi");
        }
        extentTest.pass("Details butonunun gozuktugu ve tiklanabildigi test edildi");

        Set<String> handleDegerleriSeti= Driver.getDriver().getWindowHandles();
        String windowHandleDegeri2="";
        for (String each:handleDegerleriSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                windowHandleDegeri2=each;
            }
        }

        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();
        Driver.getDriver().switchTo().window(windowHandleDegeri2);
        actions.moveToElement(hotelListPage.editorSayfasiManagerLinki).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.editorSayfasiLogOutLinki.click();
    }


    @Test(priority = 2)
    public void sadeceSayiDatasiYollayarakHotelUpdate () throws IOException, InterruptedException {
        //2-https://www.hotelmycamp.com/admin/HotelAdmin/Edit?Id=1069 sekmesinde bulunan
        ///3-butun kutularin yanlis datalarla duzenlenebildigi test edilir
        extentTest=extentReports.createTest("Edit Hotel sayfasindaki bos kutularin hepsine sayi datasi girilebildigi testi","Edit Hotel sayfasindaki bos kutularin hepsine sayi datasi girilebildigi test edilir");
        extentTest.info("Edit Hotel Tabina gecilerek sadece sayi datalari giris yapilarak bos kutularin testine baslandi");
        mainPage.managerHotelMyCampGiris();
        String ilkSayfaHandleDegeri= Driver.getDriver().getWindowHandle();
        ReusableMethods.waitFor(3);
        hotelListPage.hotelManagementLink.click();
        hotelListPage.hotelListLink.click();
        ReusableMethods.waitFor(2);

        hotelListPage.detailsButton.click();

        Set<String> handleDegerleriSeti= Driver.getDriver().getWindowHandles();
        String windowHandleDegeri2="";
        for (String each:handleDegerleriSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                windowHandleDegeri2=each;
            }
        }
        Driver.getDriver().switchTo().window(windowHandleDegeri2);
        hotelListPage.kutulariClear();
        hotelListPage.kutuyaRandomSayiYolla(hotelListPage.hasanCodeWebElementi);
        Select select=new Select(hotelListPage.idGroupKutusuWebElementi);
        List<WebElement> optionListDropDown=select.getOptions();
        JSUtils.scrollIntoVIewJS(hotelListPage.idGroupKutusuWebElementi);
        for (int i = 1; i <2 ; i++) {
            select.selectByIndex(i);
        }
        hotelListPage.saveButton.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("US05/Sayi gonderildi kaydedildi ve Hotel Update Yazisi Ekran goruntusu alindi");
        extentTest.pass("Sadece sayi datasi girildigi halde hotel kaydedilebildigi test edildi");
        hotelListPage.hotelUpdatedSuccessfullyOkLinki.click();
        hotelListPage.deleteHotel("sadeceSayiDatasiYollayarakHotelUpdate");
        extentTest.pass("Sadece sayi datasi girilerek kaydedilen hotelin silinebildigi test edildi");
        Driver.getDriver().switchTo().window(ilkSayfaHandleDegeri);
        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();


    }

    @Test (priority = 3)
    public void karisikDataYollayarakHotelUpdate () throws IOException, InterruptedException {
        //2-https://www.hotelmycamp.com/admin/HotelAdmin/Edit?Id=1069 sekmesinde bulunan
        //3-butun kutularin yanlis datalarla duzenlenebildigi test edilir
        //4-silme ve duzenleme isleminden sonra save butonuna basilabildigi ve bilgilerin kaydedildigi test edilir
        extentTest=extentReports.createTest("Edit Hotel sayfasindaki bos kutularin hepsine sayi-harf-ozel karakter datalarinin girilebildigi testi","Edit Hotel sayfasindaki bos kutularin hepsine sayi-harf-ozel karakter datalarinin girilebildigi test edilir");
        extentTest.info("Edit Hotel Tabina gecilerek sadece karisik datalar giris yapilarak bos kutularin testine baslandi");
        mainPage.managerHotelMyCampGiris();
        String ilkSayfaHandleDegeri= Driver.getDriver().getWindowHandle();
        ReusableMethods.waitFor(3);
        hotelListPage.hotelManagementLink.click();
        hotelListPage.hotelListLink.click();
        ReusableMethods.waitFor(2);

        hotelListPage.detailsButton.click();

        Set<String> handleDegerleriSeti= Driver.getDriver().getWindowHandles();
        String windowHandleDegeri2="";
        for (String each:handleDegerleriSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                windowHandleDegeri2=each;
            }
        }
        Driver.getDriver().switchTo().window(windowHandleDegeri2);
        hotelListPage.kutulariClear();
        hotelListPage.kutuyaRandomKarakterYolla(hotelListPage.hasanCodeWebElementi);
        Select select=new Select(hotelListPage.idGroupKutusuWebElementi);
        List<WebElement> optionListDropDown=select.getOptions();
        JSUtils.scrollIntoVIewJS(hotelListPage.idGroupKutusuWebElementi);
        for (int i = 1; i <3 ; i++) {
            select.selectByIndex(i);
        }
        hotelListPage.saveButton.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("US05/Karisik data gonderildi kaydedildi ve Hotel Update Yazisi Ekran goruntusu alindi");
        extentTest.pass("Kutulara karisik data girildigi halde hotel kaydedilebildigi test edildi");
        hotelListPage.hotelUpdatedSuccessfullyOkLinki.click();
        hotelListPage.deleteHotel("karisikDataYollayarakHotelUpdate");
        extentTest.pass("Karisik data girilerek kaydedilen hotelin silinebildigi test edildi");
        Driver.getDriver().switchTo().window(ilkSayfaHandleDegeri);
        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();

    }

    @Test(priority = 4)
    public void kutularinAslinaUygunDoldurulmasiHotelUpdate () throws IOException, InterruptedException {
        //2-https://www.hotelmycamp.com/admin/HotelAdmin/Edit?Id=1069 sekmesinde bulunan
        //3-butun kutularin aslina uygun olarak duzenlenebildigi test edilir
        //4-silme ve duzenleme isleminden sonra save butonuna basilabildigi ve bilgilerin kaydedildigi test edilir
        extentTest=extentReports.createTest("Edit Hotel sayfasindaki bos kutularin hepsine aslina uygun datalarinin girilebildigi testi","Edit Hotel sayfasindaki bos kutularin hepsine aslina uygun girilebildigi test edilir");
        extentTest.info("Edit Hotel Tabina gecilerek sadece karisik datalar giris yapilarak bos kutularin testine baslandi");
        mainPage.managerHotelMyCampGiris();
        String ilkSayfaHandleDegeri= Driver.getDriver().getWindowHandle();
        ReusableMethods.waitFor(3);
        hotelListPage.hotelManagementLink.click();
        hotelListPage.hotelListLink.click();
        ReusableMethods.waitFor(2);

        hotelListPage.detailsButton.click();

        Set<String> handleDegerleriSeti= Driver.getDriver().getWindowHandles();
        String windowHandleDegeri2="";
        for (String each:handleDegerleriSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                windowHandleDegeri2=each;
            }
        }
        Driver.getDriver().switchTo().window(windowHandleDegeri2);
        hotelListPage.kutulariClear();
        hotelListPage.kutularinAslinaUygunDoldurulmasi(hotelListPage.hasanCodeWebElementi);

        Select select=new Select(hotelListPage.idGroupKutusuWebElementi);
        List<WebElement> optionListDropDown=select.getOptions();
        JSUtils.scrollIntoVIewJS(hotelListPage.idGroupKutusuWebElementi);
        for (int i = 1; i <3 ; i++) {
            select.selectByIndex(i);
        }
        hotelListPage.saveButton.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("US05/Kutulara aslina uygun olarak data gonderildi kaydedildi ve Hotel Update Yazisi Ekran goruntusu alindi");
        extentTest.pass("Kutulara aslina uygun data girilerek hotel kaydedilebildigi test edildi");
        hotelListPage.hotelUpdatedSuccessfullyOkLinki.click();
        hotelListPage.deleteHotel("kutularinAslinaUygunDoldurulmasiHotelUpdate");
        extentTest.pass("Aslina uygun data girilerek kaydedilen hotelin silinebildigi test edildi");
        Driver.getDriver().switchTo().window(ilkSayfaHandleDegeri);
        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();


    }







}
