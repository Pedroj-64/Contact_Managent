module co.edu.uniquindio.poo.proyecto_contacto {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens co.edu.uniquindio.poo.proyecto_contacto to javafx.fxml;
    exports co.edu.uniquindio.poo.proyecto_contacto;
}