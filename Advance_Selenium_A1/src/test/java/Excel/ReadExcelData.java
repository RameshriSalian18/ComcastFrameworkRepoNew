package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// Step 1: Get Excel path location -> get location address from properties
		
		FileInputStream fis = new FileInputStream("C:\\Read Excel File\\ReadData.xlsx");
		
		// Step 2: Open Workbook in read mode
		
		Workbook wb= WorkbookFactory.create(fis);
		
		//Step 3: Get the control of the "sheet1" sheet.
		
		Sheet sh = wb.getSheet("Sheet1");
		
		// Step 4: Get the control of the 2nd  row
		
		Row row = sh.getRow(2);
		
		// Step 5: Get the control of the "1st" cell and read string data
		
		Cell cel =row.getCell(1);
		String str = cel.getStringCellValue();
		System.out.println(str);
		
		//Step 6 : Close workbook
		
		wb.close();
		
		
	
	
	}

}
