package com.zihyou.service.impl;

import com.zihyou.Dao.BookDao;
import com.zihyou.Dao.Impl.BookDaoImpl;
import com.zihyou.service.BookService;

public class BookServiceImpl implements BookService {
    //4.删除业务层的new 代码
    private BookDao bookDao ;
    public void save(){
        System.out.println("book service save...");
        bookDao.save();
    }
    //5.提供方法供容器使用
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
