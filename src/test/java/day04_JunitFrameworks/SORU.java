package day04_JunitFrameworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class SORU {

    //1. “https://www.saucedemo.com” Adresine gidin
    // 2. Username kutusuna “standard_user” yazdirin
    // 3. Password kutusuna “secret_sauce” yazdirin
    // 4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin 9. Sayfayi kapatin


    @Test
    public void Test() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. “https://www.saucedemo.com” Adresine gidin

        driver.get("http://www.saucedemo.com");

        Thread.sleep(2000);

        // 2. Username kutusuna “standard_user” yazdirin

        WebElement aramaKutusu= driver.findElement(By.id("user-name"));

        aramaKutusu.sendKeys("standard_user"+ Keys.ENTER);

        // 3. Password kutusuna “secret_sauce” yazdirin

        WebElement paswordKutusu= driver.findElement(By.id("password"));
        paswordKutusu.sendKeys("secret_sauce"+Keys.ENTER);

        Thread.sleep(2000);

        // 4. Login tusuna basin

        WebElement loginKutu=driver.findElement(By.id("login-button"));
        loginKutu.click();

        Thread.sleep(2000);


        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement urun=driver.findElement(By.id("item_4_title_link"));
        urun.click();

        //6. Add to Cart butonuna basin

        WebElement urunButuno=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        urunButuno.click();

        ReusableMethods.bekle(2);



        //7. Alisveris sepetine tiklayin

        WebElement sepet= driver.findElement(By.id("shopping_cart_container"));
        sepet.click();

        ReusableMethods.bekle(2);


        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin 9. Sayfayi kapatin



        WebElement urunKontrol= driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));

        Assert.assertTrue(urunKontrol.isDisplayed());

        ReusableMethods.bekle(2);


        Thread.sleep(2000);
        driver.quit();












    }
}
