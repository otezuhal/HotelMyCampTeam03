package tests.E2ETest.US_01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_0008InstagramPageTest extends TestBaseRapor {

    MainPage mainPage=new MainPage();
    Actions actions=new Actions(Driver.getDriver());

    //8- Instagram kismi gorunur ve icerisindeki elementler tiklanabilir olmali
    @Test
    public void mainPageInstagramPageIsDisplayed(){
        extentTest=extentReports.createTest("mainPageInstagramPageIsDisplayed");
       mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
       ReusableMethods.waitFor(2);
        JSUtils.scrollIntoVIewJS(mainPage.mainPageInstagramText);
     extentTest.info("mainPage instagram'a scrolldown yapildi");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.mainPageInstagramText.isDisplayed());
     extentTest.info("mainPage instagram yazisi goruldu");
        ReusableMethods.waitFor(2);

        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstgramImg1);
        Assert.assertTrue(mainPage.mainPageInstgramImg1.isEnabled());
        ReusableMethods.waitFor(2);
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstgramImg2);
        Assert.assertTrue(mainPage.mainPageInstgramImg2.isEnabled());
        ReusableMethods.waitFor(2);
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstgramImg3);
        Assert.assertTrue(mainPage.mainPageInstgramImg3.isEnabled());
        ReusableMethods.waitFor(2);
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstgramImg4);
        Assert.assertTrue(mainPage.mainPageInstgramImg4.isEnabled());
     extentTest.info("mainPage instagram bolumunde resimlere tiklandi.");
        ReusableMethods.waitFor(2);

        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstgramImg3);
        Assert.assertTrue(mainPage.mainPageInstgramImg3.isEnabled());
        ReusableMethods.waitFor(2);
        // next ve previous buttonlarinin calismasi
        ReusableMethods.waitFor(2);
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstagramNextButton);
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstagramPreviousButton);
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstagramPreviousButton);
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstagramNextButton);
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstagramPreviousButton);
        javascriptExecutor.executeScript("arguments[0].click();",mainPage.mainPageInstagramPreviousButton);
     extentTest.info("mainPage instagram resimlerde next ve previous buttonlarina  tiklandi.");
     ReusableMethods.waitFor(2);

//        Driver.closeDriver();
//        extentTest.info("Driver kapatildi");




    }
}
