package com.ontime.crudoperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ontime.dbmapping.User;

public class ObjectCreation {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("dbconfig.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // use the session object to save object
            System.out.println("Creating  new User object ...");
            User tmpUser = new User("DON", "1q2w3efdeiuzfgberzu", "donkwijsd",
                    "fdeanjikg@yahoo.fr");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the User on Database ...");
            session.save(tmpUser);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done saving the User into the DB ...");

        } finally {
            factory.close();
        }
    }

}
