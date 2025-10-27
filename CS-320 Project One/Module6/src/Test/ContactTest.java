// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Test;

import org.junit.jupiter.api.Test;

import Contact.Contact;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

// Tests ID by making sure the value is not greater than 10
	
	@Test
	@DisplayName("Contact ID cannot have more than 10 characters")
	void testContactIDWithMoreThanTenCharacters() {
		Contact contact = new Contact("FirstName", "LastName", "PhoneNumber", "Address");
		if (contact.getContactID().length() > 10) {
			fail("Contact ID has more than 10 characters.");
		}
	}

// Tests the First name by making sure it is not greater than 10 characters
	
	@Test
	@DisplayName("Contact First Name cannot have more than 10 characters")
	void testContactFirstNameWithMoreThanTenCharacters() {
		Contact contact = new Contact("SampleSampleSample", "LastName", "PhoneNumber", "Address");
		if (contact.getFirstName().length() > 10) {
			fail("First Name has more than 10 characters.");
		}
	}

// Tests the Last name by making sure it is not greater than 10 characters
	
	@Test
	@DisplayName("Contact Last Name cannot have more than 10 characters")
	void testContactLastNameWithMoreThanTenCharacters() {
		Contact contact = new Contact("FirstName", "SampleSampleSample", "PhoneNumber", "Address");
		if (contact.getLastName().length() > 10) {
			fail("Last Name has more than 10 characters.");
		}
	}

// Makes sure the digits in the phone number are equal to 10
	
	@Test
	@DisplayName("Contact phone number is exactly 10 characters")
	void testContactNumberWithMoreThanTenCharacters() {
		Contact contact = new Contact("FirstName", "LastName", "55555555555", "Address");
		if (contact.getNumber().length() != 10) {
			fail("Phone number length does not equal 10.");
		}
	}

// Tests to make sure the address doesn't have more than 30 characters
	
	@Test
	@DisplayName("Contact address cannot have more than 30 characters")
	void testContactAddressWithMoreThanThirtyCharacters() {
		Contact contact = new Contact("FirstName", "LastName", "PhoneNumber",
				"Sample Sample Sample Sample Sample Sample" + "Sample Sample Sample Sample Sample Sample");
		if (contact.getAddress().length() > 30) {
			fail("Address has more than 30 characters.");
		}
	}

// Makes sure the first name has a non null field
	
	@Test
	@DisplayName("Contact First Name shall not be null")
	void testContactFirstNameNotNull() {
		Contact contact = new Contact(null, "LastName", "PhoneNumber", "Address");
		assertNotNull(contact.getFirstName(), "First name was null.");
	}

// Makes sure the last name has a non null field
	
	@Test
	@DisplayName("Contact Last Name shall not be null")
	void testContactLastNameNotNull() {
		Contact contact = new Contact("FirstName", null, "PhoneNumber", "Address");
		assertNotNull(contact.getLastName(), "Last name was null.");
	}

// Makes sure the phone number has a non null field
	
	@Test
	@DisplayName("Contact Phone Number shall not be null")
	void testContactPhoneNotNull() {
		Contact contact = new Contact("FirstName", "LastName", null, "Address");
		assertNotNull(contact.getNumber(), "Phone number was null.");
	}

// Makes sure the address has a non null field
	
	@Test
	@DisplayName("Contact Address shall not be null")
	void testContactAddressNotNull() {
		Contact contact = new Contact("FirstName", "LastName", "PhoneNumber", null);
		assertNotNull(contact.getAddress(), "Address was null.");
	}
}