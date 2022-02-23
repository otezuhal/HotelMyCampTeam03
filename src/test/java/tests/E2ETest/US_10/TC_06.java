package tests.E2ETest.US_10;

import org.openqa.selenium.By;
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

public class TC_06 extends TestBaseRapor {

    public UserPage userPage;
    public SoftAssert softAssert;
    public JavascriptExecutor jse;


    @Test
    public void test6(){
        jse = (JavascriptExecutor) Driver.getDriver();
        softAssert = new SoftAssert();
        userPage = new UserPage();

        extentTest = extentReports.createTest("Kayitli reservasyon sayfalari", "yapilan reservasyonlarin varligini test edildi");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.HOME).perform();
        ReusableMethods.waitFor(1);
        userPage.ReservationsLink.click();
        softAssert.assertTrue(userPage.reservationText.isDisplayed(),"Reservations are not showing");

        // reservationlarin odalari  listelenir
        System.out.println("Reservations");

        for (WebElement each:userPage.reservationList) {
            System.out.println(each.getText());
        }
        extentTest.pass("Yapilan tum reservasyonlarin listelendigi test edildi");

        //Detail linklerinin olup olmadigi test ediliyor
        for (WebElement each:userPage.detailLinkList) {
            softAssert.assertTrue(each.isDisplayed());
        }
        extentTest.pass("Yapilan tum reservasyonlarin yanindaki detail linkinin varligi test edildi");

        //Butun Reservasyonlarin ayrintilarina tiklayip, olup olmadigini test ediliyor ve goruntuluyor
        int a=1;
        for (int i=2;i<6;i++) {
            Driver.getDriver().findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div/table/tbody/tr["+i+"]/td[6]/a")).click();
            System.out.println();
            System.out.println(a+". Reservation Detail");
            a++;
            for (WebElement w: userPage.firstReservationDetailTable) {
                System.out.println(w.getText());
            }
            Driver.getDriver().navigate().back();
        }
        extentTest.pass("Yapilan tum reservasyonlarin yanindaki detail linkine tiklayarak ayrintilarin varligi test edildi ve yazdirildi");
        softAssert.assertAll();
        Driver.closeDriver();


    }

}
