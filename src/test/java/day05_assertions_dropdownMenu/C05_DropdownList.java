package day05_assertions_dropdownMenu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeAfter;

public class C05_DropdownList extends TestBase_BeforeAfter {


    @Test
    public void dropdownTesti(){

        /*
            Dropdown menu ozel bir acilir menudur
            select tag'i ile olusturulur
            icindeki secenekler de option tag'i ile olusturulur
            ve genellikle option tag'i icinde value attribute'u
            ve webElement'in text'i olur

            Selenium dropdown menu icin ozel
            Select class'i olusturmustur
            biz de Selecet class'indan
         */

        //testotomasyonu anasayfaya gidin
        //dogum tarihi gun acilir menusunden 5'i secin
        //ve 5'in secili oldugunu test edin


        driver.get("https://www.testotomasyonu.com/form");

        //dogum tarihi gun acilir menusunden 5'i secin

        WebElement gunacilirMenu=driver.findElement(By.xpath("//select[@class='form-control'])[1]"));

        Select selectgun=new Select(gunacilirMenu);
        selectgun.selectByIndex(5);

        gunacilirMenu.sendKeys("5");



        //ve 5'in secili oldugunu test edin
    }


}
