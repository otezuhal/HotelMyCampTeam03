package tests.E2ETest.US_04;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HotelListPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC0002 extends TestBaseRapor {
    MainPage mainPage;
    HotelListPage hotelListPage;
    Actions actions;

    @Test
    public void logIn() {
        actions = new Actions(Driver.getDriver());
        hotelListPage = new HotelListPage();
        mainPage = new MainPage();

        extentTest = extentReports.createTest("Sayfaya Yonetici olarak Giris Yapildi");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("https://www.hotelmycamp.com sayfasina gidildi");

        mainPage.firstLoginLinki.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

        extentTest.info("Log in sayfasindaki login butonuna tiklandi");
        mainPage.firstUserNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        extentTest.info("Username  kutusuna Manager! datasi gonderildi");
        ReusableMethods.waitFor(1);

        mainPage.firstPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        extentTest.info("password  kutusuna Manager! datasi gonderildi");

        mainPage.secondLoginButonu.click();
        extentTest.info("ilk login linkine tiklandi");

        hotelListPage.hotelManagementLinki.click();
        extentTest.info("Hotel Management linkine gidildi");

        hotelListPage.hotelListLinki.click();
        extentTest.info("Hotel List linkine gidildi");

        hotelListPage.addHotelLinki.click();
        extentTest.info("Hotel List linkine gidildi");

        ReusableMethods.waitFor(0);
        actions.click(hotelListPage.addHotelCodeKutusu).sendKeys("1620").perform();
        extentTest.info("Hotel List linkindeki Create Hotel CodeKutusuna 1620 kodu girildi");
        actions.sendKeys(Keys.TAB).sendKeys("Shelton Schumm Jr.").perform();
        extentTest.info("Hotel List linkindeki Create Hotel'e Shelton Schumm Jr. ismi girildi");
        actions.sendKeys(Keys.TAB).sendKeys("1294 Sang Well, North Bernie, MS 47011-9638").perform();
        extentTest.info("Hotel List linkindeki Create Hotel'e 1294 Sang Well, North Bernie, MS 47011-9638 adresi girildi");
        actions.sendKeys(Keys.TAB).sendKeys("040.682.3356").perform();
        extentTest.info("Hotel List linkindeki Create Hotel'e 040.682.3356 telefen no girildi");
        actions.sendKeys(Keys.TAB).sendKeys("team3ortakhesap@gmail.com").perform();
        extentTest.info("Hotel List linkindeki Create Hotel'e team3ortakhesap@gmail.com mail adresi girildi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select select = new Select(hotelListPage.addHotelDropdown);
        select.selectByVisibleText("Hotel Type1");
        extentTest.info("Hotel List linkindeki Create Hotel'de Hotel Type1 secildi");
        actions.moveToElement(hotelListPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(5);

        hotelListPage.logOutButton.click();

    }

}
