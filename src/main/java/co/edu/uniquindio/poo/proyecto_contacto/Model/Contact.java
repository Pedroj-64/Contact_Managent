package co.edu.uniquindio.poo.proyecto_contacto.Model;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDate;

@Data
public class Contact{
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate CumFatherDate;
    private String profilePicture;
    private TypeContact typeContact;


    public Contact(String name, String lastName, String phoneNumber, String email, LocalDate CumFatherDate, String profilePicture, TypeContact typeContact) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.CumFatherDate = CumFatherDate;
        this.profilePicture = profilePicture;
        this.typeContact = typeContact;
    }



}
