package co.edu.uniquindio.poo.proyecto_contacto.Model;

import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.NoSuchElementException;

@Data
public class ContactManagement implements ActionsContactList {
    private static volatile ContactManagement instance;
    private LinkedList<Contact> contacts;

    private ContactManagement() {
        contacts = new LinkedList<>();
    }

    public static ContactManagement getInstance() {
        if (instance == null) {
            synchronized (ContactManagement.class) {
                if (instance == null) {
                    instance = new ContactManagement();
                }
            }
        }
        return instance;
    }

    @Override
    public void AddContact(String name, String lastName, String phoneNumber, String email, String profilePicture,
                           LocalDate CumFatherDate, TypeContact typeContact) {
        if (name == null || lastName == null || phoneNumber == null || email == null || typeContact == null) {
            throw new IllegalArgumentException("All fields must be filled");
        }

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {

            }
        }

        contacts.add(new Contact(name, lastName, phoneNumber, email, CumFatherDate, profilePicture, typeContact));
    }

    @Override
    public void DeleteContact(Contact contact) throws NoSuchElementException {
        if (!contacts.remove(contact)) {
            throw new NoSuchElementException("Contact Not Found");
        }
    }

    @Override
    public void UpdateContact(String name, String lastName, String phoneNumber, String email, String profilePicture,
                              LocalDate CumFatherDate, TypeContact typeContact) throws NoSuchElementException {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                c.setName(name);
                c.setLastName(lastName);
                c.setPhoneNumber(phoneNumber);
                c.setEmail(email);
                c.setProfilePicture(profilePicture);
                c.setCumFatherDate(CumFatherDate);
                c.setTypeContact(typeContact);
                return;
            }
        }
        throw new NoSuchElementException("Contact Not Found");
    }

    @Override
    public Contact SearchContactName(String name) throws NoSuchElementException {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        return contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Contact not found"));
    }

    @Override
    public Contact SearchContactPhoneNumber(String phoneNumber) throws NoSuchElementException {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }

        return contacts.stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Contact not found"));
    }
}
