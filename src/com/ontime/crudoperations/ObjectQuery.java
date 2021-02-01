package com.ontime.crudoperations;

import com.ontime.dbmapping.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ObjectQuery {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("dbconfig.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // Query Users
            List<User> theUsers = session.createQuery("from User").list();

            // Display the Users
            displayUsers(theUsers);

            // Query Users who's fullname='timocook'
            theUsers = session.createQuery("from User s where s.fullname= 'timocook'").list();

            // Display the Users who's fullname='timocook'
            System.out.println("\n\nUsers the fullname timocook are");
            displayUsers(theUsers);

            // Query Users who's username='Timo' or 'tim'
            theUsers = session.createQuery("from User s where"
                    +" s.username= 'Timo' OR s.username= 'tim'").list();


            // Display the Users who's username='Timo' or 'tim'
            System.out.println("\n\nUsers with the username Timo OR tim are");
            displayUsers(theUsers);

            // Query Users who's email that ends with 'yahoo.fr'
            theUsers = session.createQuery("from User s where"
                    +" s.usermail LIKE '%yahoo.fr'").list();


            // Display Users who's email that ends with 'yahoo.fr'
            System.out.println("\n\nUsers with the emails that ends with yahoo.fr");
            displayUsers(theUsers);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done saving the User into the DB ...");

        } finally {
            factory.close();
        }
    }

    private static void displayUsers(List<User> theUsers) {
        // Display Users
        for (User tmpUser : theUsers){
            System.out.println(tmpUser);
        }
    }
}
