package tests.day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_JUnitIlkTest {

    /*
         JUNit'in bize sagladigi en buyuk avantajlardan biri @Test nostasyonudur

         @Test sayesinde siradan method'lar bagimsiz olarak calisabilecek test method'larina donusur

         JUNit'de bir class'daki test method'larinin hangi sira ile calisacagi
         ONGURULEMEZ ve DUZENLENEMEZ
         (test01, test02, test03 yazarsak bu siraya uygun calistiriyor)

     */

        //asagidaki 3 websayfasina gidip, o sayfalara gittigimizi test edin
        //testler birlikte veya ayi ayri calistirilabilmelidir
        //youtube, testotomasyonu ve wisequarter

    @Test @Ignore
    public void youtubeTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http://www.youtube.com");

        String expectedUrlIcerik="youtube";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAİLED");

        ReusableMethods.bekle(2);
        driver.quit();
    }



    @Test
    public void testOtomasyonu(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http://www.testotomasyonu.com");

        String expectedUrlIcerik="testotomasyonu";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAİLED");

        ReusableMethods.bekle(2);
        driver.quit();

    }



    @Test
    public void wisequarterTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http://www.wisequarter.com");

        String expectedUrlIcerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("wisequarter testi PASSED");
        }else System.out.println("wisequarter testi FAİLED");

        ReusableMethods.bekle(2);
        driver.quit();

    }




}
