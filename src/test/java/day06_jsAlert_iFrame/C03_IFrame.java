package day06_jsAlert_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

public class C03_IFrame extends TestBase_BeforeAfter {

    //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
    // - Text Box’a “Merhaba Dunya!” yazin.
    // - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin ve  yazisini konsolda yazdirin.


    @Test
    public void iframe(){

        driver.get("https://the-internet.herokuapp.com/iframe");

        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement yazielementi=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(yazielementi.isEnabled());

        System.out.println(yazielementi.getText());

        // - Text Box’a “Merhaba Dunya!” yazin.

        /*
           -
         */



        WebElement yaziYazdir=driver.findElement(By.xpath("//*[@id='tinymce']"));

        yaziYazdir.sendKeys("Merhaba Dunya");

        // - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin ve  yazisini konsolda yazdirin.

        driver.switchTo().parentFrame();

        WebElement gorunurlukKontrol= driver.findElement(By.linkText("Elemental Selenium"));

        Assert.assertTrue(gorunurlukKontrol.isEnabled());
        System.out.println(gorunurlukKontrol.getText());






    }

}
