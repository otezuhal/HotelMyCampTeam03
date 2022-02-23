package tests.E2ETest.US_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utilities.*;

public class TC_0006GuestOpinionSlideTest extends TestBaseRapor {
    MainPage mainPage=new MainPage();
    Actions actions=new Actions(Driver.getDriver());
    SoftAssert softAssert=new SoftAssert();

    //6- Misafirlerin yorumlarinin bulundugu slider bolumu gorunur
    // ve altindaki yonlendirme butonlari tiklanabilir olmali.
    @Test
    public void guestOpinionSlideIsDisplayed(){
        extentTest=extentReports.createTest("guestOpinionSlideIsDisplayed");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("HotelMy Camp sitesine gidildi.");
        ReusableMethods.waitFor(2);
        JSUtils.scrollIntoVIewJS(mainPage.mainPageSliderBolumu);
        extentTest.info("Guest yorumlari gorunur oluncaya kadar scrolldown yapildi");
        for (int i = 5; i >=1 ; i--) {
            String guestButton="/html/body/section[7]/div/div/div/div/div/div/div[3]/button["+i+"]";
            WebElement guestButtonWebElement=Driver.getDriver().findElement(By.xpath(guestButton));
            guestButtonWebElement.click();
            extentTest.info("Guest yorumlarina tek tek click yapildi ");
          softAssert.assertTrue(guestButtonWebElement.isDisplayed());
            extentTest.info("Guest yorumlarinin gorunurlugu test edildi");
            ReusableMethods.waitFor(2);
            softAssert.assertAll();
        }

     // ReusableMethods.waitFor(15);
     //  Driver.closeDriver();
     //   extentTest.info("Driver kapatildi");

    }
}
