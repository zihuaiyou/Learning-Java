package com.zihyou.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDEMO_PrepareStatement {
    public static void main(String[] args) throws Exception {
        //1.注册驱动(自动执行，无需手动注册)
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/bbs";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql;
        String name = "张三ddd";
        String pwd = "' or '1' = '1"; //sql注入问题
        String sql = "select * from login where name = '" + name + "'and pwd ='" + pwd + "'";

        //4.获取执行sql的statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //6.处理结果
        if (rs.next()) {
            System.out.println("成功登录~~");
        } else {
            System.out.println("登录失败~");
        }

        //7.释放资源
        stmt.close();
        conn.close();
    }
}
