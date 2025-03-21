module co.edu.uniquindio.poo.proyecto_contacto {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens co.edu.uniquindio.poo.proyecto_contacto to javafx.fxml;
    exports co.edu.uniquindio.poo.proyecto_contacto;


    opens co.edu.uniquindio.poo.proyecto_contacto.ViewController to javafx.fxml;
    exports co.edu.uniquindio.poo.proyecto_contacto.ViewController;

    opens co.edu.uniquindio.poo.proyecto_contacto.Controller to javafx.fxml;
    exports co.edu.uniquindio.poo.proyecto_contacto.Controller;


}