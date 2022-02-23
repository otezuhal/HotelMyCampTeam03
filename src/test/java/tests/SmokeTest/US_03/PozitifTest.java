package tests.SmokeTest.US_03;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;


public class PozitifTest extends TestBaseRapor {
    protected WebDriver driver;
    UserPage userPage;
    Actions actions;

    @Test
    public void positiveTest01() throws InterruptedException, IOException {
        actions = new Actions(Driver.getDriver());
        userPage = new UserPage();
        extentTest = extentReports.createTest("Create new account", "reports");
        //1- HMCUrl e gider
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info(" hotelmycamp sayfasına giris yapildigi test edildi");


        //2-Login butununa click  yapilir
        userPage.firstLoginLinki.click();
        Assert.assertTrue(userPage.firstLoginLinki.isDisplayed(), "first login elementi gorunur degil");
        extentTest.info("Ilk login butonununa erisilebilirligi test edildi");
    }
    @Test (dependsOnMethods = "positiveTest01")
            public void positiveTest02() {

        //3- "Create a New Account" buttonunun gorulur ve click yapilir
        Assert.assertTrue(userPage.createNewAccountButonu.isDisplayed(), "Create new acccount butonu gorunur degil");
        userPage.createNewAccountButonu.click();
        extentTest.info("'Create new acccount' butonunu goruruldu ve tiklandigi test edildi");

        String actualTitle=userPage.registertext.getText();
        String expectedTitle="Register";
        Assert.assertEquals(actualTitle,expectedTitle,"Register sayfasina gidilmedi");
       extentTest.info("Resgister sayfasina gidildi");

    }
//4- usernametextbox'i gorurulur ve gecerli veri girisi yapilir
@Test (dependsOnMethods = "positiveTest01")
        public void positiveTest03 () throws IOException {

userPage.userNameTextbox.sendKeys(Faker.instance().name().username());
    //userPage.userNameTextbox.sendKeys(ConfigReader.getProperty("HMCValidUserName4"));
    Assert.assertTrue(userPage.userNameTextbox.isDisplayed());
    extentTest.info(" usernametextbox'i goruruldu gecerli veri girisi yapildi");

//5- passwordtextbox'i gorulur ve gecerli veri girisi yapilir

    userPage.passwordTextbox.sendKeys(ConfigReader.getProperty("HMCValidUserPassword"));
    Assert.assertTrue(userPage.passwordTextbox.isDisplayed());
    extentTest.info("passwordtextbox'i goruldu ve gecerli veri girisi yapildi");

//6- emailtextbox'i gorurur ve gecerli veri girisi yapilir

userPage.emailTextbox.sendKeys(Faker.instance().internet().emailAddress());
   // userPage.emailTextbox.sendKeys(ConfigReader.getProperty("HMCValidUserEmail"));
    Assert.assertTrue(userPage.emailTextbox.isDisplayed());
    extentTest.info("emailtextbox'i goruldu ve gecerli veri girisi yapildi");

//7- fullnametextbox'i gorulur ve gecerli veri girisi yapilir


    userPage.fullNameTextbox.sendKeys(ConfigReader.getProperty("HMCValidUserFullname2"));
    Assert.assertTrue(userPage.fullNameTextbox.isDisplayed());
    extentTest.info("fullnametextbox'i goruldu ve gecerli veri girisi yapildi");



//8- Phonetextbox'i gorur ve gecerli veri girisi yapilir

    userPage.PhoneNoTextbox.sendKeys(ConfigReader.getProperty("HMCValidUserPhoneNo3"));
    Assert.assertTrue(userPage.PhoneNoTextbox.isDisplayed());
    extentTest.info("Phonetextbox'i goruldu ve gecerli veri girisi yapildi");

//9- SSNtextbox'i gorur ve gecerli veri girisi yapilir


    userPage.SSNTextbox.sendKeys(ConfigReader.getProperty("HMCValidUserSocialNo3"));
    Assert.assertTrue(userPage.SSNTextbox.isDisplayed());
    extentTest.info("SSNtextbox'i  goruldu ve gecerli veri girisi yapildi");


//10- //4- DrivingLicenseTextbox'i gorur ve gecerli veri girisi yapilir


    userPage.DrivingLicenseTextbox.sendKeys(ConfigReader.getProperty("HMCValidUserDrivingLicence"));
    Assert.assertTrue(userPage.DrivingLicenseTextbox.isDisplayed());
    extentTest.info("DrivingLicenseTextbox'i goruldu ve gecerli veri girisi yapildi");

//11-IDCountrytextbox'i gorur ve gecerli veri girisi yapilir

    Assert.assertTrue(userPage.IDCountryTextbox.isDisplayed());
    userPage.IDCountryTextbox.sendKeys(ConfigReader.getProperty("HMCIDCountryTextbox"));
    extentTest.info("IDCountrytextbox'i goruldu ve gecerli veri girisi yapildi");
    ReusableMethods.waitFor(2);

    //11-IDStatetextbox'i gorur ve gecerli veri girisi yapilir
    Assert.assertTrue(userPage.IDStateTextbox.isDisplayed());
    userPage.IDStateTextbox.sendKeys(ConfigReader.getProperty("HMCIDStateTextbox"));
    extentTest.info("IDStatetextbox'i goruldu ve gecerli veri girisi yapildi");


//12-AddressTextbox'i gorur ve gecerli veri girisi yapilir
    userPage.AddressTextbox.sendKeys(ConfigReader.getProperty("HMCValidAddress"));
    Assert.assertTrue(userPage.AddressTextbox.isDisplayed());
    extentTest.info("AddressTextbox'i goruldu ve gecerli veri girisi yapildi");

//13-WorkingSectortextbox'i gorur ve gecerli veri girisi yapilir

    userPage.WorkingSectorTextbox.sendKeys("QA");
    Assert.assertTrue(userPage.WorkingSectorTextbox.isDisplayed());
    extentTest.info("WorkingSectortextbox'i goruldu ve gecerli veri girisi yapildi");

    //13-BirthDateTextbox'i gorur vegecerli veri girisi yapilir


    userPage.BirthDateTextbox.sendKeys(ConfigReader.getProperty("HMCValidBirthDate"));
    Assert.assertTrue(userPage.BirthDateTextbox.isDisplayed());
    extentTest.info("BirthDateTextbox'i  goruldu ve gecerli veri girisi yapildi");
    ReusableMethods.getScreenshot("BirthDateTextbox");


//14 save butonununu gorur ve tiklar

    // Thread.sleep(2000);
    userPage.savebutonu.click();
    Assert.assertTrue(userPage.savebutonu.isDisplayed());
    extentTest.info("save butonunu goruldu ve gecerli veri girisi yapildi");
    ReusableMethods.waitFor(2);
}
    @Test (dependsOnMethods = "positiveTest01")
        public void positiveTest04() throws IOException {
//15-"UserData was inserted successfully" alertinin gorunurlulur ve click yapilir
        userPage.okbutonu.click();
        Assert.assertTrue(userPage.okbutonu.isDisplayed());
        extentTest.info("kayit bilgileri basariyla kaydedildi");
        ReusableMethods.getScreenshot("UserData was inserted successfully ");


Driver.closeDriver();
        }
    }

