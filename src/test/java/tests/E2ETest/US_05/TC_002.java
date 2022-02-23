package tests.E2ETest.US_05;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelListPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_002 extends TestBaseRapor {
    MainPage mainPage;
    Actions actions;
    HotelListPage hotelListPage;

    //Yonetici dogru kullanici adi ve sifresi ile giris yapabilmeli
    @Test(priority =3)
    public void positiveLoginTest () throws IOException {
        hotelListPage=new HotelListPage();
        actions=new Actions(Driver.getDriver());
        mainPage=new MainPage();

      extentTest=extentReports.createTest("Yonetici Giris Testi dogru data","Yonetici dogru kullanici adi ve sifresi ile giris yapabildigi test edilir");
     extentTest.info("www.hotelmycamp.com sayfasina gidildi ve dogru datalar gonderildi");
        //https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
//login butonuna bas
      //  ReusableMethods.waitFor(1);
      //  Driver.getDriver().navigate().refresh();
        mainPage.firstLoginLinki.click();
        ReusableMethods.waitFor(1);
        actions.
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                perform();
        //1-username  kutusuna manager datasi gonderilir (sendkeys)
        mainPage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        ReusableMethods.waitFor(1);
        //2-ve password  kutusuna Manager! (datasi gonderilir sendkeys)
        mainPage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        extentTest.info("Dogru datalar girildi");
        ReusableMethods.waitFor(1);
        mainPage.secondLoginButonu.click();
        //3-gecerli giris yapilabildigi
        // https://www.hotelmycamp.com/Admin/UserAdmin urlsine ulasildigi test edilir(positive test)
        String expectedUrl="https://www.hotelmycamp.com/Admin/UserAdmin";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        //Driver.closeDriver();
        extentTest.pass("Yoneticinin dogru kullanici adi ve sifresi ile giris yapabildigi test edildi");
        ReusableMethods.getScreenshot("US05/positiveLoginTest basarili");
        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelListPage.logOutButton.click();
        ReusableMethods.waitFor(2);
         //Driver.closeDriver();

    }


    //5-gecersiz datalarla giris yapilamadigi kontrol edilir (negative test)
    @Test(priority = 1)
    public void negativeLoginTestWrongUserName () throws IOException {

        hotelListPage=new HotelListPage();
        actions=new Actions(Driver.getDriver());
        mainPage=new MainPage();
        //ReusableMethods.waitFor(2);
        extentTest=extentReports.createTest("Yonetici Giris Testi yanlis username","Yanlis username ile yonetici olarak giris yapilamadigi test edilir");
        extentTest.info("www.hotelmycamp.com sayfasina gidildi yanlis username ve dogru sifre girildi");
        //https://www. hotelmycamp.com/ adresine git

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
//login butonuna bas
        ReusableMethods.waitFor(1);
        mainPage.firstLoginLinki.click();
        ReusableMethods.waitFor(1);
        actions.
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                perform();
        //1-username  kutusuna yanlis manager datasi gonderilir (sendkeys)
        for (int i = 2; i <3; i++) {
            mainPage.firstUserNameBox.clear();
            mainPage.firstUserNameBox.sendKeys("manager"+i);
            //2-ve password  kutusuna Manager! (datasi gonderilir sendkeys)
            mainPage.firstPasswordBox.clear();
            mainPage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
            ReusableMethods.waitFor(1);
            Driver.getDriver().navigate().refresh();
            mainPage.secondLoginButonu.click();
            //3-gecerli giris yapilamadigi

            String expectedTitle = "Admin - ListOfUsers";
            String actualTitle = Driver.getDriver().getTitle();
            Assert.assertFalse(actualTitle.equals(expectedTitle));
            System.out.println(i+" inci manager datasi denendi");
            extentTest.pass("Yoneticinin yanlis kullanici adi ve sifresi ile giris yapamadigi test edildi");
        }
        ReusableMethods.getScreenshot("US05/Wrongusername ile giris yapilamadigi testi basarili");
       // actions.moveToElement(hotelListPage.managerDropDownButton).perform();
       // ReusableMethods.waitFor(2);
       // hotelListPage.logOutButton.click();
      //   Driver.closeDriver();
        }

    @Test(priority = 2)
    public void negativeLoginTestWrongpassword (){
        hotelListPage=new HotelListPage();
        actions=new Actions(Driver.getDriver());
        mainPage=new MainPage();

        extentTest=extentReports.createTest("Yonetici girisi Wrongpassword","Yoneticinin dogru kullanici adi ve yanlis sifre ile giris yapamadigi test edilir");
       extentTest.info("www.hotelmycamp.com sayfasina gidildi dogru username ve yanlis sifre girildi");
       https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
//login butonuna bas
            mainPage.firstLoginLinki.click();
        ReusableMethods.waitFor(1);
        actions.
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                perform();
        //1-username  kutusuna dogru manager datasi gonderilir (sendkeys)
        for (int i = 1; i <2; i++) {
            mainPage.firstUserNameBox.clear();
            mainPage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
            //2-ve password  kutusuna yanlis (datasi gonderilir sendkeys)
            mainPage.firstPasswordBox.clear();

            mainPage.firstPasswordBox.sendKeys(Faker.instance().lorem().characters(2,50));
            ReusableMethods.waitFor(1);
            mainPage.secondLoginButonu.click();
            //3-gecerli giris yapilamadigi
            //
            String expectedTitle = "Admin - ListOfUsers";
            String actualTitle = Driver.getDriver().getTitle();
            Assert.assertFalse(actualTitle.equals(expectedTitle));
            System.out.println(i+" inci password datasi denendi");

        }
       extentTest.pass("Yoneticinin dogru kullanici adi ve yanlis sifre ile giris yapamadigi test edildi");

    }





    }






