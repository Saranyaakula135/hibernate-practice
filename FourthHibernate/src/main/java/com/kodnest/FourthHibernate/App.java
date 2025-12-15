package com.kodnest.FourthHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
 // Hibernate steps
    	
    	//step1 and 2 completed
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	//step3
    	Session session = factory.openSession();
    	
    	//step4
    	
    	Transaction transaction = session.beginTransaction();
    	
    	System.out.println("Enter id of a student to update name and email");
    	int id = sc.nextInt();
    	
    	Student obj = session.get(Student.class, id);
    	
    	if(obj != null) {
    		System.out.println("Enter new name and new email");
    		String name = sc.next();
    		String email = sc.next();
    		obj.setName(name);
    		obj.setEmail(email);
    		session.persist(obj);
    		System.out.println("Updated Successfully");
    	} else {
    		System.out.println("Student with " + id + "not found to update");
    	}
    	
    	transaction.commit();
    	session.close();
    	factory.close();
    	sc.close();
    }
}
