package tests.SmokeTest.US_03;


import org.openqa.selenium.Keys;
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

public class NegatifTest extends TestBaseRapor {

    protected WebDriver driver;
    UserPage userPage;
    Actions actions;
    @Test
    public void negativeTest01() throws InterruptedException, IOException {
        userPage = new UserPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Create new account", "reports");
        //1-Kullanici hotelmycamp sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info(" hotelmycamp sayfasına giris yapildigi test edildi");

        //2-Login butonunu gorur ve tiklar
        ReusableMethods.waitFor(5);
        userPage.firstLoginLinki.click();
        Assert.assertTrue(userPage.firstLoginLinki.isDisplayed(), "first login elementi gorunur degil");
        extentTest.info("Ilk login butonununa erisilebilirligi test edildi");
    }
    @Test (dependsOnMethods = "negativeTest01")
    public void negativeTest02() {
        //3- 'Create new acccount' butonunu gorur ve tiklar
        Assert.assertTrue(userPage.createNewAccountButonu.isDisplayed(), "Create new acccount butonu gorunur degil");
        userPage.createNewAccountButonu.click();
        extentTest.info("'Create new acccount' butonunu goruruldu ve tiklandigi test edildi");

    }
    @Test (dependsOnMethods = "negativeTest01")
    public void negativeTest03() throws IOException {
//4- username texbox gorulur ve yanlis veri girisi yapilir
        userPage.userNameTextbox.sendKeys(ConfigReader.getProperty("HMCInValidUserName3"));
        Assert.assertTrue(userPage.userNameTextbox.isDisplayed(), "username elementi gorunur degil");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(userPage.userNameTextboxFailed.isDisplayed());
        extentTest.info("Username should be at least 4 characters long");
        //ReusableMethods.getScreenshot(" username texbox  ");


//5- passwordtextbox username texbox gorulur ve yanlis veri girisi yapilir
        userPage.passwordTextbox.sendKeys(ConfigReader.getProperty("HMCInValidUserPassword2"));
        Assert.assertTrue(userPage.passwordTextbox.isDisplayed(), "passwordTextbox elementi gorunur degil");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(userPage.passwordTextboxFailed.isDisplayed());
        extentTest.info("Password should be at least 5 characters long");
       // ReusableMethods.getScreenshot(" passwordTextbox  ");



//6- emailtextbox gorulur ve yanlis veri girisi yapilir

        userPage.emailTextbox.sendKeys(ConfigReader.getProperty("HMCInValidUserEmail3"));
        Assert.assertTrue(userPage.emailTextbox.isDisplayed(), "emailTextbox elementi gorunur degil");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(userPage.emailTextboxFailed.isDisplayed());
        extentTest.info("Please provide correct email address");
        ReusableMethods.getScreenshot(" emailTextbox ");


//7- fullnametextbox'  gorulur ve yanlis veri girisi yapilir

        userPage.fullNameTextbox.sendKeys(ConfigReader.getProperty("HMCInValidUserFullname1"));
        Assert.assertTrue(userPage.fullNameTextbox.isDisplayed(), "fullNameTextbox elementi gorunur degil");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(userPage.fullNameTextboxFailed.isDisplayed());
        extentTest.info("This field is required.");
       // ReusableMethods.getScreenshot(" fullNameTextbox ");



//8- Phonetextbox'  gorulur ve yanlis veri girisi yapilir

        userPage.PhoneNoTextbox.sendKeys(ConfigReader.getProperty("HMCInValidUserPhoneNo2"));
        Assert.assertTrue(userPage.PhoneNoTextbox.isDisplayed(), "PhoneNoTextbox elementi gorunur degil");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(userPage.PhoneNoTextboxFailed.isDisplayed());
        extentTest.info("Please enter phone number");
        //ReusableMethods.getScreenshot(" PhoneNoTextbox ");


//9- SSNtextbox  gorulur ve yanlis veri girisi yapilir

        userPage.SSNTextbox.sendKeys(ConfigReader.getProperty("HMCInValidUserSocialNo2"));
        Assert.assertTrue(userPage.SSNTextbox.isDisplayed(), "DrivingLicenseTextbox elementi gorunur degil");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(userPage.SSNTextboxFailed.isDisplayed());
        extentTest.info("This field is required.");
        //ReusableMethods.getScreenshot(" SSNTextbox ");

//10- //4- DrivingLicenseTextbox  gorulur ve yanlis veri girisi yapilir

        userPage.DrivingLicenseTextbox.sendKeys(ConfigReader.getProperty("HMCInValidUserDrivingLicence"));
        Assert.assertTrue(userPage.DrivingLicenseTextbox.isDisplayed(), "DrivingLicenseTextbox elementi gorunur degil");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(userPage.DrivingLicenseTextboxFailed.isDisplayed());
        extentTest.info("This field is required.");
        //ReusableMethods.getScreenshot(" DrivingLicenseTextbox ");


//11-IDCountrytextbox  texbox gorulur ve yanlis veri girisi yapilir
       Assert.assertTrue(userPage.IDCountryTextbox.isDisplayed(), "IDCountryTextbox elementi gorunur degil");
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       ReusableMethods.waitFor(2);
       userPage.savebutonu.click();
       actions.sendKeys(Keys.PAGE_UP).perform();
       Assert.assertTrue(userPage.IDCountryTextboxFailed.isDisplayed());
       extentTest.info("Select Country");
       ReusableMethods.waitFor(2);
       actions.sendKeys(Keys.TAB).perform();
        //ReusableMethods.getScreenshot(" IDCountryTextbox ");

        //12-IDStatetextbox  texbox gorulur ve yanlis veri girisi yapilir

      Assert.assertTrue(userPage.IDStateTextbox.isDisplayed(), "IDStateTextbox elementi gorunur degil");
      actions.sendKeys(Keys.PAGE_DOWN).perform();
      ReusableMethods.waitFor(2);
      userPage.savebutonu.click();
      actions.sendKeys(Keys.PAGE_UP).perform();
      Assert.assertTrue(userPage.IDStateTextbox.isDisplayed());
      extentTest.info(" Select State");
      actions.sendKeys(Keys.TAB).perform();

//13-AddressTextbox'  gorulur ve yanlis veri girisi yapilir

        userPage.AddressTextbox.sendKeys(ConfigReader.getProperty("HMCInValidAddress"));
        Assert.assertTrue(userPage.AddressTextbox.isDisplayed(), "AddressTextbox elementi gorunur degil");
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        Assert.assertTrue(userPage.AddressTextboxFailed.isDisplayed());
        extentTest.info("This field is required.");
        //ReusableMethods.getScreenshot(" AddressTextbox ");


//13-WorkingSectortextbox  gorulur ve yanlis veri girisi yapilir

        userPage.WorkingSectorTextbox.sendKeys(ConfigReader.getProperty("HMInValidCValidWorkingSector"));
        Assert.assertTrue(userPage.WorkingSectorTextbox.isDisplayed(), "WorkingSectorTextbox elementi gorunur degil");
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        Assert.assertTrue(userPage.WorkingSectorTextboxFailed.isDisplayed());
        extentTest.info("This field is required.");
        //ReusableMethods.getScreenshot(" WorkingSectorTextbox ");

        //13-BirthDateTextbox gorulur ve yanlis veri girisi yapilir

        userPage.BirthDateTextbox.sendKeys(ConfigReader.getProperty("HMCInValidBirthDate"));
        Assert.assertTrue(userPage.BirthDateTextbox.isDisplayed(), "BirthDateTextbox elementi gorunur degil");
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        Assert.assertTrue(userPage.BirthDateTextboxFailed.isDisplayed());
        extentTest.info("This field is required.");
       // ReusableMethods.getScreenshot(" BirthDateTextbox ");

    }
    @Test  (dependsOnMethods = "negativeTest01")
    public void negativeTest04() throws IOException {
//14 save butonununu gorur ve tiklar
        ReusableMethods.waitFor(2);
        userPage.savebutonu.click();
        Assert.assertTrue(userPage.savebutonu.isDisplayed());
        extentTest.info("save butonunu tiklandi ve kayit yapilamadigi test edildi");
       // ReusableMethods.getScreenshot(" BirthDateTextbox ");

    }
}



