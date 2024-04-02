package day10_excelOtomasyon_screenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // goreve baslamadan once, datalarin oldugu sayfaya ulasalim

        String dosyaYolu = "src/test/java/day10_excelOtomasyon_screenshot/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sayfa1 = workbook.getSheet("Sayfa1");


        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim

        System.out.println(sayfa1.getRow(0).getCell(1));

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String satir1data2 = sayfa1.getRow(0).getCell(1).getStringCellValue();

        System.out.println(satir1data2);

        // - 2.satir 4.cell’in afganistan’in baskenti "kabil" oldugunu test edelim

        String expectedData = "Kabil";
        String actualData = sayfa1.getRow(1).getCell(3).getStringCellValue();

        Assert.assertEquals(actualData, expectedData);

        // - Satir sayisini bulalim

        System.out.println(sayfa1.getLastRowNum()); // bize son satirin index'ini verir

        // -Fiziki olarak kullanilan satir sayisini bulun

        System.out.println(sayfa1.getPhysicalNumberOfRows());

        // Sayfa2'deki son satir index'ini ve fiziki olarak kullanilan satir sayisini yazdirin

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum()); //19
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());//8

        //bos satirlari saymaz, sadece data iceren satir sayisini yazdrir

        //Sayfa2'deki 3.satir, 7.sutun'daki bilgiyi yazdirin

        System.out.println(workbook.getSheet("Sayfa2").getRow(3).getCell(6)); //null


        // Sayfa2'deki 5.satir, 2.sutun'daki bilgiyi yazdirin
        // System.out.println(workbook.getSheet("Sayfa2").getRow(4).getCell(1)); //NullPoinException

        // Sayfa2'deki 25.satir, 1.sutun'daki bilgiyi yazdirin

        // System.out.println(workbook.getSheet("Sayfa2").getRow(24).getCell(0));//nullPointExcepiton


        //Senegal'in turkce baskent isminin Dakar oldugunu test edin

        String expectedBasketnIsmi = "Dakar";
        String actualBaskentIsmi = "";

        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {

            //i bize satir numarsini getiriyor
            //biz o satirdaki ulke ismine bakip, Senegal ise ,baskenti kaydedelim


            if (sayfa1.getRow(i).getCell(0).toString().equals("Senegal")) {

                actualBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();


            }

        }

        Assert.assertEquals(actualBaskentIsmi, expectedBasketnIsmi);


        //ulkeler excelinde turkce baskent ismi Amsterdam olan bir ülke oldugunu test edin

        boolean amsterdamVarmi = false;

        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {

            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();

            if (satirdakiBaskentIsmi.equals("Amsterdam")) {
                amsterdamVarmi = true;


            }

        }

        Assert.assertTrue(amsterdamVarmi);


        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        // ulke ismi key, baskent value olsun

        Map<String, String> ulkeBaskentMap = new TreeMap<>();


        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {

            String satirdakiUlkeAdi = sayfa1.getRow(i).getCell(0).toString();
            String satirdakiBaskentAdi = sayfa1.getRow(i).getCell(3).toString();


            ulkeBaskentMap.put(satirdakiUlkeAdi, satirdakiBaskentAdi);

        }

        //Senegal'in turkce baskent isminin Dakar oldugunu test edin

        expectedBasketnIsmi = "Dakar";
        actualBaskentIsmi = ulkeBaskentMap.get("Senegal");

        Assert.assertEquals(expectedBasketnIsmi, actualBaskentIsmi);


        //ulkeler excelinde turkce baskent ismi Amsterdam olan bir ulke oldugunu test edin

        Assert.assertTrue(ulkeBaskentMap.containsValue("Amsterdam"));

        // Baskent ismi A ile baslayan ulke isimlerini yazdirin

        Set<String> ulkeIsımleriSeti = ulkeBaskentMap.keySet();

        for (String eachUlke : ulkeIsımleriSeti

        ) {

            if (ulkeBaskentMap.get(eachUlke).startsWith("A")) {

                System.out.println(eachUlke + " - " + ulkeBaskentMap.get(eachUlke));
            }

        }
    }
}