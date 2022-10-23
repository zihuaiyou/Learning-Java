package com.zihyou.factory;

import com.zihyou.Dao.Impl.OrderDaoImpl;
import com.zihyou.Dao.OrderDao;

public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        //工厂方法中可能还包含别的东西
        System.out.println("something other");
        return new OrderDaoImpl();
    }
}
