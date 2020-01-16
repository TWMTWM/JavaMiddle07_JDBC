package cn.gtmap.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * 练习-性能比较
 * 	向数据库中插入10000条数据，分别使用Statement和PreparedStatement，比较各自花的时间差异
 * 	可以看到PreparedStatement是要比Statement快一些的，但是不是很明显。
 * 	这个和不同的数据库有关系，如果在Oracle上测试，PreparedStatement的效率优势会更明显一些。
 */
public class Test02 {
	
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        int count = 1000;
        long start = System.currentTimeMillis();
        insertByPreparedStatment(count);
        long end = System.currentTimeMillis();
        System.out.printf("使用预编译Statement插入%d条数据，耗时: %d毫秒%n", count, end - start);
 
        start = System.currentTimeMillis();
        insertStatment(count);
        end = System.currentTimeMillis();
        System.out.printf("使用Statement插入%d条数据，耗时: %d 毫秒%n", count, end - start);
 
    }
 
    private static void insertByPreparedStatment(int count) {
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
            PreparedStatement ps = c.prepareStatement(sql);) {
            for (int i = 0; i < count; i++) {
                ps.setString(1, "提莫_p");
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    private static void insertStatment(int count) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
                Statement s = c.createStatement();) {
            for (int i = 0; i < count; i++) {
                String sql = "insert into hero values(null," + "'提莫_s'" + "," + i + "," + i + ")";
                s.execute(sql);            
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
}
