package com.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {

    public static void main(String[] args) {

        UserDao userDao = new UserDaoImpl();

        Handler handler = new Handler(userDao);

        ClassLoader loader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();


        UserDao proxyDao = (UserDao) Proxy.newProxyInstance(loader, interfaces, handler);

        System.out.println(proxyDao.getClass() );
        proxyDao.save();
    }
}


class Handler implements InvocationHandler{

    private UserDao userDao;

    Handler(UserDao dao) {
        this.userDao = dao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before save");


        method.invoke(userDao, args);

        System.out.println("after save");


        return null;
    }
}