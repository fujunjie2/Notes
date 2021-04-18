package com.knight.springboot.LoadOnStartUp;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class UserServletContextAware implements ServletContextAware {
    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("servletContextAware_2");
    }
}
