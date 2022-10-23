package com.zihyou;

import com.zihyou.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        //2.导入Spring配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //3.获取Bean对象
        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();
    }
}
