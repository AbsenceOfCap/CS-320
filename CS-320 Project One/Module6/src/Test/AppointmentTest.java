// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

class AppointmentTest {
	
	   private Date futureDate(int offsetDays) {
	        Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.DAY_OF_YEAR, offsetDays);
	        cal.set(Calendar.HOUR_OF_DAY, 0);
	        cal.set(Calendar.MINUTE, 0);
	        cal.set(Calendar.SECOND, 0);
	        cal.set(Calendar.MILLISECOND, 0);
	        return cal.getTime();
	    }

// Makes sure ID is 10 or less characters    
    
    @Test
    @DisplayName("Appointment ID cannot have more than 10 characters")
    void testAppointmentIDWithMoreThanTenCharacters() {
        Appointment appointment = new Appointment(futureDate(1), "Description");
        if (appointment.getAppointmentID().length() > 10) {
            fail("Appointment ID has more than 10 characters.");
        }
    }

// Makes sure description is 50 or less characters    
    
    @Test
    @DisplayName("Description cannot have more than 50 characters")
    void testAppointmentDescWithMoreThanFiftyCharacters() {
        String longDesc = "123456789 is nine characters long"
                        + "123456789 is another nine characters long"
                        + "123456789 is another nine characters long"
                        + "123456789 is another nine characters long";

        Appointment appointment = new Appointment(futureDate(1), longDesc);
        if (appointment.getAppointmentDesc().length() > 50) {
            fail("Description has more than 50 characters.");
        }
    }

// Checks to see if the appointment is the current date or before    
    
    @Test
    @DisplayName("Appointment Date cannot be before current date")
    void testAppointmentDateBeforeCurrent() {
        // Using future date ensures no IllegalArgumentException
        Appointment appointment = new Appointment(futureDate(1), "Description");
        assertFalse(appointment.getAppointmentDate().before(new Date()), "Date is before current date.");
    }

// Makes sure a date is set    
    
    @Test
    @DisplayName("Date shall not be null")
    void testAppointmentDateNotNull() {
        Appointment appointment = new Appointment(null, "Description");
        assertNotNull(appointment.getAppointmentDate(), "Date was null.");
    }

// Makes sure a description is set    
    
    @Test
    @DisplayName("Description shall not be null")
    void testAppointmentDescNotNull() {
        Appointment appointment = new Appointment(futureDate(1), null);
        assertNotNull(appointment.getAppointmentDesc(), "Description was null.");
    }
}