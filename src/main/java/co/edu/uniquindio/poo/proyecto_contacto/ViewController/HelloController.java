package co.edu.uniquindio.poo.proyecto_contacto.ViewController;

import co.edu.uniquindio.poo.proyecto_contacto.Model.Contact;
import co.edu.uniquindio.poo.proyecto_contacto.Model.ContactManagement;
import co.edu.uniquindio.poo.proyecto_contacto.Model.Enumeration.TypeContact;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField txtName, txtLastName, txtPhoneNumber, txtEmail;

    @FXML
    private DatePicker txtCumFatherDate;

    @FXML
    private ComboBox<TypeContact> txtTypeContact;

    @FXML
    private TableView<Contact> tableContacts;

    @FXML
    private TableColumn<Contact, String> colName, colLastName, colPhoneNumber, colEmail, colTypeContact;

    private final ContactManagement contactManagement;

    private Contact selectedContact;

    private ObservableList<Contact> contactsObservable;

    public HelloController() {
        contactManagement = new ContactManagement();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        colLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
        colPhoneNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneNumber()));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        colTypeContact.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTypeContact().toString()));

        txtTypeContact.setItems(FXCollections.observableArrayList(TypeContact.values()));

        contactsObservable = FXCollections.observableArrayList();
        loadContacts();

        tableContacts.setOnMouseClicked(e -> {
            selectedContact = tableContacts.getSelectionModel().getSelectedItem();
            if (selectedContact != null) {
                txtName.setText(selectedContact.getName());
                txtLastName.setText(selectedContact.getLastName());
                txtPhoneNumber.setText(selectedContact.getPhoneNumber());
                txtEmail.setText(selectedContact.getEmail());
                txtCumFatherDate.setValue(selectedContact.getCumFatherDate());
                txtTypeContact.setValue(selectedContact.getTypeContact());
            }
        });
    }

    public void addContact(ActionEvent e) {
        try {
            contactManagement.AddContact(
                    txtName.getText(),
                    txtLastName.getText(),
                    txtPhoneNumber.getText(),
                    txtEmail.getText(),
                    "",  // Aquí iría la foto de perfil si se implementa
                    txtCumFatherDate.getValue(),
                    txtTypeContact.getValue()
            );
            clearFields();
            updateContacts();
            showAlert("Contact added successfully", Alert.AlertType.INFORMATION);
        } catch (Exception ex) {
            showAlert(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void deleteContact(ActionEvent e) {
        if (selectedContact != null) {
            try {
                contactManagement.DeleteContact(selectedContact);
                clearFields();
                updateContacts();
                showAlert("Contact deleted successfully", Alert.AlertType.INFORMATION);
            } catch (Exception ex) {
                showAlert(ex.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            showAlert("Select a contact from the table", Alert.AlertType.WARNING);
        }
    }

    public void updateContact(ActionEvent e) {
        if (selectedContact != null) {
            try {
                contactManagement.UpdateContact(
                        txtName.getText(),
                        txtLastName.getText(),
                        txtPhoneNumber.getText(),
                        txtEmail.getText(),
                        "",  // Aquí iría la foto de perfil si se implementa
                        txtCumFatherDate.getValue(),
                        txtTypeContact.getValue()
                );
                clearFields();
                updateContacts();
                showAlert("Contact updated successfully", Alert.AlertType.INFORMATION);
            } catch (Exception ex) {
                showAlert(ex.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            showAlert("Select a contact from the table", Alert.AlertType.WARNING);
        }
    }

    private void loadContacts() {
        contactsObservable.setAll(contactManagement.getContacts());
        tableContacts.setItems(contactsObservable);
    }

    private void updateContacts() {
        contactsObservable.setAll(contactManagement.getContacts());
    }

    private void showAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    private void clearFields() {
        txtName.clear();
        txtLastName.clear();
        txtPhoneNumber.clear();
        txtEmail.clear();
        txtCumFatherDate.setValue(null);
        txtTypeContact.setValue(null);
    }
}
