package com.student.manage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class CP {
	static Connection con;
public static Connection createC() throws SQLException{

	try {
		//load class
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create the Connection
		String user="root";
		String password="rv2002";
		String url="jdbc:mysql://localhost:3306/student_manage";
		con=DriverManager.getConnection(url,user,password);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	
}
}
