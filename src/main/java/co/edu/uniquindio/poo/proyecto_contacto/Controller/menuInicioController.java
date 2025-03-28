package co.edu.uniquindio.poo.proyecto_contacto.Controller;

import co.edu.uniquindio.poo.proyecto_contacto.App;
import co.edu.uniquindio.poo.proyecto_contacto.Model.Contact;
import co.edu.uniquindio.poo.proyecto_contacto.Model.ContactManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Data;
import lombok.Getter;

@Data
public class menuInicioController {

    ContactManagement contactManagement= App.getContactManager();
    @Getter
    Contact selectedContact = null;

    public ObservableList<Contact> getContacts() {
        if (contactManagement == null) {
            throw new IllegalStateException("El ContactManager no está inicializado.");
        }
        return FXCollections.observableList(contactManagement.getContacts());
    }

}
