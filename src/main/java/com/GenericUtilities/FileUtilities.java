package com.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtilities {

	public String readDataFromPropertyFile(String key) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
		

	}

}
