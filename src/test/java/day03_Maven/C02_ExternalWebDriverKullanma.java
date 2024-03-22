package day03_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_ExternalWebDriverKullanma {
    public static void main(String[] args) throws InterruptedException {


        // Eger calistigimiz sirket bize Selenium WebDriver disinda
        // baska bir Webdriver verirse onu da projemize ekleyebiliriz


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        driver.get("https://www.testotomasyonu.com");

        ReusableMethods.bekle(3);
        driver.quit();


    }
}
