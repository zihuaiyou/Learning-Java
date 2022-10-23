package com.zihyou;

import com.zihyou.Dao.BookDao;
import com.zihyou.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppService {
    public static void main(String[] args) {
        //2.导入Spring配置文件
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //3.获取Bean对象
        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();
        //方法一 强制关闭容器， bean对象才会销毁
//        ctx.close();

        //方法二 或者引入生命周期钩子
        ctx.registerShutdownHook();
    }
}
