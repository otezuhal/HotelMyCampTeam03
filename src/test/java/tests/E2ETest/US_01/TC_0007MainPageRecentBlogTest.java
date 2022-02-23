package tests.E2ETest.US_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_0007MainPageRecentBlogTest extends TestBaseRapor {
    MainPage mainPage=new MainPage();

    //7- Recent Blog bolumu gorunur ve icerisindeki elementler tiklanabilir olmali.
    @Test
    public void mainPageRecentBlogIsDisplayed(){
        extentTest=extentReports.createTest("mainPageRecentBlogIsDisplayed");
        mainPage.mainPageUrl();
        extentTest.info("HotelMy Camp sitesine gidildi.");
        ReusableMethods.waitFor(2);
        JSUtils.scrollIntoVIewJS(mainPage.mainPageRecentBlogText);
        extentTest.info("Recent Blog'a scrolldown yapildi");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mainPage.mainPageRecentBlogText.isDisplayed());
        extentTest.info("mainPageRecentBlogText'in gorunurlugu test edildi ");

        for (int i = 1; i <=4 ; i++) {
            String mainPageRecentBlogXpath = "(//div[@class='col-md-3 d-flex ftco-animate fadeInUp ftco-animated'])[" + i + "]";
            WebElement mainPageRecentWebElements = Driver.getDriver().findElement(By.xpath(mainPageRecentBlogXpath));
            Assert.assertTrue(mainPageRecentWebElements.isDisplayed());
            extentTest.info("Recent Blog'taki resimlerin gorunurlugu test edildi ");
        }

        for (int i = 11; i <=14 ; i++) {
            String mainPageRecentBlogText = "(//h3)[" + i + "]";
            WebElement mainPageRecentBlogTextWebElement=Driver.getDriver().findElement(By.xpath(mainPageRecentBlogText));
            ReusableMethods.waitFor(2);
            mainPageRecentBlogTextWebElement.click();
            extentTest.info("mainPageRecentBlog'taki 4 resme tek tek click yapildi");
            ReusableMethods.waitFor(2);
            String actualTitle=Driver.getDriver().getTitle().toString();
            String expectedTitle="Even the all-powerful Pointing has no control about the blind texts";
            Driver.getDriver().navigate().back();
            extentTest.info("mainPageRecentBlog'taki 4 resmin  gorunurlugunu test edebilmek icin her click'ten sonra driver geri alindi  ");
            ReusableMethods.waitFor(2);
            Assert.assertTrue(actualTitle.contains(expectedTitle));
            extentTest.info("mainPageRecentBlog'taki 4 resmin  title'larinin actual title icerip icermedi test edildi ");

        }

       // Driver.closeDriver();
      //  extentTest.info("Driver kapatildi");










            }

        }



