// Refactored on 10 October 2024

/*
    Author: Kyunghoon Lee
    CS-320: Module 4 Milestone
    Date: 28 September 2024
 */

// Unit tests for Task.java


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    @DisplayName("Test id entry")
    // Test for invalid ID (null or length > 10)
    public void testId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Submit Assignments", "Submit assignments by Sunday");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678910", "Submit Assignments", "Submit assignments by Sunday");
        });
    }

    @Test
    @DisplayName("Test name entry")
    // Test for invalid task name (null or length > 20)
    public void testName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678", null, "Submit assignments by Sunday");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678", "Submit All Homework Assignments", "Submit assignments by Sunday");
        });
    }

    @Test
    @DisplayName("Test description entry")
    // Test for invalid task description (null or length > 50)
    public void testDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678", "Submit Assignments", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678", "Submit Assignments", "Make sure that you submit all of your assignments by Sunday, otherwise they will be considered late");
        });
    }

}