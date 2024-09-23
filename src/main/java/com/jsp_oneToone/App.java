package com.jsp_oneToone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "program execution started!" );
        
        Student s1 = new Student();
        s1.setRollno(103);
        s1.setName("rajan");
        s1.setMarks(56.00);
        
        
        Laptop l1 = new Laptop();
        l1.setLid(1110);
        l1.setLname("HPpp");
        
        s1.setLaptop(l1);
        
        
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();
        session.save(s1);
        session.save(l1);
        trans.commit();
        System.out.println("program execution ended!");
    }
}
