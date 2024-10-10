// Refactored on 10 October 2024

/*
    Author: Kyunghoon Lee
    CS-320: Module 5 Milestone
    Date: 3 October 2024
 */

// Unit tests for AppointmentService.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentServiceTest {
    private AppointmentService appointmentService;  // Create AppointmentService instance for testing

    @BeforeEach
    // Run AppointmentService before executing each test
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    @DisplayName("Testing addAppointment")
    // Testing addAppointment function
    public void testAddAppointment() {

        Date currentDate = new Date (System.currentTimeMillis());
        Date afterToday = new Date(currentDate.getTime() + 100000);  // Ensures appointment date is in the future

        Appointment appointment = new Appointment("12345678", afterToday, "Annual physical appointment");  // Create new appointment with the given parameters

        assertTrue(appointmentService.addAppointment(appointment));  // Does adding the appointment return true?
        assertEquals(1, appointmentService.list.size());  // Is the number of tasks in the list correct after addition?
        assertFalse(appointmentService.addAppointment(appointment));  // Does adding the same appointment (duplicate id) return false?
    }

    @Test
    @DisplayName("Testing addAppointment with multiple appointments")
    // Testing addAppointment function with multiple appointments
    public void testAddMultipleAppointments() {

        Date currentDate = new Date (System.currentTimeMillis());
        Date afterToday = new Date(currentDate.getTime() + 100000);  // Ensures appointment date is in the future

        // Create 3 appointments with these parameters
        Appointment appointment1 = new Appointment("1", afterToday, "Annual physical appointment");
        Appointment appointment2 = new Appointment("2", new Date(currentDate.getTime() + 200000), "Dentist appointment");
        Appointment appointment3 = new Appointment("3", new Date(currentDate.getTime() + 300000), "Optometry appointment");

        // Add appointment1, appointment2, appointment3 to list
        assertTrue(appointmentService.addAppointment(appointment1));
        assertTrue(appointmentService.addAppointment(appointment2));
        assertTrue(appointmentService.addAppointment(appointment3));

        assertEquals(3, appointmentService.list.size());  // Are there now 3 appointments in the list?

        // Do the appointment descriptions at these positions in the array match these expected values?
        assertEquals("Annual physical appointment", appointmentService.list.get(0).getDescription());
        assertEquals("Dentist appointment", appointmentService.list.get(1).getDescription());
        assertEquals("Optometry appointment", appointmentService.list.get(2).getDescription());
    }

    @Test
    @DisplayName("Testing deleteAppointment")
    // Testing deleteAppointment function
    public void testDeleteAppointment() {

        Date currentDate = new Date (System.currentTimeMillis());
        Date afterToday = new Date(currentDate.getTime() + 100000);  // Ensures appointment date is in the future

        Appointment appointment = new Appointment("12345678", afterToday, "Annual physical appointment");  // Create new appointment with the given parameters

        appointmentService.addAppointment(appointment);  // Add the appointment
        assertTrue(appointmentService.deleteAppointment("12345678"));  // Does this remove the added appointment with this id?
        assertFalse(appointmentService.deleteAppointment("12345678"));  // Does removing a task that has been deleted already return false?
    }

    @Test
    @DisplayName("Test deleteAppointment with nonexistent ID")
    // Test deleteAppointment with nonexistent ID
    public void testDeleteNonExistentAppointment() {
        assertFalse(appointmentService.deleteAppointment("fakeID"));  // When the ID "fakeID" is passed, does this return false?
    }
}