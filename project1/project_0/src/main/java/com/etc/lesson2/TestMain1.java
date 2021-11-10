package com.etc.lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 综合查询问题
 * @author lenovo
 * 
 */
public class TestMain1 {

	public static void main(String[] args) {
		Connection con1 = null;
		// 2. 
		try {
			con1 = DriverManager.getConnection("jdbc:oracle:thin:@39.105.100.118:1521:helowin", "scott", "123456");
			
			String param0 = "CLERK";
			String param1 = ""; 
			StringBuilder sb = new StringBuilder();
			sb.append("  Select empno, ename,  ");
			sb.append("  deptno, job from emp       ");
			sb.append("  where 1 = 1           ");
			if (null != param0 && !"".equals(param0)) {
				sb.append("  and job = ?           ");
			}
			if (null != param1 && !"".equals(param1)) {
				sb.append("  and ename = ?           ");
			}

			// 预处理执行器 继承自Statment
			PreparedStatement st = con1.prepareStatement(sb.toString());
			int index = 0;
			if (null != param0 && !"".equals(param0)) {
				
				st.setString(++index, param0); 
			}
			if (null != param1 && !"".equals(param1)) {
				st.setString(++index, param1); 
			}		
			
			// executeQuery没有sql参数
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2)+ "\t");
				System.out.print(rs.getString(4)+ "\t");
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
