package com.knight.springboot.mybatis.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//@Component
//@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {java.sql.Connection.class, Integer.class}))
public class MyStatementHandler implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        System.out.println("当前拦截到的对象：" + target);
        MetaObject metaObject = SystemMetaObject.forObject(target);
        String[] properties = metaObject.getGetterNames();
        // 对sql语句进行重新赋值
        Configuration configuration = (Configuration) metaObject.getValue("delegate.configuration");
        metaObject.setValue("boundSql.sql", "select * from menu t where 1=1 and t.authority=?");
         metaObject.getValue("boundSql.sql");
        // 对参数名称重新赋值
        List list = getParameterMappings(configuration);
        metaObject.setValue("boundSql.parameterMappings", list);
        // 获取参数值
        Object parameterObject = metaObject.getValue("parameterHandler.parameterObject");
        // 对参数值重新赋值

        metaObject.setValue("parameterHandler.parameterObject", parameterObject);
        // 执行目标方法
        Object proceed = invocation.proceed();
        // 返回执行后的返回值
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }

    private List<ParameterMapping> getParameterMappings(Configuration configuration) {
        List<ParameterMapping> list = new ArrayList<ParameterMapping>();
        ParameterMapping parameterMapper = new ParameterMapping.Builder(configuration, "param3", Object.class)
                .mode(ParameterMode.IN).build();
        list.add(parameterMapper);
        return list;
    }



}
