package cn.gtmap.add_delete_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��ϰ������ɾ����
 *	���һ������
 *	public static void execute(String sql)
 *	�������ܵĲ�����SQL��䣬���������ӣ�ɾ���������޸ģ����������������ÿ�δ���ͬ��SQL�����Ϊ����
 */
public class Test04 {
	
	public static void execute(String sql){
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
			s.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public static void main(String[] args) {	
		String addSql = "insert into hero values(null," + "'��Ī'" + "," + 313.0f + "," + 50 + ")";
		String deleteSql = "delete from hero where id =5";
		String updateSql = "update hero set name = 'name5' where id = 3";
		execute(addSql);
	}
}
