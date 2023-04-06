package Practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WritedatainDATABASE {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stu
		Connection con=null;
		int result=0;
		try {
		/*try {*/
			
			// Step 1:create Object from driver;
			
		Driver driver=new Driver();
		//register the database;
		DriverManager.registerDriver(driver);
		//get connection for the database
	  con =DriverManager.getConnection("jdbc:mysql://localhost:3306/LIM","root","root");
	  //Create the statement
	 Statement  state =con.createStatement();
	 String query="INSERT INTO LIFE values('rajeev',1,'RAJ',60);";
	 //execute Query
	 
	 result=state.executeUpdate(query);

		}
		catch(Exception e)
		{
			
		}
	 finally {
		 if(result==1)
		 {
			 System.out.println("data updated");
			 
		 }
		 else
		 {
			 System.err.println("data not updated");
		 }
		 
		 con.close();
		}
	}
}


	


