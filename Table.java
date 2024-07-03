package curdOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Table {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";

	private static final String username = "root";
	private static final String  password = "root";
public static void main(String[] args) {
	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  database name");
	     String url ="jdbc:mysql://localhost:3306/" + sc.next();
		Class.forName(Driver);
		Connection conn = DriverManager.getConnection(url, username,password);
		System.out.println("Enter the table name");
		String sql = "create table " + sc.next() + " (id int , name varchar(30), email varchar(30))";
		PreparedStatement pmst = conn.prepareStatement(sql);
		 int i = pmst.executeUpdate();
		 if (i>0) {
			 System.out.println("table is created");
		 }
		 else {
			 System.out.println("table is not created");
		 }
		conn.close();
		pmst.close();
		sc.close();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
