package cn.gtmap.jdbc.hello_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �ر����ӷ�ʽ01
 * 	���ݿ��������������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
 * 		�ȹر�Statement
 * 		��ر�Connection
 * @author Administrator
 *
 */
public class Test05_CloseConnection01 {
	public static void main(String[] args) {
		Connection c =null;
		Statement s = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
					"root", "admin");
			s = c.createStatement();
			String sql = "insert into hero values(null," + "'��Ī'" + "," + 313.0f + "," + 50 + ")";
			s.execute(sql);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
            // ���ݿ������ʱ������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
            // �ȹر�Statement
			if(s != null){
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			//��ر�Connection
			if(c != null)
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
