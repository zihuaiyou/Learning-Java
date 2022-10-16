package com.zihyou.jdbc;

import java.sql.*;

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
        String name = "张三";
//        String pwd = "' or '1' = '1"; //sql注入问题
        String pwd = "1234";
        String sql = "select * from login where name = ?and pwd =?";

        //4.获取执行sql的statement
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //5.执行sql
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);
        ResultSet rs = pstmt.executeQuery();

        //6.处理结果
        if (rs.next()) {
            System.out.println("成功登录~~");
        } else {
            System.out.println("登录失败~");
        }

        //7.释放资源
        pstmt.close();
        conn.close();
    }
}
