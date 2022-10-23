package com.zihyou.factory;

import com.zihyou.Dao.Impl.UserDaoImpl;
import com.zihyou.Dao.UserDao;
import org.springframework.beans.factory.FactoryBean;

//使用FactoryBean
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }
}
