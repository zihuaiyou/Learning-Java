package com.zihyou.jdbc;

import com.zihyou.proj.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDEMO_ResultSet {
    public static void main(String[] args) throws Exception {
        //1.注册驱动(自动执行，无需手动注册)
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/bbs";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url,username,password);

        //3.定义sql;
        String sql = "select * from money";

        //4.获取执行sql的statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //创建集合
        List<Account> list = new ArrayList<>();
        //6.处理结果
        while (rs.next()){
            Account account = new Account();

            int id =  rs.getInt("id");
            String name =  rs.getString("name");
            double mny =  rs.getDouble("mny");

            account.setId(id);
            account.setName(name);
            account.setMny(mny);

            list.add(account);
        }

        System.out.println(list);
        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
