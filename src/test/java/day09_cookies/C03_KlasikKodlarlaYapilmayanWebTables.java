package day09_cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C03_KlasikKodlarlaYapilmayanWebTables extends TestBase_BeforeAfter {

    @Test
    public void test01(){


        //1. “https://testotomasyonu.com/webtables2” sayfasina gidin

        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers da bulunan basliklari yazdirin

        WebElement headers=driver.findElement(By.xpath("//div[@role='hrow']"));
        System.out.println(headers.getText());

        // 3. 3.sutunun basligini yazdirin

        List<WebElement> baslikElementlerList=driver.findElements(By.xpath("//div[@role='hrow']/div[@role='hdata']"));
        System.out.println("tum baslık listesi " + ReusableMethods.stringListeDonustur(baslikElementlerList));
        System.out.println("3.sutun basligi " +baslikElementlerList.get(2).getText());



        // 4. Tablodaki tum datalari yazdirin

        List<WebElement> dataElementleriList=driver.findElements(By.xpath("//*[@*='tdata']"));
        System.out.println("Tum data listesi " +ReusableMethods.stringListeDonustur(dataElementleriList));


        // 5. Tabloda kac tane cell (data) oldugunu yazdirin

        System.out.println("Tablo body'sindeki data sayisi : " +dataElementleriList.size());

        // 6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirElementleriSayisi=driver.findElements(By.xpath("//*[@*='trow']"));
        System.out.println("Tablodaki sutun sayisi : " +satirElementleriSayisi.size());


        // 7. Tablodaki sutun sayisini yazdirin



        List<WebElement> sutunElementleriSayisi=driver.findElements(By.xpath("((//div[@role='trow'])[2]/div[@role='tdata'])"));
        System.out.println("tablodaki sutun Sayisi : " +sutunElementleriSayisi.size());


        //System.out.println("Tablodaki sutun sayisi : " +dataElementleriList.size()/satirElementleriSayisi.size() );

        // 8. Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuKolon=driver.findElements(By.xpath("(//div[@role='trow'])/div[@role='tdata'][3]"));
        System.out.println(ReusableMethods.stringListeDonustur(ucuncuKolon));




        // 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        // herbir satiri elden gecirip
        //Cotegory bilgisi Furniture olan satiri bulup
        //o satirdaki urun fiyatını yazdirmaliyiz
        //her satirdaki Category elementinin locat'i
        //(//div[@role='trow'])[5]/div[@role='tdata'][2]

        for (int i = 1; i < satirElementleriSayisi.size() ; i++) {

            String dinamikCategoryXpathi="(//div[@role='trow'])[" + i + "]/div[@role='tdata'][2]";
            String dinamikFiyatXpathi= "(//div[@role='trow'])[\" + i + \"]/div[@role='tdata'][3]";

            String satirdakiCategoryDegeri=driver.findElement(By.xpath(dinamikCategoryXpathi)).getText();

            String satirdakiFiyatDegeri=driver.findElement(By.xpath(dinamikFiyatXpathi)).getText();

            if (satirdakiCategoryDegeri.equals("Furniture")){

                System.out.println(satirdakiFiyatDegeri);
            }

        }
        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin

  printData(1,2);
    }

    public void printData(int satirNo,int sutunNo){

        //((//div[@role='trow'])[4]/div[@role='tdata'])[2]

        String dinamikXpath="((//div[@role='trow'])[" + satirNo + "]/div[@role='tdata'])["+sutunNo+"]";

        WebElement istenenWebelement=driver.findElement(By.xpath(dinamikXpath));

        System.out.println(istenenWebelement.getText());


    }
}
