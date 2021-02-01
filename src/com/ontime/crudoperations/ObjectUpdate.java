package com.ontime.crudoperations;

import com.ontime.dbmapping.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObjectUpdate {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("dbconfig.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int userId = 1;

            // get new session and start the transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting user with id: " + userId);

            User myUser = session.get(User.class, userId);

            System.out.println("Updating User...");
            myUser.setUsername("Cristiano");

            // commit Transaction
            session.getTransaction().commit();


            System.out.println("Done updating the Database records !");

        } finally {
            factory.close();
        }
    }
}
