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
        //����·����Ѱ��resources/beans.xml�ļ�  
        ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");  
    }  
      
      
    public static void main(String[] args)  
    {  
        //��Spring����������SessionFactory  
        SessionFactory factory =   
               (SessionFactory)ctx.getBean("sessionFactory");  
 
        Session session = factory.openSession();  
   
        //��ȡidΪ1�Ľ�ʦ��  
        User user = (User)session.get(User.class, 13);  
 
        if(user != null)  
        {  
            System.out.println("��    ���� " + user.getUsername());  
            System.out.println("���룺 " + user.getId());  
        }  
 
        else 
        {  
            System.out.println("δ�ҵ���");  
        }  
          
        session.close();  
       
    }  
 
} 