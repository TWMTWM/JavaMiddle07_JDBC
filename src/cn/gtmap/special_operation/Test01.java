package cn.gtmap.special_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * ��ȡ������id
 * 	��Statementͨ��execute����executeUpdateִ�����������MySQL��Ϊ�²�������ݷ���һ��������id��(ǰ����������id����Ϊ��������,��Mysql�������ʱ��AUTO_INCREMENT�ͱ�ʾ������)
 * 	CREATE TABLE hero (
 * 		id int(11) AUTO_INCREMENT,
 * 		...
 * 	}
 * 	����������execute����executeUpdate�����᷵�����������id�Ƕ��١�
 * 		��Ҫͨ��Statement��getGeneratedKeys��ȡ��id
 * 	ע�� ��20�еĴ��룬������˸�Statement.RETURN_GENERATED_KEYS��������ȷ���᷵��������ID��
 *  	ͨ������²���Ҫ��������е�ʱ����Ҫ�ӣ������ȼ��ϣ�����һЩ
 * 	PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			)
		{
			ps.setString(1, "����");
			ps.setFloat(2, 616);
			ps.setInt(3, 100);
			
			//ִ�в������
			ps.execute();
			
            //��ִ�����������MySQL��Ϊ�²�������ݷ���һ��������id
            //JDBCͨ��getGeneratedKeys��ȡ��id
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				int id= rs.getInt(1);
				System.out.println(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
