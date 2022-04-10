package grafana.testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;

public class TestDB {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:postgresql://eba-ks01:5432/bmx_arc";
		String username="bmx_copy";
		String password="bmx_copy";

		try {
			
			System.out.println("Connecting to the Database");
			Connection myConnection=DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection successful!!");
			myConnection.close();
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		

	}

	
	
	


	
}
