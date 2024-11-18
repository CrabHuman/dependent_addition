package edu.gmu.cs321;
import java.io.IOException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DataEntryScreen extends Screen{
    private DependentForm dependentForm;
    @FXML
    private TextField fxParentFirstName;
    @FXML
    private TextField fxParentLastName;
    @FXML
    private TextField fxParentID;
    @FXML
    private TextField fxParentDateOfBirth;
    @FXML
    private TextField fxParentAddress;
    @FXML
    private TextField fxParentPhoneNumber;
    @FXML
    private TextField fxParentEmail;

    @FXML
    private TextField fxDependentFirstName;
    @FXML
    private TextField fxDependentLastName;
    @FXML
    private TextField fxDependentID;
    @FXML
    private TextField fxDependentDateOfBirth;
    @FXML
    private TextField fxDependentAddress;
    @FXML
    private TextField fxDependentPhoneNumber;
    @FXML
    private TextField fxDependentEmail;
    @FXML
    private TextField fxDependentParentID;

    private List<DependentForm> formStorage = new ArrayList<>();


    /**
     * Handles the action when the "Back" button is pressed.
     */
    @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
        App.setRoot("main");  
    }
    /**
     * Handles the action when the "Submit" button is pressed.
     */
    @FXML
    private void submitFormData(ActionEvent event) {
        try {
            // Validate input fields
            if (isAnyFieldEmpty()) {
                showError("Validation Error", "Please fill out all fields.");
                return;
            }
            // Creating Immigrant (Parent) object
        Immigrant parent = new Immigrant();
        parent.setFirstName(fxParentFirstName.getText());
        parent.setLastName(fxParentLastName.getText());
        parent.setPersonID(Integer.parseInt(fxParentID.getText()));
        // Additional parsing for other parent fields (address, phone, etc.)
        parent.setDateOfBirth(new SimpleDateFormat("MM/dd/yyyy").parse(fxParentDateOfBirth.getText()));
        parent.setAddress(fxParentAddress.getText());
        parent.setPhoneNumber(Long.parseLong(fxParentPhoneNumber.getText()));
        parent.setEmail(fxParentEmail.getText());

        // Creating Dependent object with all required fields
        Dependent dependent = new Dependent(
            fxDependentFirstName.getText(),
            fxDependentLastName.getText(),
            Integer.parseInt(fxDependentID.getText()),
            new SimpleDateFormat("MM/dd/yyyy").parse(fxDependentDateOfBirth.getText()),
            fxDependentAddress.getText(),
            Long.parseLong(fxDependentPhoneNumber.getText()),
            fxDependentEmail.getText()
        );

        // Link parent and dependent in DependentForm
        // Store the DependentForm instance
        int formID = generateFormID();

        dependentForm = new DependentForm(parent, dependent, formID);
        formStorage.add(dependentForm);
        showConfirmation("Data Submitted", "Your information has been successfully saved.");
        clearForm();


    } catch (Exception e) {
        e.printStackTrace(); 
        showError("Submission Error", "Please ensure all fields are filled out correctly.");
    }
    }
    /**
     * Handles the action when the "Clear" button is pressed.
     */
    @FXML
    private void clearForm(ActionEvent event) {
        clearForm();
    }
     /**
     * Checks if any of the form fields are empty.
     * 
     * @return true if any field is empty, false otherwise
     */
    private boolean isAnyFieldEmpty() {
        return fxParentFirstName.getText().isEmpty() ||
               fxParentLastName.getText().isEmpty() ||
               fxParentID.getText().isEmpty() ||
               fxParentDateOfBirth.getText().isEmpty() ||
               fxParentAddress.getText().isEmpty() ||
               fxParentPhoneNumber.getText().isEmpty() ||
               fxParentEmail.getText().isEmpty() ||
               fxDependentFirstName.getText().isEmpty() ||
               fxDependentLastName.getText().isEmpty() ||
               fxDependentID.getText().isEmpty() ||
               fxDependentDateOfBirth.getText().isEmpty() ||
               fxDependentAddress.getText().isEmpty() ||
               fxDependentPhoneNumber.getText().isEmpty() ||
               fxDependentEmail.getText().isEmpty() ||
               fxDependentParentID.getText().isEmpty();
    }
    /**
     * Clears all form fields.
     */
private void clearForm() {
        fxParentFirstName.clear();
        fxParentLastName.clear();
        fxParentID.clear();
        fxParentDateOfBirth.clear();
        fxParentAddress.clear();
        fxParentPhoneNumber.clear();
        fxParentEmail.clear();
        fxDependentFirstName.clear();
        fxDependentLastName.clear();
        fxDependentID.clear();
        fxDependentDateOfBirth.clear();
        fxDependentAddress.clear();
        fxDependentPhoneNumber.clear();
        fxDependentEmail.clear();
        fxDependentParentID.clear();
    }
    /**
     * Displays an error alert.
     * 
     * @param title   the title of the alert
     * @param message the content message of the alert
     */
    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    /**
     * Displays a confirmation alert.
     * 
     * @param title   the title of the alert
     * @param message the content message of the alert
     */
    private void showConfirmation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    /**
     * Generates a unique form ID.
     * 
     * @return a unique form ID.
     */
    private int generateFormID() {
        // Simple form ID generation based on the current size of formStorage
        // In a real application, this should be handled by the backend/database
        return formStorage.size() + 1;
    }
}