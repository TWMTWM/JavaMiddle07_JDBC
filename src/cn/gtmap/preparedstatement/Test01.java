package cn.gtmap.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * ʹ��PreparedStatement
 * 	�� Statementһ����PreparedStatementҲ������ִ��sql����
 * 	�봴��Statement��ͬ���ǣ���Ҫ����sql��䴴��PreparedStatement
 * 	����֮�⣬���ܹ�ͨ�����ò�����ָ����Ӧ��ֵ��������Statement����ʹ���ַ���ƴ��
 * 	ע�� ����JAVA��Ψ���Ļ�1�ĵط�����һ���ǲ�ѯ����е�ResultSetҲ�ǻ�1�ġ�
 */
public class Test01 {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "insert into hero values(null,?,?,?)";
		
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","admin");
				// ����sql��䴴��PreparedStatement
				PreparedStatement ps = c.prepareStatement(sql);
			)
		{
			//���ò���
			ps.setString(1, "��Ī");
			ps.setFloat(2, 313.9f);
			ps.setInt(3, 50);
			
			//ִ��
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
