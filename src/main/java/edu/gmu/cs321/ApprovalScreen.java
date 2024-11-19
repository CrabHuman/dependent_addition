package edu.gmu.cs321;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ApprovalScreen extends Screen {
    private static final String QUERY = "SELECT * FROM DependentForm WHERE formID = ";
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

    
    public void getNext(){
        if(form != null){
            System.out.println("FULL");
            return;
        }
        int nextID = App.workflow.GetNextWFItem("Approve");
        
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

    void fillForm(){
        try {
            
            form.setID(rs.getInt("formID"));
            //dateOfBirth, address, phoneNumber, email, dependentID, 
            //DPfirstName, DPlastName, DPdateOfBirth, DPaddress, DPphoneNumber, DPemail
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

    @FXML
    private void approveForm(){
        clearScreen();
        emailApproval();
        form = null;
    }

    @FXML
    private void denyForm(){
        clearScreen();
        App.workflow.AddWFItem(form.getID(), "Review");
        form = null;
    }


    
    private void emailApproval(){
        System.out.println(form.getParent().getEmail());
    }
}