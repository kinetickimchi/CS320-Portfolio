// Refactored on 10 October 2024

/*
    Author: Kyunghoon Lee
    CS-320: Module 4 Milestone
    Date: 28 September 2024
 */

// Task.java class

public class Task {

    // Instance variables
    private String id;  // Max 10 chars, not null, not updatable
    private String name;  // Max 20 characters, not null
    private String description;  // Max 50 characters, not null

    // Default parametrized constructor with input validation
    public Task(String id, String name, String description) {

        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("ID entry is not valid");
        }

        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name entry is not valid");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description entry is not valid");
        }

        // Assign values if valid
        this.id = id;
        this.name = name;
        this.description = description;

    }

    // Getter functions
    public String getId() {
        return (id);
    }

    public String getName() {
        return (name);
    }

    public String getDescription() {
        return (description);
    }

    // Setter functions with input validation
    // No setter for id because it should not change

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name entry is not valid");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description entry is not valid");
        }
        this.description = description;
    }
}

