package com.zihyou;

import com.zihyou.service.BookService;
import com.zihyou.service.impl.BookServiceImpl;

public class App {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
