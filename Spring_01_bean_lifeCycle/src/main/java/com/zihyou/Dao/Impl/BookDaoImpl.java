package com.zihyou.Dao.Impl;

import com.zihyou.Dao.BookDao;

public class BookDaoImpl implements BookDao {
    public void save(){
        System.out.println("Book dao save...");
    }
    public void init(){
        System.out.println("dao init...");
    }
    public void destroy(){
        System.out.println("dao destroy...");
    }
}
