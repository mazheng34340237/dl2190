package com.etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMain3 {

	public static void main(String[] args) {
		Connection con1 = null;
		// 2. 
		try {
			con1 = DriverManager.getConnection("jdbc:oracle:thin:@39.105.100.118:1521:helowin", "scott", "123456");
			
			String param0 = "MANAGER";
			String sql = "Select empno, ename,"
					+ " deptno from emp where job = ?";

			// 预处理执行器 继承自Statment
			PreparedStatement st = con1.prepareStatement(sql);

			// 放参数进？  第1个？换成 param0
			st.setString(1, param0); 
			
			// executeQuery没有sql参数
			ResultSet rs = st.executeQuery();
			
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
