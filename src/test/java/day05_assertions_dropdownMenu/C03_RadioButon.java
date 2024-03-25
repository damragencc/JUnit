package day05_assertions_dropdownMenu;

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

public class C03_RadioButon {

    // a. Verilen web sayfasına gidin.
    //      https://testotomasyonu.com/form
    // b. Cinsiyet Radio button elementlerini locate edin
    // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterClass

    public static void teardown() throws InterruptedException {

        Thread.sleep(300);
        driver.quit();
    }

    @Test
    public void Test01(){

        // a. Verilen web sayfasına gidin.
        //      https://testotomasyonu.com/form

        driver.get(" https://testotomasyonu.com/form");


    }

    @Test
    public void cinsiyet(){

        WebElement kadınYazi= driver.findElement(By.xpath("//*[@for='inlineRadio1']"));

        WebElement erkekYazi= driver.findElement(By.xpath("//*[@for='inlineRadio2']"));

        WebElement digerYazi= driver.findElement(By.xpath("//*[@for='inlineRadio3']"));


        erkekYazi.click();


        WebElement kadınCheckbox= driver.findElement(By.xpath("//*[@id='inlineRadio1']"));

        WebElement erkekChechbox= driver.findElement(By.xpath("//*[@id='inlineRadio2']"));

        WebElement digerCheckbox= driver.findElement(By.xpath("//*[@id='inlineRadio3']"));


        Assert.assertTrue(erkekChechbox.isSelected());

        Assert.assertFalse(kadınCheckbox.isSelected());

        Assert.assertFalse(digerCheckbox.isSelected());



    }




}
