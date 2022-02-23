package tests.E2ETest.US_10;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    public UserPage userPage;
    public SoftAssert softAssert;

    @Test
    public void loginClick(){
        softAssert=new SoftAssert();
        userPage =new UserPage();
        extentTest = extentReports.createTest("Sayfaya kullanici olarak Giris", "Hotele kullanici olarak giris yapildigi test edildi");

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.pass("Hotel sayfasi acildi.");
        userPage.mainLoginLink.click();
        extentTest.pass("Hotel sayfasindaki login linki tiklandi.");
        userPage.loginUserBox.sendKeys(ConfigReader.getProperty("HMCValidUserPageUsername"));
        extentTest.pass("log in sayfasindaki username boxa dogru username girildi.");
        userPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidUserPagePassword"));
        extentTest.pass("log in sayfasindaki password boxa dogru password girildi.");
        userPage.loginButton.click();
        extentTest.pass("log in sayfasindaki log in butona tiklandi.");

    }



}

