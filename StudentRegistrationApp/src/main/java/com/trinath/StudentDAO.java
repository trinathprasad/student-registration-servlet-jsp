package com.trinath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

	private static final String Driver = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USN ="ADVDB11AM";
	private static final String PWD = "TRI";
	
	public int registerStudent(Student stu)throws ClassNotFoundException
	{
		int result = 0;
		
		try
		{
			Class.forName(Driver);
			Connection con = DriverManager.getConnection(URL,USN,PWD);
			
			String INSERT_SQL = "INSERT INTO students(id,name,email) VALUES(?,?,?)";
					
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			ps.setInt(1, stu.getId());
			ps.setString(2, stu.getName());
			ps.setString(3, stu.getEmail());
			
			result = ps.executeUpdate();
			
			con.close();	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
