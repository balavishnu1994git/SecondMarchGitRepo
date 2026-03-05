package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constants.ConstantsData;

public class SaveAccountId {
	
	 public static void writeAccountID(String AccntId) throws IOException {

	        System.out.println("custid in utility: " + AccntId);

	        FileInputStream fis = new FileInputStream(ConstantsData.EXCEL_PATH_CUSTOMER_ID);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet("CustomerData");

	        if (sheet == null) {
	            sheet = workbook.createSheet("CustomerData");
	        }

	       

	        
	        // ===== CUSTOMER ID CELL =====
	        XSSFRow row = sheet.getRow(1);
	        XSSFCell idCell = row.createCell(2);
	        idCell.setCellValue(AccntId);

	        FileOutputStream fos = new FileOutputStream(ConstantsData.EXCEL_PATH_CUSTOMER_ID);
	        workbook.write(fos);      // work as a save button to ->to save last changes

	        workbook.close();
	        fis.close();
	        fos.close();
	    }
}
