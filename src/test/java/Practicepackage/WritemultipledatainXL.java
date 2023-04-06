package Practicepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritemultipledatainXL {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		String []org= {"tesla","microsoft"};
		String[]loc= {"amaerika","afrika"};
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\EXEL.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rcount=11;
		for(int i=0;i<org.length;i++)
		{
			System.out.println(org[i]+" "+loc[i]);
			sh.createRow(rcount).createCell(0).setCellValue(org[i]);
			sh.getRow(rcount).createCell(1).setCellValue(loc[i]);
			FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\EXEL.xlsx");
			wb.write(fout);
			rcount++;
		}
		
		

	}

}
