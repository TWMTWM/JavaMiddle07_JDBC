package cn.gtmap.add_delete_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����
 * ��δ������Hello JDBC�еĴ��룬���������ݿ��в�������
 */
public class Test01_Add {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
				Statement s = c.createStatement();
			)
		{
			String sql = "insert into hero values(null," + "'��Ī'" + "," + 313.0f + "," + 50 + ")";
			s.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
