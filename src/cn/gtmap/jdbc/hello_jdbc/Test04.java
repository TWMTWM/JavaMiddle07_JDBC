package cn.gtmap.jdbc.hello_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行SQL语句
 * 	s.execute执行sql语句
 * @author Administrator
 *
 */
public class Test04 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEnconding=UTF-8", 
					"root", "admin");
			Statement s = c.createStatement();
            // 准备sql语句
            // 注意： 字符串要用单引号'
			String sql = "insert into hero values(null," + "'提莫'" + "," + 313.34f + "," + 345 + ")";
			s.execute(sql);
			System.out.println("执行插入语句成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
