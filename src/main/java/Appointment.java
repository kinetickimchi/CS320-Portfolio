// Refactored on 10 October 2024

/*
    Author: Kyunghoon Lee
    CS-320: Module 5 Milestone
    Date: 3 October 2024
 */

// Appointment.java class

import java.util.Date;

public class Appointment {

    private String id;  // Max 10 characters, not null, not updatable
    private Date date;  // Cannot be in the past, not null
    private String description;  // Max 50 characters, not null

    // Default parametrized constructor with input validation
    public Appointment(String id, Date date, String description) {

        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Appointment ID is not valid");
        }

        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Appointment date is not valid");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description entry is not valid");
        }

        // Assign values if valid
        this.id = id;
        this.date = date;
        this.description = description;
    }

    // Getter methods
    public String getId() {
        return (id);
    }

    public Date getDate() {
        return (date);
    }

    public String getDescription() {
        return (description);
    }

    // Setter methods with input validation
    // No setter for ID because it should not change
    public void setDate(Date date) {
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Appointment date is not valid");
        }
        this.date = date;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description entry is not valid");
        }
        this.description = description;
    }
}
