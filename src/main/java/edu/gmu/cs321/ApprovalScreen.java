package edu.gmu.cs321;

import java.io.IOException;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ApprovalScreen extends Screen {

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
    private TextField fxApproveParentID;
    @FXML
    private TextField fxApproveDependentID;
    @FXML
    private TextField fxDenyParentID;
    @FXML
    private TextField fxDenyDependentID;

    @FXML
    public void initialize(){
        
        //enterFields();
    }

    public void getNext(){
        int nextID = App.workflow.GetNextWFItem("Approve");
        if(nextID >= 0){
            
        }

    }
    
    @FXML
    private void enterFields(){
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
    }

    // renamed back to testButtonMethod from backToPrimary for basic functionality before I figure out how it works.
    @FXML
    private void returnToPrimaryController() throws IOException {
        // save form to database
        //saveForm();
        // go back to previous page
        App.setRoot("primary");
    }

    @FXML
    private void approveForm(){

        fxApproveParentID.setText("");
        fxApproveDependentID.setText("");
        fxDenyParentID.setText("");
        fxDenyDependentID.setText("");

        form = new DependentForm(new Immigrant("Bob", "Bryant", 655, 
        new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com"),
        new Dependent("Carl", "Bumps",882,new Date(2000L),
        "Terraceloop Rd",9998887777L,"cal@cal.com"),
        868
        );
        form.getDependent().setParent(form.getParent());

        enterFields();

    }

    @FXML
    private void denyForm(){

        fxApproveParentID.setText("");
        fxApproveDependentID.setText("");
        fxDenyParentID.setText("");
        fxDenyDependentID.setText("");

        form = new DependentForm(new Immigrant("Carl", "Bumps",882,new Date(2000L),
        "Terraceloop Rd",9998887777L,"cal@cal.com"),
        new Dependent("Bob", "Bryant", 655, 
        new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com"),
        111
        );
        form.getDependent().setParent(form.getParent());

        enterFields();

    }
}