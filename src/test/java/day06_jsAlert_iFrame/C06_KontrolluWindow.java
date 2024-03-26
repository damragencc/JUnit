package day06_jsAlert_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C06_KontrolluWindow extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        //● testotomasyonu anasayfa adresine gidin.

        driver.get("https://www.testotomasyonu.com");


        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String toWindownHandleDegeri=driver.getWindowHandle();

        //● Sayfa title’nin “Otomasyon” icerdigini test edin

        String expectedIcerikTittle="Otomasyon";
        String actualTittle=driver.getTitle();

        Assert.assertTrue(actualTittle.contains(expectedIcerikTittle));

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        System.out.println("wisequarter WHD : " +driver.getWindowHandle());



        //● Sayfa title’nin “wisequarter” icerdigini test edin
        String wiseTittle="Wise Quarter";
        String actualtitle=driver.getTitle();

        Assert.assertTrue(actualtitle.contains(wiseTittle));


        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.walmart.com");
        System.out.println("walmart WHD :"+driver.getWindowHandle());

        //● Sayfa title’nin “Walmart” icerdigini test edin

        String expectedTittlee="Walmart";
        String actuallTitle= driver.getTitle();

        Assert.assertTrue(actuallTitle.contains(expectedTittlee));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        driver.switchTo().window(toWindownHandleDegeri);
         expectedIcerikTittle="Otomasyon";
         actualTittle=driver.getTitle();

        Assert.assertTrue(actualTittle.contains(expectedIcerikTittle));





        ReusableMethods.bekle(2);
    }


}
