package day07_tests.actionClass_FakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C04_SagClick extends TestBase_BeforeAfter {

    @Test
    public void test01(){


        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin

        driver.get("https://the-internet.herokuapp.com/context_menu ");


        //3- Cizili alan uzerinde sag click yapin

        WebElement ciziliAlan=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan);


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedYazi,actualYazi);


        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
      driver.findElement(By.linkText("Elemental Selenium")).click();


        //7- Acilan sayfada h1 taginda “Elementel Selenium” yazdigini test edelim,

        ReusableMethods.switchWindow(driver,"https://elementalselenium.com/");

        String expectedYazii="Elemental Selenium";
        String actualYazii=driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();


        Assert.assertTrue(actualYazii.contains(expectedYazii));





    }
}
