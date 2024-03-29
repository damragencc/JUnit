package day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist extends TestBase_BeforeAfter {

    @Test
    public void Test01(){


        //1. https://the-internet.herokuapp.com/download adresine gidelim.

        driver.get("https://the-internet.herokuapp.com/download");
        //2. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='logo.png']")).click();
        ReusableMethods.bekle(2);

        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        //java ile bir dosyanin dbilgisayarımız daoldugunu test etmek icin
        // o dosyanin dosya yoluna ihtiyac duyar

        String dosyaYolu="/Users/macbook/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //masaustunde logo.png dosyasinin oldugunu test edelim

        dosyaYolu="/Users/macbook/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
