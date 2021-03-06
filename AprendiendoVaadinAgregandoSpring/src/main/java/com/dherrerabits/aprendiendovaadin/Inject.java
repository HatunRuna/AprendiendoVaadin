package com.dherrerabits.aprendiendovaadin;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
  
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
  
public class Inject {
  
    public static void inject( Object component )
    {
        ApplicationContext context = getApplicationContext();
        AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        beanFactory.autowireBeanProperties( component, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false );
    }
  
    private static ApplicationContext getApplicationContext()
    {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession( false );
        ServletContext servletContext = session.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext( servletContext );
        return context;
    }
}
