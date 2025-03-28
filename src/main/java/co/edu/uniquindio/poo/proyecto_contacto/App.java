package co.edu.uniquindio.poo.proyecto_contacto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) {

        try {
            // Cargar la escena de introducción desde el archivo FXML
            scene = new Scene(loadFXML("Interfaz"), 600, 340);
            stage.setScene(scene); // Establecer la escena en el escenario
            stage.show(); // Mostrar la escena
        } catch (IOException e) {
            showAlert("Error al cargar la interfaz", "No se pudo cargar el archivo FXML: " + e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    /**
     * Carga y establece una nueva escena en la ventana principal.
     *
     * @param fxml El nombre del archivo FXML.
     * @param width El ancho de la nueva escena.
     * @param height La altura de la nueva escena.
     */
    public static void loadScene(String fxml, double width, double height) {
        try {
            Parent root = loadFXML(fxml);
            scene.setRoot(root);
            scene.getWindow().setWidth(width);
            scene.getWindow().setHeight(height);

        } catch (IOException e) {
            showAlert("Error al cambiar la vista", "No se pudo cargar el archivo FXML: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    /**
     * Carga un archivo FXML y devuelve el nodo raíz.
     *
     * @param fxml El nombre del archivo FXML.
     * @return El nodo raíz del archivo FXML cargado.
     * @throws IOException Si ocurre un error al cargar el archivo.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load(); // Cargar y devolver el nodo raíz del archivo FXML
    }

    /**
     * Muestra una alerta con el mensaje especificado.
     *
     * @param title El título de la alerta.
     * @param message El contenido del mensaje.
     * @param type El tipo de alerta.
     */
    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type); // Crear la alerta
        alert.setTitle(title); // Establecer el título de la alerta
        alert.setHeaderText(null); // No usar encabezado
        alert.setContentText(message); // Establecer el contenido del mensaje
        alert.showAndWait(); // Mostrar la alerta y esperar a que el usuario la cierre
    }

    /**
     * Muestra una alerta y redirige a una nueva escena al cerrar la alerta.
     *
     * @param title El título de la alerta.
     * @param message El contenido del mensaje.
     * @param type El tipo de alerta.
     * @param fxml El nombre del archivo FXML de la nueva escena.
     * @param width El ancho de la nueva escena.
     * @param height La altura de la nueva escena.
     */
    public static void showAlertAndRedirect(String title, String message, Alert.AlertType type, String fxml, double width, double height) {
        Alert alert = new Alert(type); // Crear la alerta
        alert.setTitle(title); // Establecer el título
        alert.setHeaderText(null); // Sin encabezado
        alert.setContentText(message); // Mensaje

        // Redirigir a una nueva escena al cerrar la alerta
        alert.setOnHidden(evt -> loadScene(fxml, width, height));
        alert.show(); // Mostrar la alerta
    }

    public static void main(String[] args) {
        launch();
    }

}