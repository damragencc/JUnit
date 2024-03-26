package day06_jsAlert_iFrame;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase_BeforeAfter;

public class C05_SwitchingWindow extends TestBase_BeforeAfter {

    @Test
    public void windowtesti(){

        driver.get("https://testotomasyonu.com");

        System.out.println(driver.getWindowHandle());

        //electronic linkine click yapalim

        driver.findElement(By.linkText("Electronics")).click();

        System.out.println(driver.getWindowHandle());

        //wisequarter anasayfaya gidelim


        driver.get("https://wisequarter.com");
        System.out.println(driver.getWindowHandle());


    }
}
