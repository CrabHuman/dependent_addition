package edu.gmu.cs321;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ApprovalScreen extends Screen {
    // query for gathering the form info from the database
    private static final String QUERY = "SELECT * FROM DependentForm WHERE formID = ";
    

    // optional fx fields for the confirmation of the form
    @FXML
    private TextField fxApproveParentID;
    @FXML
    private TextField fxApproveDependentID;
    @FXML
    private TextField fxDenyParentID;
    @FXML
    private TextField fxDenyDependentID;

    // gets the next form in the work flow
    public void getNext(){
        if(form != null){
            System.out.println("FULL");
            return;
        }
        int nextID = App.workflow.GetNextWFItem("Approve");
        
        // a non-negative nextID indicates that the workflow item was successfully gathered
        if(nextID >= 0){
            try {
                conn = DriverManager.getConnection(App.DB_URL, App.USER, App.PASS);
                stmt = conn.createStatement();
                rs = stmt.executeQuery(QUERY + nextID);
                rs.next();
                //rs = stmt.executeQuery("SELECT formID WHERE ");
                //System.out.println("WOW" + rs.getInt("formID"));
                form = new DependentForm(new Immigrant(), new Dependent(), -1);
                fillForm();
                enterFields();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            System.out.println("OOPS");
            return;
        }
        
        return;
    }


    //Method for filling each value of the form from the database
    void fillForm(){
        try {
            
            form.setID(rs.getInt("formID"));
            
            form.getParent().setPersonID(rs.getInt("immigrantID"));
            form.getParent().setFirstName(rs.getString("firstname"));
            form.getParent().setLastName(rs.getString("lastname"));
            form.getParent().setDateOfBirth(new Date(rs.getLong("dateOfBirth")));
            form.getParent().setAddress(rs.getString("address"));
            form.getParent().setPhoneNumber(rs.getLong("phoneNumber"));
            form.getParent().setEmail(rs.getString("email"));

            form.getDependent().setParent(form.getParent());
            form.getDependent().setPersonID(rs.getInt("dependentID"));
            form.getDependent().setFirstName(rs.getString("DPfirstname"));
            form.getDependent().setLastName(rs.getString("DPlastname"));
            form.getDependent().setDateOfBirth(new Date(rs.getLong("DPdateOfBirth")));
            form.getDependent().setAddress(rs.getString("DPaddress"));
            form.getDependent().setPhoneNumber(rs.getLong("DPphoneNumber"));
            form.getDependent().setEmail(rs.getString("DPemail"));


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    // method for filling all the fields of the User interface
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

    // clears the screen for the user
    @FXML
    protected void clearScreen(){
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

        fxApproveParentID.setText("");
        fxApproveDependentID.setText("");
        fxDenyParentID.setText("");
        fxDenyDependentID.setText("");
    }

    // approves the form and clears the screen, sends an email to the immigrant
    @FXML
    private void approveForm(){
        clearScreen();
        emailApproval();
        form = null;
    }

    // denies the form, returns it back for review
    @FXML
    private void denyForm(){
        clearScreen();
        App.workflow.AddWFItem(form.getID(), "Review");
        form = null;
    }


    // sends an email to the immigrant, does not have real functionality
    private void emailApproval(){
        System.out.println(form.getParent().getEmail());
    }
}