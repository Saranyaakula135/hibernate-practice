package com.kodnest.ThirdHibernate;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // HIbernate steps
    	
    	//step1 and 2 completed
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	//step3
    	Session session = factory.openSession();
    	
    	//step4
    	
    	Transaction transaction = session.beginTransaction();
    	
    	//step5
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter student ID to delete");
    	int id = sc.nextInt();
    	
    	Student obj=session.get(Student.class, id);
    	if(obj != null) {
    		session.remove(obj);
    		System.out.println("Student deleted successfully");
    	}else {
    		System.out.println("Student does not exist");
    	}
    	transaction.commit();
    	session.close();
    	factory.close();
    	sc.close();
    }
}
