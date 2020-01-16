package cn.gtmap.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��ϰ-��ҳ��ѯ
 *	���һ�����������з�ҳ��ѯ
 *	public static void list(int start, int count)
 *	start ��ʾ��ʼҳ����count��ʾһҳ��ʾ������
 *	list(0,5) ��ʾ��һҳ��һ����ʾ5������
 *	list(10,5) ��ʾ����ҳ��һ����ʾ5������
 *	���з�ҳ��ѯ�õ���SQL���ο� �� ��ѯ����
 */
public class Test04 {
	
	public static void list(int start,int count){
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
			String sql = "select * from hero limit " + start + "," + count;
			//ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt("id");// ����ʹ���ֶ���
				String name = rs.getString(2);// Ҳ����ʹ���ֶε�˳��
				float hp = rs.getFloat("hp");
				int damage= rs.getInt(4);
				System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		list(0, 5);
	}
}
