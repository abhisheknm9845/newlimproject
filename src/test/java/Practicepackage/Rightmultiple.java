package Practicepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Rightmultiple {

	public static void main(String[] args) throws Throwable{
		// TODO Auto-generated method stub
		String[]org= {"TCS","infy","tech"};
		String[]loc= {"t","y","p"};
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\EXEL.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rcount=2;
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
