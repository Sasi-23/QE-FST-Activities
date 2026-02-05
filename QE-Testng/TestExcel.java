package demos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExcel {

    @DataProvider(name = "excelData")
    public Iterator<Object[]> getExcelData() throws IOException {
        List<Object[]> data = new ArrayList<>();
        String excelPath = "src/test/resources/input.xlsx";

        try (FileInputStream fis = new FileInputStream(excelPath)) {
            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if(row == null) continue;
                
                String[] rowData = new String[row.getLastCellNum()];
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    rowData[j] = formatter.formatCellValue(row.getCell(j));
                }
                data.add(rowData);
            }
            workbook.close();
        }
        return data.iterator();
    }

    @Test(dataProvider = "excelData")
    public void verifyUserDetails(String username, String role, String status) {
        System.out.println("Testing user: " + username + " | Role: " + role + " | Status: " + status);
    }

}