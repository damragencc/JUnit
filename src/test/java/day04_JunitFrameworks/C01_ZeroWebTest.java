package day04_JunitFrameworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ZeroWebTest {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");





        // 2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();




        //3. Login alanine  “username” yazdirin
        WebElement usernameKutusu= driver.findElement(By.id("user_login"));
        usernameKutusu.sendKeys("username");




        //4. Password alanina “password” yazdirin
        WebElement userpaswword= driver.findElement(By.id("user_password"));
        userpaswword.sendKeys("password");




        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();



        //6. Back tusu ile sayfaya donun
        driver.navigate().back();



        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();




        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
       driver.findElement(By.id("sp_amount")).sendKeys("200");



        //9. tarih kismina “2023-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2024-03-22");

        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        ReusableMethods.bekle(1);

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement paymentSuccessElementi=driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));


        if (paymentSuccessElementi.isDisplayed()){
            System.out.println("Test PASSED");

        }else System.out.println("Test FAİLED");

        ReusableMethods.bekle(2);
        driver.quit();

    }
}
