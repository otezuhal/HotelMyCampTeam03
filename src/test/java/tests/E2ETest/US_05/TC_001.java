package tests.E2ETest.US_05;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelListPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_001 extends TestBaseRapor {
    MainPage mainPage;
    SoftAssert softAssert=new SoftAssert();
    Actions actions=new Actions(Driver.getDriver());

    HotelListPage hotelListPage=new HotelListPage();
    //1-www.hotelmycamp.com url'sine gidilir
    //2-login butonun gorunur ve erisilebilir oldugu test edilir
    @Test
    public void loginButonuTest () throws IOException {
        mainPage=new MainPage();


        extentTest=extentReports.createTest("Ilk test login butonu","login butonun gorunur ve erisilebilir oldugu test edilir");
        extentTest.info("www.hotelmycamp.com sayfasina gidildi");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        WebElement loginButonuElementi=mainPage.firstLoginLinki;
        String loginButonuElementiStr=loginButonuElementi.getText();
        System.out.println("loginButonuElementiStr = " + loginButonuElementiStr);
        Assert.assertTrue((loginButonuElementi.isDisplayed()));
        Assert.assertTrue((loginButonuElementi.isEnabled()));

        extentTest.pass("login butonun gorunur ve erisilebilir oldugu test edildi");
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("US05/loginButonu sayfasi");
      // actions.moveToElement(hotelListPage.managerDropDownButton).perform();
      // ReusableMethods.waitFor(2);
      // hotelListPage.logOutButton.click();


    }





}