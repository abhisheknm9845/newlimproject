package Practicepackage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.IPathConstants;

public class EXeltoDataProviderdataFetch {
	@DataProvider
	public Object[][] data() throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("DP");
	int Lastrow = sh.getLastRowNum()+1;
	short Lastcell = sh.getRow(0).getLastCellNum();
	
	Object[][] obj=new Object[Lastrow][Lastcell];
	
	//cretearray
	for(int i=0;i<Lastrow;i++)//row
	{
	
		
		for(int j=0;j<Lastcell;j++)//col
		{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
	}

}
