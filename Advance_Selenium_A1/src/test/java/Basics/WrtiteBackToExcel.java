package Basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WrtiteBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// Step 1: To open and get excel path location
		
		FileInputStream fis = new FileInputStream("./TestData/ReadData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(0);
		Cell cel = row.createCell(1);
		cel.setCellType(CellType.STRING);
		cel.setCellValue("Passing Students Name");
		
		FileOutputStream fos = new FileOutputStream("./TestData/ReadData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Executed");
		

	}

	

}
