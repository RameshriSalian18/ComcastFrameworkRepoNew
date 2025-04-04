package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultiDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("‪‪./TestData/ReadData.xlsx" );
		Workbook wb = WorkbookFactory.create(fis);
	    
		Sheet sh = wb.getSheet("Sheet1");
	    
	    int rowCount = sh.getLastRowNum();
	    
		for (int i=1; i<=rowCount ; i++) {
	    	Row row =  sh.getRow(i);
	    	
	    	String columndata1 = row.getCell(0).toString();
	    	String columndata2 = row.getCell(1).toString();
	    	System.out.println(columndata1 + "\t" + columndata2) ;
	    }
   
	    wb.close();

	}

	

}
