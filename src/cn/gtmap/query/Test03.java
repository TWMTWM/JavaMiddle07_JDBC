package cn.gtmap.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��ȡ����
 *	ִ�е�sql���Ϊ
 *	select count(*) from hero
 *	Ȼ��ͨ��ResultSet��ȡ����
 */
public class Test03 {
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
			String sql = "select count(*) from hero";
			ResultSet rs = s.executeQuery(sql);
			int total = 0;
			while(rs.next()){
				total = rs.getInt(1);
			}
			System.out.println("��Hero���ܹ���:" + total+" ������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
