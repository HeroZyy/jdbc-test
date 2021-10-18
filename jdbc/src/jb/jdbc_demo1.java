package jb;

import java.sql.*;
import java.util.ArrayList;

public class jdbc_demo1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;

        try {
            String s = "SELECT * FROM account";
            conn = DriverManager.getConnection("jdbc:mysql:///testdb", "root", "");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(s);
            Emp emp = new Emp();
            ArrayList<Emp> list = new ArrayList<>();
            while(rs.next()){
                int money = rs.getInt(2);
                String name = rs.getString("name");
                emp.setName(name);
                emp.setMoney(money);
                list.add(emp);
            }
            System.out.println(list);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
