package edu.gmu.cs321;

import java.lang.*;
import java.util.Date;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ReviewScreen extends Screen {

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

    @FXML
    private void saveForm() throws IOException {
        // save the form to the database
                // Debug Statement: System.out.println("Form saved c:");
    }
    
    @FXML
    private void submitForm() throws IOException {
        // save form to database
        //saveForm();
        App.workflow.AddWFItem(form.getID(), "Approve");
        // send form into workflow table
        // unload this form from the ReviewScreen
                // Debug Statement: System.out.println("Form submitted c:");
    }

    @FXML
    private void backToPrimary() throws IOException {
        // save form to database
        //saveForm();
        // go back to previous page
        App.setRoot("primary");
    }

    @FXML
    private void pauseForm() throws IOException {
        // save form to database (maybe mark as a draft or something)
        saveForm(/*DependentForm.draft=true*/);
        // keep form loaded
                // Debug Statement: System.out.println("Form paused c:");
    }

    @FXML
    private void loadNextForm() throws IOException {
        // save form to database
        //saveForm();
        // unload this form
        // retrieve new form from the database
        
        //Note: following is for initialization of testing data only. Credit goes to Ben for this.
        form = new DependentForm(new Immigrant("Bob", "Bryant", 655, 
        new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com"),
        new Dependent("Peach", "Jam", 585, new Date(800000L),
        "Courtlane Dr",1112223333L,"bb@b.com", null),
        994
        );
        form.getDependent().setParent(form.getParent());

        fxParentFirstName.setText(form.getParent().getFirstName());
        fxParentLastName.setText(form.getParent().getLastName());
        fxParentID.setText(String.valueOf(form.getParent().getID()));
        fxParentDateOfBirth.setText(form.getParent().getDateOfBirth().toString());
        fxParentAddress.setText(form.getParent().getFirstName());
        fxParentPhoneNumber.setText(String.valueOf(form.getParent().getPhoneNumber()));
        fxParentEmail.setText(form.getParent().getEmail());

        fxDependentFirstName.setText(form.getDependent().getFirstName());
        fxDependentLastName.setText(form.getDependent().getLastName());
        fxDependentID.setText(String.valueOf(form.getDependent().getID()));
        fxDependentDateOfBirth.setText(form.getDependent().getDateOfBirth().toString());
        fxDependentAddress.setText(form.getDependent().getFirstName());
        fxDependentPhoneNumber.setText(String.valueOf(form.getDependent().getPhoneNumber()));
        fxDependentEmail.setText(form.getDependent().getEmail());
        fxDependentParentID.setText(String.valueOf(form.getDependent().getParent().getID()));
                // Debug Statement: System.out.println("Next form loaded c:");

        form.setID(App.workflow.GetNextWFItem("Review"));
    }

    @FXML
    public void unloadForm() throws IOException {
        fxParentFirstName.setText("");
        fxParentLastName.setText("");
        fxParentID.setText("");
        fxParentDateOfBirth.setText("");
        fxParentAddress.setText("");
        fxParentPhoneNumber.setText("");
        fxParentEmail.setText("");

        fxDependentFirstName.setText("");
        fxDependentLastName.setText("");
        fxDependentID.setText("");
        fxDependentDateOfBirth.setText("");
        fxDependentAddress.setText("");
        fxDependentPhoneNumber.setText("");
        fxDependentEmail.setText("");
        fxDependentParentID.setText("");
    }
}