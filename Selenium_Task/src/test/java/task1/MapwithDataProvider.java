package task1;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.HashMap;

public class MapwithDataProvider {

    @Test(dataProvider="TestData")
    public void Test(Map<Object,Object> mapdata){

        System.out.println("--------------Test Started------------");
        System.out.println(mapdata.get("UserName"));
        System.out.println(mapdata.get("Password"));
        System.out.println(mapdata.get("DoB"));
        System.out.println("--------------Test Ended--------------");
    }

    @DataProvider(name = "TestData")
    public Object[][] DataProviderMethod() throws Exception{
        String filepath = "/home/ttn/Downloads/TestData.xlsx";
        File file = new File(filepath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowcount = sheet.getLastRowNum();
        int colcount = sheet.getRow(0).getLastCellNum();
        wb.close();

        //define object array to return
        Object[][] obj= new Object[rowcount][1];
        //define map
        for(int i =0; i<rowcount;i++){

            Map <Object,Object> datamap = new HashMap<>();

            for(int j=0;j<colcount;j++){
                datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());

            }
            obj[i][0]=datamap;
        }
        return obj;


        }

    }

