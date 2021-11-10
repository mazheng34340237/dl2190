package com.etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class TestMain1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. ��������
		Class.forName("com.mysql.jdbc.Driver");
		Class.forName("oracle.jdbc.OracleDriver");
		// ��ȡ META-INFO/service/java.sql.Driver�ļ�

		// 2. ��������
		Connection con = DriverManager.getConnection("jdbc:mysql://47.93.34.175:3306/my_mazheng", "root", "123456");
		Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@39.105.100.118:1521:helowin", "scott", "123456");
		
		// 3. ����ִ����
		Statement stat = con.createStatement();
		Statement stat1 = con1.createStatement();
		
		// 4. ִ��SQL��������
		String sql = "select id, ename from stu";
		String sql1 = "select empno, ename, job, mgr, hiredate, sal from emp";
		// ִ��sql��ѯ����ȡ���ResultSet
		ResultSet rs = stat.executeQuery(sql);
		
		while (rs.next()) { // �Ƿ�����һ����¼
			int id = rs.getInt(1); // ���ݵڼ���
			String ename = rs.getString("ename"); // ����������
			System.out.println(id + "@" + ename);
		}
		
		ResultSet rs1 = stat1.executeQuery(sql1);
		while (rs1.next()) { // �Ƿ�����һ����¼
			int empno = rs1.getInt(1); // ���ݵڼ���
			String ename = rs1.getString("ename"); // ����������
			String job = rs1.getString(3);
			int mgr = rs1.getInt(4);
			java.sql.Date d1 = rs1.getDate(5);
			java.util.Date d2 = new java.util.Date(d1.getTime());
			String d3 = new SimpleDateFormat("yyyy-MM-dd").format(d2);
			System.out.println(empno + "@" + ename + "@" + job  + "@" 
			+ mgr + "@" + d3);
		}

		// 5. �ر���Դ
		con.close();
		con1.close();
		
		
	}
}
