package day09_cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C04_DemoQaWebTable extends TestBase_BeforeAfter {

    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin

        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin

        List<WebElement> baslıkElementlerListesi=driver.findElements(By.xpath("(//div[@role='row'])/div[@role='columnheader']"));

        System.out.println(ReusableMethods.stringListeDonustur(baslıkElementlerListesi));

        // 3. 3.sutunun basligini yazdirin

        System.out.println(baslıkElementlerListesi.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin

        List<WebElement> tumData=driver.findElements(By.xpath("(//div[@role='row'])/div[@role='gridcell']"));

        //System.out.println(ReusableMethods.stringListeDonustur(tumData));


        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        int bosOlmayanHucreSayisi=0;
        System.out.println("Tum Datalar");

        for (int i = 0; i <tumData.size() ; i++) {

            if (!tumData.get(i).getText().isBlank()){

                System.out.println(tumData.get(i).getText());

                bosOlmayanHucreSayisi++;

            }

        }

        System.out.println("Bos olmayan hucre sayisi : " +bosOlmayanHucreSayisi);
        // 6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirElementLerList=driver.findElements(By.xpath("(//div[@role='row'])"));

        System.out.println(satirElementLerList.size());


        // 7. Tablodaki sutun sayisini yazdirin
        // 8. Tablodaki 3.kolonu yazdirin
        // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //10. bir method olusturun, satir ve sutun sayisi girildiğinde datayi yazdirsin

    }
}
