package day09_cookies;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        //1- amazon anasayfaya gidin

        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin

         Set<Cookie> CookiesSeti =driver.manage().getCookies();

         int index=1;

         for (Cookie eacCookie:CookiesSeti
         ){
             System.out.println(index+". cookie :  "+eacCookie);
             index++;
         }



        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int expectedcookie=5;

         int actualCokkie=CookiesSeti.size();

        Assert.assertTrue(actualCokkie>expectedcookie);



        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String expectedCookieDegeri="USD";

        String actualCookieDegeri=driver.manage().getCookieNamed("i18n-prefs").getValue();

        Assert.assertEquals(actualCookieDegeri,expectedCookieDegeri);


        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

        Cookie eklenecekCookie=new Cookie("en sevdigim cookie","cikolatalı");

        driver.manage().addCookie(eklenecekCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        CookiesSeti =driver.manage().getCookies();

        boolean cikolatalıCookieVarmı=false;

        for (Cookie eachCookie : CookiesSeti
        ){
            if (eachCookie.getValue().equals("cikolatali")){
                cikolatalıCookieVarmı=true;
                break;
            }
        }
 ReusableMethods.bekle(10);
        Assert.assertTrue(cikolatalıCookieVarmı);


        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        //8- tum cookie’leri silin ve silindigini test edin1- amazon anasayfaya gidin



    }
}
