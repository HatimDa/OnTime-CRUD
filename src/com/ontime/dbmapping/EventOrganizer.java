package com.ontime.dbmapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Event organizer.
 */
@Entity
@Table(name = "event_organizer")

/*
 * Annotating Java Class
 */
public class EventOrganizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_email")
    private String userEmail;

    /**
     * We reference the events from Event table in our Database that we can use in the constructor.
     * Control the cascading from the "event_organizer" table to "event" table.
     * And add the OneToMany annotation to map the "event_organizer" property in Event Class.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventOrganizer",
            cascade = {CascadeType.ALL})
    private List<Event> events;

    /**
     * Gets events.
     *
     * @return the events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Sets events.
     *
     * @param events the events
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }


    /**
     * Instantiates a new Event organizer.
     *
     * @param userName     the user name
     * @param userPassword the user password
     * @param fullName     the full name
     * @param userEmail    the user email
     */
    public EventOrganizer(String userName, String userPassword, String fullName,
                          String userEmail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.userEmail = userEmail;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user password.
     *
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets user password.
     *
     * @param userPassword the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets user email.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user email.
     *
     * @param userEmail the user email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * This Add method is for the Bi-Directional relation between "event" table and "event_organizer" table.
     *
     * @param tmpEvent the tmp event
     */
    public void addEvent(Event tmpEvent) {
        if (events == null) {
            events = new ArrayList<>();
        }

        events.add(tmpEvent);
    }

    @Override
    public String toString() {
        return "EventOrganizer{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", fullName='" + fullName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
