package com.zihyou.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDEMO {
    public static void main(String[] args) throws Exception {
        //1.注册驱动(自动执行，无需手动注册)
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/bbs";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        //3.定义sql;
        String sql = "update stu set class_id = 999 where id = 1 ";

        //4.获取执行sql的statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql);

        //6.处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        conn.close();
    }
}
