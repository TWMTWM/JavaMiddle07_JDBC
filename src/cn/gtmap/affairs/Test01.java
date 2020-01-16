package cn.gtmap.affairs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ʹ������
 * 	�������еĶ��������Ҫô���ɹ���Ҫô��ʧ��
 * 	ͨ�� c.setAutoCommit(false);�ر��Զ��ύ
 * 	ʹ�� c.commit();�����ֶ��ύ
 * 	��22��-35��֮������ݿ�������ʹ���ͬһ�������У�Ҫô���ɹ���Ҫô��ʧ��
 * 	���ԣ���Ȼ��һ��SQL����ǿ���ִ�еģ����ǵڶ���SQL����д���������������SQL��䶼û�б��ύ�� ��������SQL��䶼����ȷ�ġ�
 *
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
            Statement s = c.createStatement();) {
  
            // �������ǰ����
            // �������еĶ��������Ҫô���ɹ���Ҫô��ʧ��
  
            c.setAutoCommit(false);
  
            // ��Ѫ��SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            s.execute(sql1);
  
            // ��Ѫ��SQL
            // ��С��д��д���� updata(����update)
  
            String sql2 = "updata hero set hp = hp -1 where id = 22";
            s.execute(sql2);
  
            // �ֶ��ύ
            c.commit();
  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}
