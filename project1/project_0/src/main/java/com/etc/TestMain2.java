package com.etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMain2 {

	public static void main(String[] args) {
		Connection con1 = null;
		// 2. 
		try {
			con1 = DriverManager.getConnection("jdbc:oracle:thin:@39.105.100.118:1521:helowin", "scott", "123456");
			
			Statement st = con1.createStatement();
			String param0 = "MANAGER";
			String sql = "Select empno, ename,"
					+ " deptno from emp where job = '" + param0 + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2)+ "\t");
				System.out.print(rs.getInt(3));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
