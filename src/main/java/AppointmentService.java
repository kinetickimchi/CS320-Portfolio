// Refactored on 10 October 2024

/*
    Author: Kyunghoon Lee
    CS-320: Module 5 Milestone
    Date: 3 October 2024
 */

// AppointmentService.java class

import java.util.ArrayList;

public class AppointmentService {

    ArrayList<Appointment> list = new ArrayList<Appointment>();

    // addAppointment function (IDs must be unique)
    public boolean addAppointment(Appointment appointment) {  // Create Appointment and pass appointment object
        for (Appointment a : list) {  // for each appointment a in the list
            if (appointment.getId().equalsIgnoreCase(a.getId())) {  // if a matching appointment ID is found
                return false;  // it is a duplicate ID, do not add
            }
        }
        // if an ID match does not exist, add to the list
        list.add(appointment);
        return true;
    }

    // deleteAppointment function (IDs must be unique)
    public boolean deleteAppointment(String id) {
        return list.removeIf(appointment -> appointment.getId().equalsIgnoreCase(id));  // remove appointment associated with ID if match is found
    }
}
