package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_BeforeAfterKullanımı {

    /*
        Gorevimiz her ne kadar basit olsa da
        @After notasyonuna sahip method'u ayri yapmak daha mantkilidir

        Assert method'lari assertion failed oldugunda exception fırlatır ve
        test method'unda kod calismasini durdurur
 // testotomasyonu anasayfaya gidin
   // nutella icin arama yapin
     // arama sonucunda urun bulunabildigini test edin
      // arama sonucunda urun bulunabildigini test edin
      // sayfayi kapatin
     */

    WebDriver driver ;

    @After
    public  void teardown(){

        ReusableMethods.bekle(3);
        driver.quit();


    }

    @Test
    public void nutellaTesti(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //*[@class='product-box my-2  py-1']
              // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

             // nutella icin arama yapin

        WebElement aramaKutusu= driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);


             // arama sonucunda urun bulunabildigini test edin

        List<WebElement> urunsonucu=driver.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));

        Assert.assertFalse(urunsonucu.size()>0);

        System.out.println("Assertion failed olursa bu satır calısmaz");





             // sayfayi kapatin


    }


}
