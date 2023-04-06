package Practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Readmultipledatafromdatabase {
	
	
		
public static void main(String[] args) throws Throwable {
		
	Connection con=null;
	
	try {
		
		// Step 1:create Object from driver;
		
	Driver driver=new Driver();
	//register the database;
	DriverManager.registerDriver(driver);
	//get connection for the database
  con =DriverManager.getConnection("jdbc:mysql://localhost:3306/LIM","root","root");
  //Create the statement
 Statement  state =con.createStatement();
 String query="select * from LIFE;";
 //execute Query
 
ResultSet  result = state.executeQuery(query);
while(result.next())
{
	System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
	
}
	}
	catch(Exception e)
	{
		
	}
 finally {
	 con.close();
	}
}
}


		



	 
 


	
	

	


