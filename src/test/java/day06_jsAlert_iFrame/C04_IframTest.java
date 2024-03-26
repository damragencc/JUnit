package day06_jsAlert_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.AddHasCasting;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C04_IframTest extends TestBase_BeforeAfter {

    //1- https://testotomasyonu.com/discount adresine gidin
    //2- Elektronics Products yazisinin gorunur olduğunu test edin
    //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
    //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin
    //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
    //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin
    //7- Sayfayi kapatin

    @Test
    public void ElectonicTest(){

        //1- https://testotomasyonu.com/discount adresine gidin

        driver.get("https://testotomasyonu.com/discount ");


        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        // once elektronics products'in icinde oldugu ifram'e gecis yapalım
        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));
        driver.switchTo().frame(electronicsIframe);



        WebElement elektonicYazısi=driver.findElement(By.xpath("//h2[text()='Electronics Products']"));

        Assert.assertTrue(elektonicYazısi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        WebElement Dellpc= driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"));

        String expectedGorunur="DELL Core I3 11th Gen";
        String actualYazi=Dellpc.getText();

        Assert.assertEquals(actualYazi,expectedGorunur);

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin

        // urunler baska bir iframe icinde oldugundan, once o iframe'e gecis yapalim
        // ANCAK ustteki testleri sol bolumde bulunan farkli bir iframe'de yapmistik
        // sagdaki iframe'i locate etmeye calismadan once,
        // gecis yaptigimiz soldaki iframe'den, anasayfaya donmeliyiz

        driver.switchTo().defaultContent();

        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[2]"));
        driver.switchTo().frame(fashionIframe);

        List<WebElement> menSlimFitElementler = driver.findElements(By.xpath("//p[contains(text(),'Men Slim Fit')]"));

        Assert.assertTrue(menSlimFitElementler.size()>0);


        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin

        WebElement yazdiGorunur=driver.findElement(By.xpath("//*[text()='Fashion']"));

        String expectedYazi="Fashion";
        String actualYazii=yazdiGorunur.getText();

        Assert.assertEquals(expectedYazi,actualYazii);

        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        driver.switchTo().defaultContent();

        WebElement hereAreSomeProductsElementi= driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreSomeProductsElementi.isDisplayed());






    }
}
