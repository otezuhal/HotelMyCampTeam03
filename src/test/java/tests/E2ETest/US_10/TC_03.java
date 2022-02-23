package tests.E2ETest.US_10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_03 extends TestBaseRapor {

    public UserPage userPage;
    public SoftAssert softAssert;
    public JavascriptExecutor jse;
    
    @Test
    public void test3() throws InterruptedException {
        jse=(JavascriptExecutor) Driver.getDriver();
        softAssert = new SoftAssert();
        userPage = new UserPage();

        extentTest = extentReports.createTest("User Menu ve Categories Menusundeki Elementlerin gorunurluk Testi", "Butun webelementler sayfada bulunmaktadir.");
        for (WebElement each :userPage.userMenuCategoriesList) {
            jse.executeScript("arguments[0].scrollIntoView(true);",each);
            softAssert.assertTrue(each.isDisplayed());

        }
        softAssert.assertAll();
        extentTest.info("Profil sayfasinda bulunan User Menu ve Categories elementlerin gorunur olup olmadigi test edildi.");

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.HOME).sendKeys(Keys.PAGE_DOWN).perform();

    }

}
