package com.ontime.crudoperations;

import com.ontime.dbmapping.Event;
import com.ontime.dbmapping.EventPriority;
import com.ontime.dbmapping.EventReminder;
import com.ontime.dbmapping.EventUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;


public class ObjectCreation {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("dbconfig.cfg.xml")
                .addAnnotatedClass(EventUser.class)
                .addAnnotatedClass(Event.class)
                .addAnnotatedClass(EventPriority.class)
                .addAnnotatedClass(EventReminder.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {


            // start a transaction
            session.beginTransaction();



/*
            // create user
            EventUser tmpUser1 = new EventUser("Tim", "1q2w3e4rfr45trz6",
                    "Timo Bend", "timd@gmail.com");
            EventUser tmpUser2 = new EventUser("Cami", "1q2w3ede3trz6",
                    "Timo Bend", "Cami@gmail.com");
            EventUser tmpUser3 = new EventUser("Nimo", "dejnfesfisufh3",
                    "Timo Bend", "Nimo@gmail.com");
            EventUser tmpUser4 = new EventUser("Numi", "feb4ui38djnkeiw",
                    "Timo Bend", "Numi@gmail.com");
            EventUser tmpUser5 = new EventUser("Cayak", "esuih53ee3r",
                    "Timo Bend", "Cayak@gmail.com");
            EventUser tmpUser6 = new EventUser("Nawal", "384r487r94",
                    "Timo Bend", "Nawal@gmail.com");
*/




           Event tmpEvent = new Event();
            tmpEvent.setEventName("Doctor Appointment");
            tmpEvent.setEventDuration("90min");
            tmpEvent.setEventAddress("Jügelstr. 1, 60320, Frankfurt am Main");
            Calendar c = Calendar.getInstance();
            c.set(2021, 10, 17,13,30,0);
            tmpEvent.setEventDate(c.getTime());


            File file = new File("pdfs/test.pdf");
            byte[] eventAttachment = new byte[(int) file.length()];


            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(eventAttachment);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            tmpEvent.setEventAttachment(eventAttachment);

            EventPriority ep = new EventPriority(2,"medium");

            EventUser eu = new EventUser(1);

            EventReminder er = new EventReminder(2);

            tmpEvent.setEventPriority(ep);
            tmpEvent.setEventUser(eu);
            tmpEvent.setEventReminder(er);



            System.out.println("\nSaving the Event ...");

            session.save(tmpEvent);

/*            session.save(tmpUser1);    //Save the data
            session.save(tmpUser2);
            session.save(tmpUser3);
            session.save(tmpUser4);
            session.save(tmpUser5);
            session.save(tmpUser6);*/

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done saving the User and  into the DB ...");


        } finally {
            session.close();
            factory.close();
        }
    }

    private static void displayUsers(List<EventUser> theUsers) {
        // Display Users
        for (EventUser tmpUser : theUsers){
            System.out.println(tmpUser);
        }
    }

}
