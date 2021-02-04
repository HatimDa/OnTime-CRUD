package com.ontime.dbmapping;

import com.mysql.jdbc.NonRegisteringDriver;

import javax.persistence.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;


/**
 * The type Event.
 */
@Entity
@Table(name = "event")

public class Event {

    /**
     * Mapping each column from "event table" into it's proper variable in Event class
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private int id;

    @Column(name = "event_name", columnDefinition = "VARCHAR(45)")
    private String eventName;

    @Column(name = "duration", columnDefinition = "VARCHAR(45)")
    private String eventDuration;

    @Column(name = "event_address", columnDefinition = "VARCHAR(45)")
    private String eventAddress;


    @Column(name = "event_date", columnDefinition = "DATETIME")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date eventDate;

    @Lob
    @Column(name = "attachment", columnDefinition = "BLOB")
    private byte[] eventAttachment;

    /**
     * Specify (n-1) relationship between "event" table and "priority" table.
     * Control the cascading from the "event" table to "event_priority" table.
     * Join the FK "event_priority_id" in "event" table with the PK "id" in "event_priority" table.
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "event_priority_id", columnDefinition = "INT(11)")
    private int eventPriority;


    /**
     * Gets event priority.
     *
     * @return the event priority
     */
    public int getEventPriority() {
        return eventPriority;
    }

    /**
     * Sets event priority.
     *
     * @param eventPriority the event priority
     */
    public void setEventPriority(int eventPriority) {
        this.eventPriority = eventPriority;
    }


    /**
     * Specify (n-1) relationship between "event" table and "event_organizer" table.
     * Control the cascading from the "event" table to "event_organizer" table.
     * Join the FK "event_organizer_id" in "event" table with the PK "id" in "event_organizer" table.
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "event_organizer_id", columnDefinition = "INT(11)")
    private EventOrganizer eventOrganizer;

    /**
     * Gets event organizer.
     *
     * @return the event organizer
     */
    public EventOrganizer getEventOrganizer() {
        return eventOrganizer;
    }

    /**
     * Sets event organizer.
     *
     * @param eventOrganizer the event organizer
     */
    public void setEventOrganizer(EventOrganizer eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }


    /**
     * Specify (n-1) relationship between "event" table and "event_reminder" table.
     * Control the cascading from the "event" table to "event_reminder" table.
     * Join the FK "event_reminder_id" in "event" table with the PK "id" in "event_reminder" table.
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "event_reminder_id", columnDefinition = "INT(11)")
    private EventReminder eventReminder;

    /**
     * Gets event reminder.
     *
     * @return the event reminder
     */
    public EventReminder getEventReminder() {
        return eventReminder;
    }

    /**
     * Sets event reminder.
     *
     * @param eventReminder the event reminder
     */
    public void setEventReminder(EventReminder eventReminder) {
        this.eventReminder = eventReminder;
    }


    /**
     * Instantiates a new Event.
     *
     * @param eventName     the event name
     * @param eventDuration the event duration
     * @param eventAddress  the event address
     * @param eventDate     the event date
     */
    public Event(String eventName, String eventDuration, String eventAddress, Date eventDate) {
        this.eventName = eventName;
        this.eventDuration = eventDuration;
        this.eventAddress = eventAddress;
        this.eventDate = eventDate;
        this.eventDate = eventDate;

    }

    /**
     * Instantiates a new Event.
     *
     * @param eventName       the event name
     * @param eventDuration   the event duration
     * @param eventAddress    the event address
     * @param eventDate       the event date
     * @param eventAttachment the event attachment
     */
    public Event(String eventName, String eventDuration, String eventAddress, Date eventDate, byte[] eventAttachment) {
        this.eventName = eventName;
        this.eventDuration = eventDuration;
        this.eventAddress = eventAddress;
        this.eventDate = eventDate;
        this.eventDate = eventDate;
        this.eventAttachment = eventAttachment;
    }

    public Event() {

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
     * Gets event name.
     *
     * @return the event name
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets event name.
     *
     * @param eventName the event name
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Gets event duration.
     *
     * @return the event duration
     */
    public String getEventDuration() {
        return eventDuration;
    }

    /**
     * Sets event duration.
     *
     * @param eventDuration the event duration
     */
    public void setEventDuration(String eventDuration) {
        this.eventDuration = eventDuration;
    }

    /**
     * Gets event address.
     *
     * @return the event address
     */
    public String getEventAddress() {
        return eventAddress;
    }

    /**
     * Sets event address.
     *
     * @param eventAddress the event address
     */
    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    /**
     * Gets event date.
     *
     * @return the event date
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * Sets event date.
     *
     * @param eventDate the event date
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /*
     */

    /**
     * Get event attachment byte [ ].
     *
     * @return the byte [ ]
     */

    public byte[] getEventAttachment() {

        return eventAttachment;
    }


    /**
     * Sets event attachment.
     *
     * @param eventAttachment the event attachment
     */

    public void setEventAttachment(byte[] eventAttachment) {
        this.eventAttachment = eventAttachment;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", eventDuration=" + eventDuration +
                ", eventAddress='" + eventAddress + '\'' +
                ", eventDate=" + eventDate +
//                ", eventAttachment=" + Arrays.toString(eventAttachment) +
                '}';
    }
}
