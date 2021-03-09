package com.spring.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class AspectJAutoProxyCreator1 implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        final Object obj = bean;

        if (bean instanceof Calculator) {
            Object proxyObj = Proxy.newProxyInstance(
                    this.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("开始计算2");
                            Object result = method.invoke(obj, args);
                            System.out.println("结束计算2");
                            return result;
                        }
                    }
            );
            return proxyObj;
        }
        return bean;
    }
}
