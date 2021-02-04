package com.ontime.dbmapping;

import javax.persistence.*;

/**
 * The type Event priority.
 */
@Entity
@Table(name = "event_reminder")
public class EventReminder {


/*    *//**
     * We reference the events from Event table in our Database that we can use in the constructor.
     * Control the cascading from the "event_reminder" table to "event" table.
     * And add the OneToMany annotation to map the "event_reminder" property in Event Class.
     *//*
    @OneToMany(mappedBy = "eventReminder",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Event> events;*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private int id;

    @Column(name = "reminder_values", columnDefinition = "VARCHAR(12)")
    private String reminderValue;

    public EventReminder(int id){
        this.id = id;
    }

    public EventReminder(int id, String reminderValue) {
        this.id = id;
        this.reminderValue = reminderValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReminderValue() {
        return reminderValue;
    }

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
