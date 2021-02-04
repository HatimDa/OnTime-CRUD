package com.ontime.crudoperations;

import com.ontime.dbmapping.Event;
import com.ontime.dbmapping.EventPriority;
import com.ontime.dbmapping.EventReminder;
import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ontime.dbmapping.EventOrganizer;
import org.hibernate.engine.jdbc.BlobProxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;


public class ObjectCreation {

    public void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("dbconfig.cfg.xml")
                .addAnnotatedClass(EventOrganizer.class)
                .addAnnotatedClass(Event.class)
                .addAnnotatedClass(EventPriority.class)
                .addAnnotatedClass(EventReminder.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {


            // start a transaction
            session.beginTransaction();

            // create user
            EventOrganizer tmpUser = new EventOrganizer("Timo", "1q2w3e4r45trz6",
                    "Timo Bend", "timodend@gmail.com");


            System.out.println("\nSaving the User ...");
            session.save(tmpUser);
            System.out.println(tmpUser);

            // add event
            InputStream inputStream = this.getClass()
                    .getClassLoader()
                    .getResourceAsStream("../pdfs/test.png");

            if (inputStream == null) {
                System.out.println("error");
            }

            Event tmpEvent = new Event();
            tmpEvent.setEventName("Doctor Appointment");
            tmpEvent.setEventDuration("90min");
            tmpEvent.setEventAddress("Jügelstr. 1, 60320, Frankfurt am Main");
            tmpEvent.setEventDate(new Date(2021, 10, 11));
            tmpEvent.setEventAttachment(IOUtils.toByteArray(inputStream));
            tmpEvent.setEventPriority(1);
//            tmpEvent.setEventReminder(1);


            System.out.println("\nSaving the Event ...");
            session.save(tmpEvent);
            System.out.println(tmpEvent);

            // add user to the event


            // save the user and leverage cascade all

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done saving the User and  into the DB ...");

        } catch (Exception e) {
            System.out.println("Exception a3mmi " + e.getMessage());
        } finally {
            session.close();
            factory.close();
        }
    }

}
