package com.zihyou.Dao.Impl;

import com.zihyou.Dao.BookDao;

public class BookDaoImpl implements BookDao {
    //通过构造方法（new 对象）实例化
    public BookDaoImpl() {
        System.out.println("Book dao constructor");
    }
    //如提供有参构造器，就必须有无参构造器
    public BookDaoImpl(int i) {
        System.out.println("Book dao constructor");
    }
    //具体实现是通过反射的方式（private 构造方法也可访问）
//    private BookDaoImpl() {
//        System.out.println("Book dao constructor");
//    }

    public void save(){
        System.out.println("Book dao save...");
    }
}
