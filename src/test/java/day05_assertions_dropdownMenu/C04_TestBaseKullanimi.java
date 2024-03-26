package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C04_TestBaseKullanimi extends TestBase_BeforeAfter {





    // arama sonucunda urun bulunabildigini test edin

    @Test
    public void aramaTesti(){
        //testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");


        // phone icin arama yapin

        WebElement aramaKutusu= driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);


        // arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanElementList=driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanElementList.size()>0);

    }
}
