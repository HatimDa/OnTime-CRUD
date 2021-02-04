package com.ontime.crudoperations;

import com.ontime.dbmapping.Event;
import com.ontime.dbmapping.EventPriority;
import com.ontime.dbmapping.EventReminder;
import com.ontime.dbmapping.EventUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryUser {

    List<EventUser> users;
    SessionFactory factory;
    Session session;


    public QueryUser() {
        // create session factory
        factory = new Configuration()
                .configure("dbconfig.cfg.xml")
                .addAnnotatedClass(EventUser.class)
                .addAnnotatedClass(Event.class)
                .addAnnotatedClass(EventPriority.class)
                .addAnnotatedClass(EventReminder.class)
                .buildSessionFactory();

        // create session
        session = factory.getCurrentSession();

        session.beginTransaction();
    }

    public List<EventUser> getUserByEmail(String email, String password) {

        try {
            String miao = "from EventOrganizer s where s.userEmail= '" + email + "' AND s.userPassword= '" + password + "'";
            System.out.println("alala  " + miao);
            users = session.createQuery(miao).list();
            commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return users;
    }

    public List<EventUser> getAllUsers() {
        try {
            users = session.createQuery("from EventOrganizer").list();
            commitTransaction();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return users;
    }


    private void commitTransaction() {
        // commit transaction
        session.getTransaction().commit();
        System.out.println("Done saving the User into the DB ...");
    }

    public void main(String[] args) {



/*        try {

            // start a transaction
            session.beginTransaction();

            // Query Users
            List<EventOrganizer> theUsers = session.createQuery("from EventOrganizer").list();

            // Display the Users
            displayUsers(theUsers);

            // Query Users who's fullname='timocook'
            theUsers = session.createQuery("from EventOrganizer s where s.fullName= 'timocook'").list();

            // Display the Users who's fullname='timocook'
            System.out.println("\n\nUsers the fullname timocook are");
            displayUsers(theUsers);

            // Query Users who's username='Timo' or 'tim'
            theUsers = session.createQuery("from EventOrganizer s where"
                    + " s.userName= 'Timo' OR s.userName= 'tim'").list();


            // Display the Users who's username='Timo' or 'tim'
            System.out.println("\n\nUsers with the username Timo OR tim are");
            displayUsers(theUsers);

            // Query Users who's email that ends with 'yahoo.fr'
            theUsers = session.createQuery("from EventOrganizer s where"
                    + " s.userEmail LIKE '%yahoo.fr'").list();


            // Display Users who's email that ends with 'yahoo.fr'
            System.out.println("\n\nUsers with the emails that ends with yahoo.fr");
            displayUsers(theUsers);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done saving the User into the DB ...");

        } finally {

            session.close();
            factory.close();
        }*/
    }

    private static void displayUsers(List<EventUser> theUsers) {
        // Display Users
        for (EventUser tmpUser : theUsers) {
            System.out.println(tmpUser);
        }
    }
}