// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Appointment;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Calendar;
import java.util.Date;

public class Appointment {
	private final String appointmentID;
	private Date appointmentDate;
	private String appointmentDesc;
	private static AtomicLong idGenerator = new AtomicLong();
	
// References things like the date of the appointment, the ID, and the description.
// Everything is checked to make sure that it is filled, if its not filled, it will be auto-filled.

	@SuppressWarnings("deprecation")
	public Appointment(Date appointmentDate, String appointmentDesc) {
		
//The ID that is always fixed to a static value so that we don't get repeats.
// This makes it so that the rest of our code can function.
		
		this.appointmentID = String.valueOf(idGenerator.getAndIncrement());
		
		if (appointmentDate == null) {
			this.appointmentDate = new Date(2025, Calendar.JANUARY, 1);
		} else if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Cannot make appointment before current date.");
		} else {
			this.appointmentDate = appointmentDate;
		}
		
		if (appointmentDesc == null || appointmentDesc.isEmpty()) {
			this.appointmentDesc = "NULL";
		} else if (appointmentDesc.length() > 50) {
			this.appointmentDesc = appointmentDesc.substring(0, 50);
		} else {
			this.appointmentDesc = appointmentDesc;
		}
	}
	
	// Fetches appointment ID
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	
//Logic to set a Date
	
	@SuppressWarnings("deprecation")
	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate == null) {
			appointmentDate = new Date(2025, Calendar.JANUARY, 1);
		} else if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Cannot make appointment before current date.");
		} else {
			this.appointmentDate = appointmentDate;
		}
	}
	
	public void setAppointmentDesc(String appointmentDesc) {
		if (appointmentDesc == null || appointmentDesc.isEmpty()) {
			this.appointmentDesc = "NULL";
		} else if (appointmentDesc.length() > 50) {
			this.appointmentDesc = appointmentDesc.substring(0, 50);
		} else {
			this.appointmentDesc = appointmentDesc;
		}
	}
}