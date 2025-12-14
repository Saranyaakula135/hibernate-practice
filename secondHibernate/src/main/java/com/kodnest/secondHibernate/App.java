package com.kodnest.secondHibernate;

import com.kodnest.secondHibernate.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
    	 
        // Hibernate 7 steps
        
        //step =1v : load the configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        //step = 2 : create session factory
       SessionFactory factory=configuration.buildSessionFactory();
        
       //step = 3 : open session
       Session session =factory.openSession();
       
       //step = 4: Begin Transaction
       Transaction transaction = session.beginTransaction();
       
     //step = 5 : Perform Operation
       Student ref = session.get(Student.class,1);
       
       System.out.println(ref.id + " " + ref.name + " " + ref.marks + " " + ref.email);
       
     //step = 6 : commit Transaction
       transaction.commit();
       
       //step = 7 : Close Session and session Factory
       session.close();
       factory.close();
       
       
       }
}
