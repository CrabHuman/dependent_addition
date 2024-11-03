package edu.gmu.cs321;

import java.io.IOException;
import javafx.fxml.FXML;

public class ReviewScreen extends Screen {

    @FXML
    private void saveForm() throws IOException {
        // save the form to the database
    }
    
    @FXML
    private void submitForm() throws IOException {
        // save form to database
        saveForm();
        // send form into workflow table
        // unload this form from the ReviewScreen
    }

    // renamed back to testButtonMethod from backToPrimary for basic functionality before I figure out how it works.
    @FXML
    private void testButtonMethod() throws IOException {
        // save form to database
        saveForm();
        // go back to previous page
        App.setRoot("primary");
    }

    @FXML
    private void pauseForm() throws IOException {
        // save form to database (maybe mark as a draft or something)
        saveForm(/*DependentForm.draft=true*/);
        // keep form loaded
    }

    @FXML
    private void loadNextForm() throws IOException {
        // save form to database
        saveForm();
        // unload this form
        // retrieve new form from the database
    }
}