package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.*;

import Constants.ConstantsData;

public class SaveCustomerId {

    public static void writeCustomerId(String custId) throws IOException {

        System.out.println("custid in utility: " + custId);

        FileInputStream fis = new FileInputStream(ConstantsData.EXCEL_PATH_CUSTOMER_ID);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("CustomerData");

        if (sheet == null) {
            sheet = workbook.createSheet("CustomerData");
        }

        // Create ONE row only
        XSSFRow row = sheet.getRow(1);
        if (row == null) {
            row = sheet.createRow(1);
        }

        // ===== DATE CELL =====
        XSSFCell dateCell = row.createCell(0);

        LocalDate today = LocalDate.now();
        Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());

        CellStyle dateStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        dateStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("dd-MM-yyyy")
        );

        dateCell.setCellValue(date);
        dateCell.setCellStyle(dateStyle);

        // ===== CUSTOMER ID CELL =====
        XSSFCell idCell = row.createCell(1);
        idCell.setCellValue(custId);

        FileOutputStream fos = new FileOutputStream(ConstantsData.EXCEL_PATH_CUSTOMER_ID);
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();
    }
    
    public static String fetchCustomerId() throws IOException {

        FileInputStream fis = new FileInputStream(ConstantsData.EXCEL_PATH_CUSTOMER_ID);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("CustomerData");

        if (sheet == null) {
            workbook.close();
            fis.close();
            return null;
        }

        XSSFRow row = sheet.getRow(1);
        if (row == null) {
            workbook.close();
            fis.close();
            return null;
        }

        XSSFCell idCell = row.getCell(1);
        if (idCell == null) {
            workbook.close();
            fis.close();
            return null;
        }

        String customerId = idCell.getStringCellValue();

        workbook.close();
        fis.close();

        return customerId;
    }
}
