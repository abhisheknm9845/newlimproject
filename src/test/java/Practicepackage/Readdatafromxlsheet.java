package Practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatafromxlsheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
	FileInputStream	fis = new FileInputStream(".\\src\\test\\resources\\Datadriven.xlsx");
    Workbook wb=WorkbookFactory.create(fis);
   Sheet sh = wb.getSheet("Sheet1");
   Row r = sh.getRow(1);
   Cell c = r.getCell(0);
   String result = c.getStringCellValue();
   System.out.println(result);
 


 
	

	}

}
