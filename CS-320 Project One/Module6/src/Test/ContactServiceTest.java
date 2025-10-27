// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import Contact.Contact;
import Contact.ContactService;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceTest {
	
// Change First name in the update
	
    @Test
    @DisplayName("Test to Update First Name.")
    @Order(1)
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        service.addContact("Jeff", "Danny", "1111111111", "123 Street ST");
        String id = service.contactList.get(0).getContactID();

        service.updateFirstName("Sam", id);
        service.displayContactList();
        assertEquals("Sam", service.getContact(id).getFirstName(), "First name was not updated.");
    }

// Change Last name in the update    
    
    @Test
    @DisplayName("Test to Update Last Name.")
    @Order(2)
    void testUpdateLastName() {
        ContactService service = new ContactService();
        service.addContact("Jeff", "Danny", "1111111111", "123 Street ST");
        String id = service.contactList.get(0).getContactID();

        service.updateLastName("Jeffrey", id);
        service.displayContactList();
        assertEquals("Jeffrey", service.getContact(id).getLastName(), "Last name was not updated.");
    }

// Change Phone number in the update    
    
    @Test
    @DisplayName("Test to update phone number.")
    @Order(3)
    void testUpdatePhoneNumber() {
        ContactService service = new ContactService();
        service.addContact("Jeff", "Danny", "2222222222", "123 Street St");
        String id = service.contactList.get(0).getContactID();

        service.updateNumber("1111111111", id);
        service.displayContactList();
        assertEquals("1111111111", service.getContact(id).getNumber(), "Phone number was not updated.");
    }

// Update Address in the update    
    
    @Test
    @DisplayName("Test to update address.")
    @Order(4)
    void testUpdateAddress() {
        ContactService service = new ContactService();
        service.addContact("Jeff", "Danny", "1111111111", "123 Street ST");
        String id = service.contactList.get(0).getContactID();

        service.updateAddress("123 Carole BLVD", id);
        service.displayContactList();
        assertEquals("123 Carole BLVD", service.getContact(id).getAddress(), "Address was not updated.");
    }

// Checks Delete functionality    
    
    @Test
    @DisplayName("Test to ensure that service correctly deletes contacts.")
    @Order(5)
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact("Jeff", "Danny", "1111111111", "123 Street ST");
        String id = service.contactList.get(0).getContactID();

        service.deleteContact(id);
        ArrayList<Contact> contactListEmpty = new ArrayList<>();
        service.displayContactList();
        assertEquals(contactListEmpty, service.contactList, "The contact was not deleted.");
    }

// Checks Add contact functionality    
    
    @Test
    @DisplayName("Test to ensure that service can add a contact.")
    @Order(6)
    void testAddContact() {
        ContactService service = new ContactService();
        service.addContact("Jeff", "Danny", "1111111111", "123 Street ST");
        String id = service.contactList.get(0).getContactID();

        service.displayContactList();
        assertNotNull(service.getContact(id), "Contact was not added correctly.");
    }
}