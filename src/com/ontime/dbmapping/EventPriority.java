package com.ontime.dbmapping;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Event priority.
 */
@Entity
@Table(name = "event_priority")
public class EventPriority {

    /**
     * We reference the events from Event table in our Database that we can use in the Instructor.
     * Control the cascading from the "event_priority" table to "event" table.
     * And add the OneToMany annotation to map the "event_priority" property in Event Class.
     */
    @OneToMany(mappedBy = "eventPriority")
    private int eventPriority;


    public int getEventPriority() {
        return eventPriority;
    }

    public void setEventPriority(int eventPriority) {
        this.eventPriority = eventPriority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private int id;

    @Column(name = "priority_level", columnDefinition = "VARCHAR(8)")
    private String priorityLevel;


    /**
     * Instantiates a new Event priority.
     */
    public EventPriority() {

    }
    

    @Override
    public String toString() {
        return "EventPriority{" +
                "id=" + id +
                ", priorityLevel='" + priorityLevel + '\'' +
                '}';
    }
}
