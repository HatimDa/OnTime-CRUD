package com.ontime.dbmapping;


import javax.persistence.*;
import java.util.List;

/**
 * The type Event priority.
 */
@Entity
@Table(name = "event_priority")
public class EventPriority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private int id;

    @Column(name = "priority_level", columnDefinition = "VARCHAR(8)")
    private String priorityLevel;

    /**
     * Instantiates a new Event priority.
     */
    public EventPriority(int id) {
        this.id = id;
    }

    public EventPriority(int id, String priorityLevel) {
        this.id = id;
        this.priorityLevel = priorityLevel;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * Gets priority level.
     *
     * @return the priority level
     */
    public String getPriorityLevel() {
        return priorityLevel;
    }


    /**
     * We reference the events from Event table in our Database that we can use in the Instructor.
     * Control the cascading from the "event_priority" table to "event" table.
     * And add the OneToMany annotation to map the "event_priority" property in Event Class.
     */
    @OneToMany(mappedBy = "eventPriority",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Event> events;


    @Override
    public String toString() {
        return "EventPriority{" +
                "id=" + id +
                ", priorityLevel='" + priorityLevel + '\'' +
                '}';
    }
}
