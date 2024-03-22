package tests.day04_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_Before_After {

    /*
          EGER
          her test method'undan once MUTLAKA CALISMASINI istedigimiz bir method varsa
          @Before nostasyonu ile isaretlenebilir

          Aynı sekilde
            her test method'undan once MUTLAKA CALISMASINI istedigimiz bir method varsa
          @After nostasyonu ile isaretlenebilir

     */
    WebDriver driver;

     @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

         System.out.println("Setup methodu calistir");


    }

    @After
    public void teardowm(){

        ReusableMethods.bekle(2);
        driver.quit();
        System.out.println("teardown methodu calisti");
    }


    @Test
    public void youtubeTesti(){

        driver.get("http://www.youtube.com");

        String expectedUrlIcerik="youtube";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAİLED");


    }



    @Test
    public void testOtomasyonu(){


        driver.get("http://www.testotomasyonu.com");

        String expectedUrlIcerik="testotomasyonu";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAİLED");



    }



    @Test
    public void wisequarterTesti(){


        driver.get("http://www.wisequarter.com");

        String expectedUrlIcerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("wisequarter testi PASSED");
        }else System.out.println("wisequarter testi FAİLED");



    }

}
