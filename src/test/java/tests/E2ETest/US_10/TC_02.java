package tests.E2ETest.US_10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_02 extends TestBaseRapor {
    public UserPage userPage;
    public SoftAssert softAssert;
    public JavascriptExecutor jse;


    @Test
    public void test2() {
        softAssert = new SoftAssert();
        userPage = new UserPage();
        jse=(JavascriptExecutor) Driver.getDriver();

        ReusableMethods.waitFor(1);
        userPage.profilLink.click();
        extentTest = extentReports.createTest("Kullanici kendi Profilinde degisiklik yapmak icin gerekli olan webelementlerinin gorunurlugu Testi", "Butun webelemntler sayfada bulunmaktadir.");

        for (WebElement each:userPage.profilPageList) {
            jse.executeScript("arguments[0].scrollIntoView(true);",each);
            softAssert.assertTrue(each.isDisplayed());

        }
        softAssert.assertAll();
        extentTest.pass("Profil sayfasinda bulunan elementlerin gorunur olup olmadigi test edildi.");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.HOME).perform();

    }
}