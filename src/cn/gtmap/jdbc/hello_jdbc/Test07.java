package cn.gtmap.jdbc.hello_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��ϰ������100������
 * @author Administrator
 *
 */
public class Test07 {
	public static void main(String[] args) {
		try {
			//��ʼ������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ο��ر��� �ķ�ʽ��ʹ��try-with-resource�ķ�ʽ�Զ��ر�����
		try(
				//��������
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
				Statement s = c.createStatement();//����statement����
		) 
		{
			for (int i = 0; i <= 100; i++) {
				String sql = "insert into hero values(null," + "'Ӣ��"+i+"'"  + "," + 313.0f + "," + 50 + ")";
				s.execute(sql);//ִ��SQL���
			}
			System.out.println("����100�����ݳɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
