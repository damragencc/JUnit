package day06_jsAlert_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfterClass;

public class C01_JsAlert extends TestBase_BeforeAfterClass {

    //3 test method'u olusturup asagidaki gorevi tamamlayin


    @Test
    public void basicAlert(){

        //1. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin

        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 1.alert'e tiklayin

        driver.findElement(By.xpath("(//button[@class='j-button'])[1]")).click();

        // - Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        ReusableMethods.bekle(2);

        String actualYazi=driver.switchTo().alert().getText();

        String expected="I am a JS Alert";

        Assert.assertEquals(expected,actualYazi);

        // - OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

      ReusableMethods.bekle(2);


    }

    @Test
    public void confirmAlert(){

        //2.Test
        // - "https://testotomasyonu.com/javascriptAlert" adresine gidin

        driver.get("https://testotomasyonu.com/javascriptAlert" );

        // - 2.alert'e tiklayalim
        driver.findElement(By.xpath("(//button[@class='j-button'])[2]")).click();


        //cancel'a basin
        driver.switchTo().alert().dismiss();

        // - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        String expextedSonucyazi="You clicked: Cancel";

        String actualSonucYazi=driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertEquals(expextedSonucyazi,actualSonucYazi);

    }

    @Test
    public void promptAlert(){

        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 3.alert'e tiklayalim
        driver.findElement(By.xpath("(//button[@class='j-button'])[3]")).click();

        // - Cikan prompt ekranina "Abdullah" yazdiralim

        driver.switchTo().alert().sendKeys("Rasit");

        // - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim

        String expected="Rasit";

        String actualSonuc=driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertTrue(actualSonuc.contains(expected));
    }

}
