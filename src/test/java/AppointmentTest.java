// Refactored on 10 October 2024

/*
    Author: Kyunghoon Lee
    CS-320: Module 5 Milestone
    Date: 3 October 2024
 */

// Unit tests for Appointment.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentTest {

    @Test
    @DisplayName("Test id entry")
    // Test for invalid ID (null or length > 10)
    public void testId() {

        Date currentDate = new Date (System.currentTimeMillis());
        Date afterToday = new Date(currentDate.getTime() + 100000);  // Ensures appointment date is in the future

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, afterToday, "Annual physical appointment");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678910", afterToday, "Annual physical appointment");
        });
    }

    @Test
    @DisplayName("Test appointment date entry")
    // Test for invalid appointment date (null or in the past)
    public void testDate() {

        Date currentDate = new Date(System.currentTimeMillis());

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678", null, "Annual physical appointment");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678", new Date(currentDate.getTime() - 100000), "Annual physical appointment");  // Date entry is 100000 milliseconds in the past from current system time
        });
    }

    @Test
    @DisplayName("Test appointment description entry")
    // Test for invalid appointment description (null or length > 50)
    public void testDescription() {

        Date currentDate = new Date (System.currentTimeMillis());
        Date afterToday = new Date(currentDate.getTime() + 100000);  // Ensures appointment date is in the future

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678", afterToday, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678", afterToday, "A very long appointment description that does not meet the maximum length requirements");
        });
    }
}