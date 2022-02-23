package tests.E2ETest.US_09;

import org.testng.annotations.Test;
import pages.MainPage;
import utilities.TestBaseRapor;

public class TC_001 extends TestBaseRapor {
    MainPage mainPage;
    @Test
    public void managerLogin(){
        mainPage=new MainPage();

        extentTest=extentReports.createTest("TC_001","Yonetici basarili sekilde login yapabilmeli");
        mainPage.managerHotelMyCampGiris();
        extentTest.info("Yonetici olarak basarili sekilde login yapildi.");
    }
}