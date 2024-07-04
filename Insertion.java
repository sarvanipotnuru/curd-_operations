package curdOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insertion {
	public class database {
		private static final String URL ="jdbc:mysql://localhost:3306/basex";
		private static final String username = "root";
		private static final String password = "root";
		private static final String Driver = "com.mysql.cj.jdbc.Driver";
		private static PreparedStatement pmst;
		 private static Connection con;
	  public static void main(String[] args) {
		  
		  try {
			  
			  Scanner sc = new Scanner(System.in);
		Class.forName(Driver);
		con = DriverManager.getConnection(URL, username,password);
	    String sql = "insert into  shivani(id,name,email) values(?,?,?)";
		
		pmst = con.prepareStatement(sql);
		System.out.println("Enter the id");
		pmst.setInt(1, sc.nextInt());
		System.out.println("enter the name");
		pmst.setString(2, sc.next());
		System.out.println("enter the email");
		pmst.setString(3, sc.next());
		 int i =pmst.executeUpdate();
		 if(i>0) {
			 System.out.println("Database is created");
		 }
		 else {
			 System.out.println("Database is  not created"); 
		 }
		 
		con.close();
		pmst.close();
		sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	}
}

