package cn.gtmap.jdbc.hello_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ִ��SQL���
 * 	s.executeִ��sql���
 * @author Administrator
 *
 */
public class Test04 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEnconding=UTF-8", 
					"root", "admin");
			Statement s = c.createStatement();
            // ׼��sql���
            // ע�⣺ �ַ���Ҫ�õ�����'
			String sql = "insert into hero values(null," + "'��Ī'" + "," + 313.34f + "," + 345 + ")";
			s.execute(sql);
			System.out.println("ִ�в������ɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
