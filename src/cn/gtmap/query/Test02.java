package cn.gtmap.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * 1. ����һ���û������ֶ�name,password
 * 2. ����һ������
 * 	insert into user values(null,'dashen','thisispassword');
 * 3. SQL����ж��˺������Ƿ���ȷ
 * 	�ж��˺��������ȷ��ʽ�Ǹ����˺ź����뵽����ȥ�����ݣ���������ݣ��ͱ���������ȷ�ˣ����û���ݣ��ͱ����������
 * 	��ǡ���ķ�ʽ �ǰ�uers�������ȫ���鵽�ڴ��У��������бȽϡ� ���users������100���������أ� �ڴ涼�����õġ�
 */
public class Test02 {
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
			String name = "dashen";
			//��ȷ�������ǣ�thisispassword
			String password = "thisispassword1";
			String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
			//ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
			ResultSet rs = s.executeQuery(sql);
			if(rs.next())
				System.out.println("�˺��������");
			else
				System.out.println("�˺��������");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
