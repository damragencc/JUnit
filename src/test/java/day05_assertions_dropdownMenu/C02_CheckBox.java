package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.time.Duration;

public class C02_CheckBox extends TestBase_BeforeAfter {

    // a. Verilen web sayfasına gidin.
    //     https://testotomasyonu.com/form
    // b. Sirt Agrisi ve Carpinti checkbox’larini secin
    // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    // d. Seker ve Epilepsi checkbox’larininin seçili





    @Test
    public void checkboxTesti() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sirtAgrisiCheckbox = driver.findElement(By.id("gridCheck5"));
        WebElement sirtAgrisiYaziElementi= driver.findElement(By.xpath("//label[@for='gridCheck5']"));

        WebElement carpintiCheckbox = driver.findElement(By.id("gridCheck4"));
        WebElement carpintiYaziElementi= driver.findElement(By.xpath("//label[@for='gridCheck4']"));

        // sirt agrisini yazidan secelim, carpintiyi ise checkbox'dan secelim
        sirtAgrisiYaziElementi.click();
        carpintiCheckbox.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
       Assert.assertTrue(sirtAgrisiCheckbox.isSelected());
        Assert.assertTrue(carpintiCheckbox.isSelected());


        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement sekerCheckbox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox = driver.findElement(By.id("hastalikCheck7"));

        Assert.assertFalse(sekerCheckbox.isSelected());
        Assert.assertFalse(epilepsiCheckbox.isSelected());

        ReusableMethods.bekle(3);

    }

}
