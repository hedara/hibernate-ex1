package com.samples.hibernate.Main;

import com.samples.hibernate.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by edara on 8/9/16.
 */

public class Main {
    static SessionFactory sessionFactory;
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        //user.setId(2);
        user.setName("Fourth User");
        user.setDescription("User 4 description");
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("********************************* Done creating session factory");
        save(user);
        UserDetails userDB = get(2);
        System.out.println(userDB.getName());
        sessionFactory.close();
        System.out.println("DONE");
    }

    public static void save(UserDetails user) {
        Session session=null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch(Exception ex) {

        }finally{
            if(session.isOpen())
                session.close();
            System.out.println(session.isOpen());

        }

    }

    public static UserDetails get(int id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            return session.get(UserDetails.class,id);

        }catch(Exception ex) {

        }finally {
            if(session.isOpen())
                session.close();
        }
        return null;
    }
}
