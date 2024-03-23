package tests.day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C07_Soru {


    //asagidaki 3 testi ayrı ayri test method'larinda calistirin

    // 1-Testotomasyonu anasayfaya gidin
    //testotomasyonu sayfasina gittiginizi test edin

    //2-phone icin arama yapınız
    //arama sonucunda urun bulunabildigini test edin

    //3-ilkurunu tiklayip
    //urun ismine case sensitive olmadan phone gectigini test edin


     static WebDriver driver;
    @BeforeClass
    public static void SEtup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @AfterClass
    public static void tearDown(){

        ReusableMethods.bekle(2);
        driver.quit();


    }
   @Test
    public void test01(){

       // 1-Testotomasyonu anasayfaya gidin

        driver.get("http://www.testotomasyonu.com");

       //testotomasyonu sayfasina gittiginizi test edin

       String extectedUrl="testotomasyonu";
       String actualUrl= driver.getCurrentUrl();

       if (actualUrl.contains(extectedUrl)){
           System.out.println("Test01 PASSED");
       }else System.out.println("Test01 FAİLED");


    }

    @Test
    public void test02(){

        //2-phone icin arama yapınız

        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@class='search-input']"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin

       List<WebElement> urunListesi=driver.findElements(By.xpath("//span[@class='product-count-text']"));

       if (urunListesi.size()>0){

           System.out.println("Test02 PASSED");
       }else System.out.println("Test01 FAİLED");


    }

    @Test
    public void test03(){

        //3-ilkurunu tiklayip

        List<WebElement> birinciUrun=driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));
        birinciUrun.get(0).click();

        //urun ismine case sensitive olmadan phone gectigini test edin

        String extectedCase="phone";

        String actuarlCase=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']")).getText().toLowerCase();

        if (actuarlCase.contains(extectedCase)){
            System.out.println("Test03 PASSED");
        }else System.out.println("Test03 FAİLED");


    }

}
