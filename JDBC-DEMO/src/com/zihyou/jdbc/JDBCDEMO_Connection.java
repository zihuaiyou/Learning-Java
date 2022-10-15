package com.zihyou.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Connection 的事务管理
public class JDBCDEMO_Connection {
    public static void main(String[] args) throws Exception {
        //1.注册驱动(自动执行，无需手动注册)
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/bbs";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        //3.定义sql;
        String sql1 = "update money set mny = 3000 where id = 1;";
        String sql2 = "update money set mny = 3000 where id = 2;";

        //4.获取执行sql的statement
        Statement stmt = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);
            //5.执行sql
            int count1 = stmt.executeUpdate(sql1);
//            int i = 0/0;
            int count2 = stmt.executeUpdate(sql2);
            //6.处理结果
            System.out.println(count1);
            System.out.println(count2);

            // 提交事务
            conn.commit();
        } catch (Exception e){
            // 回滚事务
            conn.rollback();
            e.printStackTrace();
        }




        //7.释放资源
        stmt.close();
        conn.close();
    }
}
