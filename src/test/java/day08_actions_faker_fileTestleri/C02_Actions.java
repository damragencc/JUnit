package day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C02_Actions extends TestBase_BeforeAfter {

    @Test
    public void test01(){
   /*
            Bazi web sayfalari
            gorunmeyen webelementleri locate etmemize izin verir, bazilari izin vermez

            Eger gorunmeyen bir elementi locate etmemize izin veriyorsa
            asagiya inmek icin
            actions.scrollToElement(iframeElementi); kullanabiliriz,

            Eger izin vermiyorsa, locate edemedigimiz bir webelementi
            hedef olarak actions objesine veremeyiz
            bu durumda
            actions.sendKeys(Keys.PAGE_DOWN);
            actions.sendKeys(Keys.ARROW_DOWN);
            tuslari ile istenen bolgeye inebiliriz
            Ancak bilgisayardan bilgisayara cozunurluk degistigi icin
            bu test tum bilgisayarlarda calismayabilir
         */

        //1- https://html.com/tags/iframe/ sayfasina gidelim
        //2- video’yu gorecek kadar asagi inin
        //actions.scrollToElement(iframeElementi);
        //3- videoyu izlemek icin Play tusuna basin
        //4- videoyu calistirdiginizi test edin
        driver.get("https://html.com/tags/iframe/");

        //2- video’yu gorecek kadar asagi inin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement iframeElementi =driver.findElement(By.xpath("(//iframe)[1]"));


        driver.switchTo().frame(iframeElementi);

        ReusableMethods.bekle(2);




        //3- videoyu izlemek icin Play tusuna basin

        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();



        //4- videoyu calistirdiginizi test edin

        WebElement playOynat= driver.findElement(By.xpath("//*[@aria-label='Duraklat klavye kısayolu k']"));

        Assert.assertTrue(playOynat.isEnabled());

        ReusableMethods.bekle(2);




    }

    }