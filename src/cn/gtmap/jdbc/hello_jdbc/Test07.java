package cn.gtmap.jdbc.hello_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 练习，插入100条数据
 * @author Administrator
 *
 */
public class Test07 {
	public static void main(String[] args) {
		try {
			//初始化驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//参考关闭流 的方式，使用try-with-resource的方式自动关闭连接
		try(
				//创建连接
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
				Statement s = c.createStatement();//创建statement对象
		) 
		{
			for (int i = 0; i <= 100; i++) {
				String sql = "insert into hero values(null," + "'英雄"+i+"'"  + "," + 313.0f + "," + 50 + ")";
				s.execute(sql);//执行SQL语句
			}
			System.out.println("插入100条数据成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
