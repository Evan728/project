package com.efinance.service;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.hibernate.SessionFactory;  
import org.hibernate.Session;  

import com.efinance.model.User;
 
 
public class SpringTest  
{  
    private static ApplicationContext ctx;  
      
    static 
    {  
        //在类路径下寻找resources/beans.xml文件  
        ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");  
    }  
      
      
    public static void main(String[] args)  
    {  
        //从Spring容器中请求SessionFactory  
        SessionFactory factory =   
               (SessionFactory)ctx.getBean("sessionFactory");  
 
        Session session = factory.openSession();  
   
        //读取id为1的教师。  
        User user = (User)session.get(User.class, 13);  
 
        if(user != null)  
        {  
            System.out.println("姓    名： " + user.getUsername());  
            System.out.println("密码： " + user.getId());  
        }  
 
        else 
        {  
            System.out.println("未找到！");  
        }  
          
        session.close();  
       
    }  
 
} 