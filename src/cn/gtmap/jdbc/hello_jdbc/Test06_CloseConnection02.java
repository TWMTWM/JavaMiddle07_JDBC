package cn.gtmap.jdbc.hello_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �ر����ӷ�ʽ02
 *	ʹ��try-with-resource�ķ�ʽ�Զ��ر�����
 *	���������һ���Ĺر����ӵķ�ʽ���鷳�����Բο��ر��� �ķ�ʽ��ʹ��try-with-resource�ķ�ʽ�Զ��ر����ӣ�
 *	��ΪConnection��Statement��ʵ����AutoCloseable�ӿ�
 */
public class Test06_CloseConnection02 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
				Statement s = c.createStatement();
		)
		{
			String sql = "insert into hero values(null," + "'��Ī2'" + "," + 313.0f + "," + 50 + ")";
			s.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
