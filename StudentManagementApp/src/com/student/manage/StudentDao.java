package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
public static boolean insertStudentToDB(Student st) {
	//jdbc code...
	boolean flag=false;
	try {
		Connection con=CP.createC();
		String q="insert into students(sname,sphone,scity) values(?,?,?)";
		//PreparedStatement
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setString(1, st.getStudentName());
		pstmt.setString(2, st.getStudentPhone());
		pstmt.setString(3, st.getStudentCity());
		//execute....
		pstmt.executeUpdate();
		flag=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			return flag;
}

public static boolean deleteStudent(int userId) {
	// TODO Auto-generated method stub
	boolean flag=false;
	try {
		Connection con=CP.createC();
		String q="delete from students where sid=?";
		//PreparedStatement
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setInt(1, userId);
		//execute....
		pstmt.executeUpdate();
		flag=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			return flag;
}

public static boolean displayStudent() {
	// TODO Auto-generated method stub

	boolean flag=false;
	try {
		Connection con=CP.createC();
		String q="select * from students";
		//Statement
		Statement stmt=con.createStatement();
		ResultSet set=stmt.executeQuery(q);
		while(set.next()) {
			int id=set.getInt(1);
			String name=set.getString(2);
			String phone=set.getString(3);
			String city=set.getString(4);
			System.out.println("Id : "+id);
			System.out.println("Name : "+name);
			System.out.println("Phone : "+phone);
			System.out.println("City : "+city);
			System.out.println("++++++++++++++++++++++++++++++");
		}
		flag=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			return flag;
}

public static boolean updateStudent(int userId, String nphone) {
	// TODO Auto-generated method stub
	boolean flag=false;
	try {
		Connection con=CP.createC();
		String q="update students set sphone=? where sid=?";
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setString(1, nphone);
		pstmt.setInt(2, userId);
		pstmt.executeUpdate();
		flag=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return flag;
}

}
