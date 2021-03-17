package com.design;

public class StaticProxyDemo {

    public static void main(String[] args) {

        UserDao dao = new UserDaoImpl();

        UserDaoProxy proxy = new UserDaoProxy(dao);

        proxy.save();
    }
}

interface UserDao{

    void save();
}


class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("save");
    }
}

class UserDaoProxy implements UserDao{

    private UserDao userDao;

    UserDaoProxy(UserDao dao) {
        this.userDao = dao;
    }

    @Override
    public void save() {
        System.out.println("before save");
        userDao.save();
        System.out.println("after save");
    }
}