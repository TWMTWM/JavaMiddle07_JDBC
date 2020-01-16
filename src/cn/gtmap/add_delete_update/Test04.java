package cn.gtmap.add_delete_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 练习：增、删、改
 *	设计一个方法
 *	public static void execute(String sql)
 *	方法接受的参数是SQL语句，无论是增加，删除，还是修改，都调用这个方法，每次传不同的SQL语句作为参数
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
		String addSql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
		String deleteSql = "delete from hero where id =5";
		String updateSql = "update hero set name = 'name5' where id = 3";
		execute(addSql);
	}
}
