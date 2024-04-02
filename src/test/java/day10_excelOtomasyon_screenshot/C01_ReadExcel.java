package day10_excelOtomasyon_screenshot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {


        String dosyaYolu="src/test/java/day10_excelOtomasyon_screenshot/ulkeler.xlsx";

        //2-dosyadaki bilgileri alabilmek icin file input stream olusturmaliyiz

        FileInputStream fis=new FileInputStream(dosyaYolu);

        //3 - fiziki excel'den okunan bilgileri
        //    class'imizda kullanabilmemiz icin
        //    class icinde o bilgileri excel formatinda kullanabilecek bir objeye yuklemeliyiz


        Workbook workbook = WorkbookFactory.create(fis);

       Sheet sayfa1= workbook.getSheet("Sayfa1");

        Row satir2 = sayfa1.getRow(2);

        Cell sati2ucuncuData= satir2.getCell(3);

        System.out.println(sati2ucuncuData);

    }
}
