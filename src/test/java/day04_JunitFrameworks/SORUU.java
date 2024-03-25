package day04_JunitFrameworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SORUU {


      static WebDriver driver;
    @BeforeClass
    public static void TestSetup(){

        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void teardown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void Test01(){

        //https://www.bestbuy.com/ Adresine gidin

        driver.get("https://www.bestbuy.com");

    }

    @Test
    public void sayfaEsit(){

        //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl="www.bestbuy.com";
        String actuarlurl= driver.getCurrentUrl();

        Assert.assertTrue(actuarlurl.contains(expectedUrl));

    }

    @Test
    public void Resticermedigi(){

        //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String expectedurl="Rest";
        String actuarlurl= driver.getCurrentUrl();

        Assert.assertFalse(actuarlurl.contains(expectedurl));

    }

    @Test
    public void Logo(){

        //	○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logo= driver.findElement(By.xpath("//*[text()='Français']"));
        logo.click();

    }






}


    //  farkli test method’lari olusturarak asagidaki testleri yapin
    //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //	○ logoTest => BestBuy logosunun görüntülendigini test edin
    //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin


