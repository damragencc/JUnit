package day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileUpload extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");


        //2.chooseFile butonuna basalim

        //3.Package icindeki deneme.txt dosyasini secelim

        //bilgisarimizda bulunan dosyalara webDriver ile ulasamayacagimiz icin
        //chooseFile butonuna yuklemek istedigimiz dosyanin
        //dosya yolunu yollamamiz yeterli olacaktir

        ///Users/macbook/IdeaProjects/team135-Junit/src/test/java/day08_actions_faker_fileTestleri/deneme.txt"

        String dinamikDosyaYolu=System.getProperty("user.dir")+"/src/test/java/day08_actions_faker_fileTestleri/deneme.txt";


        WebElement chooseFile=driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys(dinamikDosyaYolu);


        //4.Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadyaziElementi=driver.findElement(By.tagName("h3"));

        String expectedYazi="File Uploaded!";

        String actualYazi=fileUploadyaziElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi);


        ReusableMethods.bekle(3);
    }
}
