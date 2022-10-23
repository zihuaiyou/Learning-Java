package com.zihyou;

import com.zihyou.Dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceBook {
    public static void main(String[] args) {
        //2.导入Spring配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //3.获取Bean对象
        BookDao bookDao = (BookDao) ctx.getBean("dao");
        bookDao.save();
    }
}
