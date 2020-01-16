package cn.gtmap.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * ��ϰ-���ܱȽ�
 * 	�����ݿ��в���10000�����ݣ��ֱ�ʹ��Statement��PreparedStatement���Ƚϸ��Ի���ʱ�����
 * 	���Կ���PreparedStatement��Ҫ��Statement��һЩ�ģ����ǲ��Ǻ����ԡ�
 * 	����Ͳ�ͬ�����ݿ��й�ϵ�������Oracle�ϲ��ԣ�PreparedStatement��Ч�����ƻ������һЩ��
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
        System.out.printf("ʹ��Ԥ����Statement����%d�����ݣ���ʱ: %d����%n", count, end - start);
 
        start = System.currentTimeMillis();
        insertStatment(count);
        end = System.currentTimeMillis();
        System.out.printf("ʹ��Statement����%d�����ݣ���ʱ: %d ����%n", count, end - start);
 
    }
 
    private static void insertByPreparedStatment(int count) {
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
            PreparedStatement ps = c.prepareStatement(sql);) {
            for (int i = 0; i < count; i++) {
                ps.setString(1, "��Ī_p");
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
                String sql = "insert into hero values(null," + "'��Ī_s'" + "," + i + "," + i + ")";
                s.execute(sql);            
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
}
