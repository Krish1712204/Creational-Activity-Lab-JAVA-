package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
        Student student = new Student("Krishna Shelar", "krishna@example.com");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(student);
        tx.commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        Student fetched = session.get(Student.class, student.getId());
        System.out.println("Fetched: " + fetched);
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        fetched.setEmail("krishna_updated@example.com");
        session.update(fetched);
        tx.commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(fetched);
        tx.commit();
        session.close();

        HibernateUtil.getSessionFactory().close();
    }
}
