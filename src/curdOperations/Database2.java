package curdOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Database2 {
	private static  final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final  String url = "jdbc:mysql://localhost:3306/";
	private static final String password = "root";
	private static final String username = "root";
public static void main(String[] args) {
	try {
		Scanner sc = new Scanner(System.in);
		Class.forName(Driver);
		Connection con =  DriverManager.getConnection(url, username , password);
		System.out.println("enter data base name");
		String sql = "drop database " + sc.next();
		PreparedStatement pmst = con.prepareStatement(sql);
		int i = pmst.executeUpdate();
		if (i==0){
			System.out.println("database is dropped");
		}
		else{
			System.out.println("datbase is not dropped");
		}
		pmst.close();
		con.close();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
