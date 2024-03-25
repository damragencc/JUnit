package day04_JunitFrameworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_AyarlarıMethodOlarakYapma {
    WebDriver driver;

    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }
    public void teardowm(){

        ReusableMethods.bekle(2);
        driver.quit();
    }


    @Test
    @Ignore
    public void youtubeTesti(){
         setUp();
        driver.get("http://www.youtube.com");

        String expectedUrlIcerik="youtube";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAİLED");

        teardowm();
    }



    @Test
    public void testOtomasyonu(){
        setUp();

        driver.get("http://www.testotomasyonu.com");

        String expectedUrlIcerik="testotomasyonu";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAİLED");

      teardowm();

    }



    @Test
    public void wisequarterTesti(){
       setUp();

        driver.get("http://www.wisequarter.com");

        String expectedUrlIcerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("wisequarter testi PASSED");
        }else System.out.println("wisequarter testi FAİLED");

     teardowm();

    }

}
