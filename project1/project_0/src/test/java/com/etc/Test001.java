package com.etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

public class Test001 {

	// Select DQL
	// CUD
	@Test
	public void test001() {

		Connection con1 = null;
		// 2. 
		try {
			con1 = DriverManager.getConnection("jdbc:oracle:thin:@39.105.100.118:1521:helowin", "scott", "123456");
			con1.setAutoCommit(false); // 开启事务set autocommit off;
			
			StringBuilder sb = new StringBuilder();
			sb.append("  insert into emp values(emp_empno_seq.nextval,?,?,?,?,?,?,?) ");

			// 预处理执行器 继承自Statment
			PreparedStatement st = con1.prepareStatement(sb.toString());

			// 放参数进？  第1个？换成 param0
			st.setString(1, "TOM");
			st.setString(2, "MANAGER");
			st.setInt(3, 7369);
			st.setTimestamp(4, new Timestamp(new Date().getTime()));
			st.setDouble(5, 100.12);
			st.setObject(6, null);
			st.setObject(7, null);
			
			// CUD executeUpdate
			// result 修改的条数
			int result = st.executeUpdate();
			if (result != 1) {
				con1.rollback();
			}
			con1.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con1.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
