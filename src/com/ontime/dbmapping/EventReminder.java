package com.ontime.dbmapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Event priority.
 */
@Entity
@Table(name = "event_reminder")
public class EventReminder {


    /**
     * We reference the events from Event table in our Database that we can use in the constructor.
     * Control the cascading from the "event_reminder" table to "event" table.
     * And add the OneToMany annotation to map the "event_reminder" property in Event Class.
     */
    @OneToMany(mappedBy = "eventReminder")
    private int eventReminder;

    public int getEventReminder() {
        return eventReminder;
    }

    public void setEventReminder(int eventReminder) {
        this.eventReminder = eventReminder;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private int id;

    @Column(name = "reminder_values", columnDefinition = "VARCHAR(12)")
    private String reminderValue;


    /**
     * Instantiates a new Event reminder.
     *
     * @param reminderValue the reminder value
     */
    public EventReminder(String reminderValue) {
        this.reminderValue = reminderValue;
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
     * Gets reminder value.
     *
     * @return the reminder value
     */
    public String getReminderValue() {
        return reminderValue;
    }

    /**
     * Sets reminder value.
     *
     * @param reminderValue the reminder value
     */
    public void setReminderValue(String reminderValue) {
        this.reminderValue = reminderValue;
    }


    @Override
    public String toString() {
        return "EventReminder{" +
                "id=" + id +
                ", reminderValue='" + reminderValue + '\'' +
                '}';
    }
}
