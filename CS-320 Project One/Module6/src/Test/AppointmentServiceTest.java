// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;

class AppointmentServiceTest {
	
// Sends date object in the future from the current day.
	
    private Date futureDate(int offsetDays) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, offsetDays);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
//Logic to test the appointment.
    
    @Test
    @DisplayName("Add an appointment")
    @Order(1)
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(futureDate(1), "Test Appointment");

        Appointment appt = service.appointmentList.get(service.appointmentList.size() - 1);
        String id = appt.getAppointmentID();

        service.displayAppointmentList();
        assertNotNull(service.getAppointment(id), "Appointment was not added correctly.");
    }

 //Logic to Update the appointment Date.
    
    @Test
    @DisplayName("Update appointment date")
    @Order(2)
    void testUpdateAppointmentDate() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(futureDate(1), "Test Appointment");

        Appointment appt = service.appointmentList.get(service.appointmentList.size() - 1);
        String id = appt.getAppointmentID();

        service.updateAppointmentDate(futureDate(365), id);

        service.displayAppointmentList();
        assertEquals(futureDate(365),
                service.getAppointment(id).getAppointmentDate(),
                "Appointment date was not updated.");
    }

// Test to make sure the description is updated.    
    
    @Test
    @DisplayName("Update appointment description")
    @Order(3)
    void testUpdateAppointmentDesc() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(futureDate(1), "Original Description");

        Appointment appt = service.appointmentList.get(service.appointmentList.size() - 1);
        String id = appt.getAppointmentID();

        service.updateAppointmentDesc("Updated Description", id);

        service.displayAppointmentList();
        assertEquals("Updated Description",
                service.getAppointment(id).getAppointmentDesc(),
                "Appointment description was not updated.");
    }

// Test to Delete the appointment.    
    
    @Test
    @DisplayName("Delete an appointment")
    @Order(4)
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(futureDate(1), "Appointment to Delete");

        Appointment appt = service.appointmentList.get(service.appointmentList.size() - 1);
        String id = appt.getAppointmentID();

        service.deleteAppointment(id);

        ArrayList<Appointment> emptyList = new ArrayList<>();
        service.displayAppointmentList();
        assertEquals(emptyList, service.appointmentList, "Appointment was not deleted correctly.");
    }
}
