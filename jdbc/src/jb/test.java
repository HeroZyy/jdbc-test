package jb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
        String sql = "update account set money = money where name = name";
        Statement statement = conn.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println("i = " + i);
        statement.close();
        conn.close();
    }
}
