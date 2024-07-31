package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;


public class SampleTest {

	@Test
	public void testDB() throws ClassNotFoundException, SQLException {
		
		System.out.println("Database Testing");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nexxvalistudents", "root", "kujara");
		System.out.println("Connected to MySQL Database");
		
		Statement smt = connection.createStatement();
		System.out.println("Statement Created");
		
		ResultSet result = smt.executeQuery("select * from students");
		System.out.println("*******Printing Result*******");
		
		while(result.next()) {
			
			System.out.println(result.getString("id") + " " + result.getString("name") + " " + result.getString("fees") + " " + result.getString("class") + result.getString("section") + " " + result.getString("house"));
		}
		
		
	}
	
}
