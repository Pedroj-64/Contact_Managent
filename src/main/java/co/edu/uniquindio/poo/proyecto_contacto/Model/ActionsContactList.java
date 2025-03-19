package co.edu.uniquindio.poo.proyecto_contacto.Model;

import java.time.LocalDate;

public interface ActionsContactList {

    public void AddContact(String name, String lastName, String phoneNumber, String email, String profilePicture,
    LocalDate CumFatherDate,
    TypeContact typeContact);
    public void DeleteContact(Contact contact) throws Exception;
    public void UpdateContact(String name, String lastName, String  phoneNumber, String email, String profilePicture,
                              LocalDate CumFatherDate,
                              TypeContact typeContact);
    public void SearchContact(Contact contact);
    public void ShowContactList();
}
