package curdOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class database {
	private static final String URL ="jdbc:mysql://localhost:3306/";
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
	System.out.println("Enter databse name");
	String sql = "create database " + sc.next();
	
	pmst = con.prepareStatement(sql);
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


