package tests.US_001;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
public class TC_0003CheckAvailability {
    MainPage mainPage=new MainPage();
    SoftAssert softAssert=new SoftAssert();
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void checkInDateisDisplayed(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ReusableMethods.waitFor(2);
        WebElement mainPageCheckInDateElement=mainPage.mainPageCheckInDateText;
        String mainPageCheckInDateStr=mainPageCheckInDateElement.getText();
        System.out.println("mainPageCheckInDateStr =" +mainPageCheckInDateStr);
        softAssert.assertTrue(mainPageCheckInDateElement.isDisplayed());

        //CheckInDate Uptade kismi
        mainPage.mainPageCheckInDateInput.click();
        mainPage.mainPageCheckInDateInputNext.click();
        mainPage.mainPageCheckInDateInputSecilecekGun.click();
        //CheckOutDate Uptade kismi
        mainPage.getMainPageCheckOutDateInput.click();
        mainPage.mainPageCheckInDateOutputNext.click();
        mainPage.mainPageCheckInDateOutputSecilecekGun.click();
        //Room box Uptade kismi
        Select select=new Select(mainPage.mainPageRoomBox);
        select.selectByVisibleText("Double");
        // Adult box Uptade kismi
        Select select1=new Select(mainPage.mainPageCustomerBox);
        select1.selectByVisibleText("2 Adult");






////td[.='10']
        //(//th[@class='next'])[1]
    }
    @Test
    public void checkOutDateisDisplayed(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ReusableMethods.waitFor(2);
        WebElement mainPageCheckOutDateElement=mainPage.mainPageCheckOutDateText;
        String mainPageCheckInDateStr=mainPageCheckOutDateElement.getText();
        System.out.println("mainPageCheckInDateStr =" +mainPageCheckInDateStr);
        softAssert.assertTrue(mainPageCheckOutDateElement.isDisplayed());
    }
}