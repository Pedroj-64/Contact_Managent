package co.edu.uniquindio.poo.proyecto_contacto.Model;

import co.edu.uniquindio.poo.proyecto_contacto.Model.Enumeration.TypeContact;
import co.edu.uniquindio.poo.proyecto_contacto.Model.Interfaces.ActionsContactList;
import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedList;

@Data

public class ContactManagement implements ActionsContactList {

    private LinkedList<Contact> contacts;

    public ContactManagement(){
        contacts = new LinkedList<>();
    }


    /**
     * @param name
     * @param lastName
     * @param phoneNumber
     * @param email
     * @param profilePicture
     * @param CumFatherDate
     * @param typeContact
     */
    @Override
    public void AddContact(String name, String lastName, String  phoneNumber, String email, String profilePicture,
    LocalDate CumFatherDate,
    TypeContact typeContact) {
        for (Contact c : contacts) {
            if(c.getPhoneNumber().equals(phoneNumber)){
                System.out.println("This Contact Already Exist");
            }else{
                contacts.add(new Contact(name, lastName, phoneNumber, email, CumFatherDate, profilePicture, typeContact));

            }
        }

    }

    /**
     * @param contact
     */
    @Override
    public void DeleteContact (Contact contact) throws Exception {

        for (Contact c : contacts) {
            if(contact.getPhoneNumber().equals(c.getPhoneNumber())) {
                contacts.remove(c);
            }
            else{
                throw new Exception("Contact Not Found");
            }
        }

    }

    /**
     * @param name
     *
     */
    @Override
    public void UpdateContact(String name, String lastName, String  phoneNumber, String email, String profilePicture,
                              LocalDate CumFatherDate,
                              TypeContact typeContact) {

        for (Contact c : contacts) {
            if(c.getPhoneNumber().equals(phoneNumber)){
                c.setName(name);
                c.setLastName(lastName);
                c.setPhoneNumber(phoneNumber);
                c.setEmail(email);
                c.setProfilePicture(profilePicture);
                c.setCumFatherDate(CumFatherDate);
                c.setTypeContact(typeContact);
            }
        }

    }

    /**
     * @param contact
     */
    @Override
    public void SearchContact(Contact contact) {

    }

    /**
     *
     */
    @Override
    public void ShowContactList() {

    }
}
