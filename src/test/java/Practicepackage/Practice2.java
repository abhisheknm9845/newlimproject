package Practicepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Practice2 {

	public static void main(String[] args) throws IOException   {
	FileInputStream	fis =new FileInputStream("./src/test/resources/commondata.properties");
     Properties	obj =new Properties();
     obj.load(fis);
String b=obj.getProperty("browser");
String ul =obj.getProperty("url");
 String un =obj.getProperty("username");
  String pw=obj.getProperty("password");
  
  System.out.println(b);
  System.out.println(ul);
  System.out.println(un);
  System.out.println(pw);
  

	}

}
