package day05_assertions_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C06_DropdownList extends TestBase_BeforeAfter {

    @Test
    public void dropdownTest(){

        //testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com/form");


        //dogum tarihi gun acilir menusunden 5'i secin



        //dropdown menu ile calismak icin
        // 1- once uzerinde calisacagimiz dropdown'i locate edip kaydedelim


        WebElement gunacilirMenu=driver.findElement(By.xpath("//select[@class='form-control'])[1]"));
        //2-Select class'indaki method'lari kullanabilmek icin bir obje olusturalim
        // obje olustururken uzerinde calisacagimiz dropdown'i parametre olarak girelim

        Select select=new Select(gunacilirMenu);

        //3-select objesi ile istenen method'lar kullanılabilir
        select.selectByIndex(5);
        ReusableMethods.bekle(2);

        // ve 5 'in secili oldugunu test edelim


        String expectedSecilenDeger="5";
        String actualSecilenDeger=select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedSecilenDeger,actualSecilenDeger);

        // menu'de toplam 32 secenek oldugunu test edin

        int expectedSeceneksayisi=32;

        int actualSecenekSayisi=select.getOptions().size();

        Assert.assertEquals(expectedSeceneksayisi,actualSecenekSayisi);




    }


}
