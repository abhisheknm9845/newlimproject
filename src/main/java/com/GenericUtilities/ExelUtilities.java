package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtilities {
	/**
	 * This method usedto readthe data from the Exel Sheet
	 * @author Dell
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */

	public String readdataFromExel(String SheetName, int RowNo, int ColumnNo ) throws Throwable, Throwable
	{
		/**
		 *
		 */
		FileInputStream fi = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(RowNo).getCell(ColumnNo).getStringCellValue();
		return value;
		

	}
	/**
	 * This method is used to get Lastrownumber
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	/**
	 * This method used to write data into exel Sheet
	 * @author Dell
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 * @throws IOException
	 */
	public void writedataIntoExel(String SheetName, int RowNo, int ColumnNo, String data) throws Throwable, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		sh.getRow(RowNo).createCell(ColumnNo).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(IPathConstants.ExelPath);
		wb.write(fout);
	}
	/**
	 * This Method Used to read Multiple data
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String>readMultipleData(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String,String>();
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	public Object[][] readmultiplesetdata(String Sheetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int lastrow = sh.getLastRowNum()+1;
		short lastcell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}

}
