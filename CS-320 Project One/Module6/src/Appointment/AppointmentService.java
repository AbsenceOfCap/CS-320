// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	
// This array holds all of our appointments, for access later.
	
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

// The code to display the list.
	
	public void displayAppointmentList() {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			System.out.println("\t Appointment ID: " + appointmentList.get(counter).getAppointmentID());
			System.out.println("\t Appointment Date: " + appointmentList.get(counter).getAppointmentDate());
			System.out.println("\t Appointment Description: " + appointmentList.get(counter).getAppointmentDesc());
		}
	}

// Borrows from Appointment.java to add a new appointment.
	
	public void addAppointment(Date appointmentDate, String appointmentDesc) {
		Appointment appointment = new Appointment(appointmentDate, appointmentDesc);
		appointmentList.add(appointment);
	}

	public Appointment getAppointment(String appointmentID) {
		Appointment appointment = new Appointment(null, null);
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().contentEquals(appointmentID)) {
				appointment = appointmentList.get(counter);
			}
		}
		return appointment;
	}
	
// Logic for deleting appointment.
// Uses the ID to find the proper appointment to delete.
	
	public void deleteAppointment(String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointmentList.remove(counter);
				break;
			}
			if (counter == appointmentList.size() - 1) {
				System.out.println("Appointment ID: " + appointmentID + " not found.");
			}
		}
	}

// Updates appointment.
	
	public void updateAppointmentDate(Date updatedDate, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointmentList.get(counter).setAppointmentDate(updatedDate);
				break;
			}
			if (counter == appointmentList.size() - 1) {
				System.out.println("Appointment ID: " + appointmentID + " not found.");
			}
		}
	}

// Adds description to our appointment.
	
	public void updateAppointmentDesc(String updatedString, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointmentList.get(counter).setAppointmentDesc(updatedString);
				break;
			}
			if (counter == appointmentList.size() - 1) {
				System.out.println("Appointment ID: " + appointmentID + " not found.");
			}
		}
	}
}