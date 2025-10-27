// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Contact;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	private static AtomicLong idGenerator = new AtomicLong();

// Contacts will include information like name, the ID, Address, etc.
// All information within Contact class.
	
	public Contact(String firstName, String lastName, String number, String address) {

// Our Contact ID
		
		this.contactID = String.valueOf(idGenerator.getAndIncrement());

// Space for first name, will fill with NULL if one isn't entered.
		
		if (firstName == null || firstName.isEmpty()) {
			this.firstName = "NULL";
			
// Will only use the first 10 characters in the name.
			
		} else if (firstName.length() > 10) {
			this.firstName = firstName.substring(0, 10);
		} else {
			this.firstName = firstName;
		}

// Sets place holder last name, if one isn't offered.
		
		if (lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
		} else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		} else {
			this.lastName = lastName;
		}
		
// Sets place holder number if there isn't one.
		
		if (number == null || number.isEmpty() || number.length() != 10) {
			this.number = "5555555555";
		} else {
			this.number = number;
		}
		
// Address logic
		
		if (address == null || address.isEmpty()) {
			this.address = "NULL";
		} else if (address.length() > 30) {
			this.address = address.substring(0, 30);
		} else {
			this.address = address;
		}
	}

// Retrieving the relevant information.
	
	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}

	public String getAddress() {
		return address;
	}

// Setting the Name. Offer a place holder.
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			this.firstName = "NULL";

// The name should always be 10 characters, this will make sure it ignores all the characters after 10.
			
		} else if (firstName.length() > 10) {
			this.firstName = firstName.substring(0, 10);
		} else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
		} else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		} else {
			this.lastName = lastName;
		}
	}
	
// Sets place holder for phone number.
	
	public void setNumber(String number) {
		if (number == null || number.isEmpty() || number.length() != 10) {
			this.number = "1111111111";
		} else {
			this.number = number;
		}
	}
	
// Sets place holder for address, if there isn't one.
	
	public void setAddress(String address) {
		if (address == null || address.isEmpty()) {
			this.address = "NULL";
		} else if (address.length() > 30) {
			this.address = address.substring(0, 30);
		} else {
			this.address = address;
		}
	}
}