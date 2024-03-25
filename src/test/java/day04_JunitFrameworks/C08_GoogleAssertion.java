package day04_JunitFrameworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_GoogleAssertion {


    @Test
    public void GoogleTesti() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //2- https://www.google.com/ adresine gidin

        driver.get("http://www.google.com");

        //3- cookies uyarisini kabul ederek kapatin

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String extected="google";
        String actualy= driver.getCurrentUrl();

        Assert.assertTrue("icermiyor",actualy.contains(extected));


        //5- Arama cubuguna “Nutella” yazip aratin

        WebElement aramaKutusu=driver.findElement(By.id("APjFqb"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);


        //6- Bulunan sonuc sayisini yazdirin

        WebElement sonuc=driver.findElement(By.id("result-stats"));
        System.out.println(sonuc.getText());


        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String[] sonucYaziArr = sonuc.getText().split(" ");

        String sonucSayisiStr = sonucYaziArr[1]; // 149.000.000

        int actualSonucSayisiInt = Integer.parseInt(sonucSayisiStr.replaceAll("\\D",""));
        int expectedMinSonucSayisi = 10000000;

        Assert.assertTrue("sonuc sayisi 10 milyondan az", actualSonucSayisiInt>expectedMinSonucSayisi);


        // String[] sonucYaziArr=sonuc.getText().split("");
        //String sonucSayi=sonucYaziArr[1];

       // System.out.println(sonucSayi);

       //int actualSonucSayisiInt=Integer.parseInt(sonucSayi.replaceAll("\\D",""));
        //int expectedMinSonucSayisi=1000000;

        //Assert.assertTrue("10 milyondan daha az",actualSonucSayisiInt>expectedMinSonucSayisi);




        //8- Sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();


    }


}
