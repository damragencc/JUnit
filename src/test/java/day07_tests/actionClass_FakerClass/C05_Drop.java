package day07_tests.actionClass_FakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C05_Drop extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");


        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement acceptableKutusu=driver.findElement(By.id("draggable2"));

        WebElement droptableKutusu=driver.findElement(By.id("droppable2"));

        Actions actions=new Actions(driver);
        ReusableMethods.bekle(1);

        actions.dragAndDrop(acceptableKutusu,droptableKutusu).perform();

        ReusableMethods.bekle(2);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

           WebElement droppedYaziElementi=driver.findElement(By.xpath("//*[text()='Dropped!']"));

        Assert.assertTrue(droppedYaziElementi.isDisplayed());

        //4- Sayfayi yenileyin

        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement notAcceptElementi=driver.findElement(By.xpath("//div[@id='draggable-nonvalid2']"));

        droptableKutusu=driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptElementi,droptableKutusu).perform();



        //6- “Drop Here” yazisinin degismedigini test edin

        WebElement dropHereelement=driver.findElement(By.xpath("//*[text()='Drop Here']"));

        Assert.assertTrue(dropHereelement.isDisplayed());
    }
}
