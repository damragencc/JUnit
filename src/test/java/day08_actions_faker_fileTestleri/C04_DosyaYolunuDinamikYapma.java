package day08_actions_faker_fileTestleri;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase_BeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_DosyaYolunuDinamikYapma extends TestBase_BeforeAfter {
      @Test
    public void test01(){

        //Masaustunde logo.png dosyasinin oldugunu test edin

        String dosyaYolu="/Users/macbook/Desktop/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        //Dosya yolu yukaridaki gibi yazilirsa

        // sadece o bilgisayarda calisir

        // testin tum bilgisayarlarda calisabilmesi icin
          //dosya yolunu dinamik yapmamiz gerekir

          System.out.println(System.getProperty("user.home"));

          // /Users/macbook
          //bu kod bize bilgisayarımızdaki kullanicinin dosya yolunu verir

          System.out.println(System.getProperty("user.dir"));

          // /Users/macbook/IdeaProjects/team135-Junit

          // icinde calistigimiz projenin dosya yolunu verir


          /*
               Masaustundeki dosyanin dosya yolu :



               /Users/macbook             /Desktop/logo.png

              bana ozel kisim
       System.getProperty("user.home"       herkeste ayni

           */


          String dinamikDosyaYolu = System.getProperty("user.home") + "/Desktop/logo.png";
          Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));



          //day08 package'inda deneme.txt dosyasinin oldugunu test edin
          dosyaYolu="/Users/macbook/IdeaProjects/team135-Junit/src/test/java/day08_actions_faker_fileTestleri/deneme.txt";

          Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


          dinamikDosyaYolu= System.getProperty("user.dir")+"/src/test/java/day08_actions_faker_fileTestleri/deneme.txt";

          Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));






    }
}
