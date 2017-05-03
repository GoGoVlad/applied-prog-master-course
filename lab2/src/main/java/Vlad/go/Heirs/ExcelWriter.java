package Vlad.go.Heirs;

import Vlad.go.AbstractWriter;
import Vlad.go.SomeModels.Class1;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter extends AbstractWriter {
    public void write (Class1 context) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Lab 2");

        Object[] [] bookData = {
                {context.getId(), context.getName()},
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }
        try (FileOutputStream outputStream = new FileOutputStream( "TestExcel.xlsx")) {
            workbook.write(outputStream);
            System.out.println(System.getProperties().getProperty("user.dir") + "TestExcel.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
