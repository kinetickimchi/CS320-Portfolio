// Refactored on 10 October 2024

/*
    Author: Kyunghoon Lee
    CS-320: Module 3 Milestone
    Date: 21 September 2024
 */

// Unit tests for Contact.java

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {

   @Test
   @DisplayName("Test id entry")
   // Test for invalid ID (null or length > 10)
   public void testId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Lebron", "James", "1234567890", "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678910", "Lebron", "James", "1234567890", "123 Main Street");
        });
    }

    @Test
    @DisplayName("Test firstName entry")
    // Test for invalid firstName (null or length > 10)
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", null, "James", "1234567890", "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", "LebronLebron", "James", "1234567890", "123 Main Street");
        });
    }

    @Test
    @DisplayName("Test lastName entry")
    // Test for invalid lastName (null or length > 10)
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", "Lebron", null, "1234567890", "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", "Lebron", "JamesJamesJames", "1234567890", "123 Main Street");
        });
    }

    @Test
    @DisplayName("Test phoneNumber entry")
    // Test for invalid phoneNumber (null, length != 10, or includes non-digit characters)
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", "Lebron", "James", null, "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", "Lebron", "James", "123456789", "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", "Lebron", "James", "123456789a", "123 Main Street");
        });
    }

    @Test
    @DisplayName("Test address entry")
    // Test for invalid address (null or length > 30)
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", "Lebron", "James", "1234567890", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", "Lebron", "James", "1234567890", "123 Main Street 123 Main Street 123 Main Street");
        });
    }
}