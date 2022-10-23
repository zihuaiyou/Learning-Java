package com.zihyou.factory;

import com.zihyou.Dao.Impl.UserDaoImpl;
import com.zihyou.Dao.UserDao;

public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
