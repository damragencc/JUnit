package day09_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C02_KlasikWebTables extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        //1."https://testotomasyonu.com/webtables" adresine gidin

        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin

        WebElement tumBodyElementi=driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin

        String expectedBodyIceriK="Comfortable Gaming Chair";

        String actualTumBody=tumBodyElementi.getText();

        Assert.assertTrue(actualTumBody.contains(expectedBodyIceriK));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> satirElementleriList=driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi= 5;
        int actualSatirSayisi=satirElementleriList.size();

          Assert.assertEquals(actualSatirSayisi,expectedSatirSayisi);

        //5. Tum satirlari yazdirin

        System.out.println( ReusableMethods.stringListeDonustur(satirElementleriList));


        //6. Web table’daki sutun sayisinin 4 olduğunu test edin

        int expectedSutunSayisi=4;

        //herhangi bir satirdaki datalari List'e koyup List'in size'ina bakabiliriz

        List<WebElement> birinciSatirElementleri=driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int actualSayisi=birinciSatirElementleri.size();

        Assert.assertEquals(expectedSutunSayisi,actualSayisi);


        //7. 3.sutunu yazdirin

        List<WebElement> ucuncuSutunElementleriList=driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println("Ucuncu sutun elementleri listesi " +ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));


        //8. Tablodaki basliklari yazdirin

        WebElement baslıkSatirElementi=driver.findElement(By.xpath("//thead/tr"));
        System.out.println("Baslıklar  : " +baslıkSatirElementi.getText());

        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun


        System.out.println(getData(2,3));

        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

            String expectedData="Furniture";
            String actualData=getData(4,2);

            Assert.assertEquals(actualData,expectedData);


    }

    public String getData(int satir, int sutun){

        //         //tbody/tr[  2  ]/td[    2   ]

        String dinamikXpath="//tbody/tr["  + satir + "]/td[" +sutun + "]";

        WebElement istenenDataElementi=driver.findElement(By.xpath(dinamikXpath));

        return  istenenDataElementi.getText();
    }
}
