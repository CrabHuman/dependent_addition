package edu.gmu.cs321;

import java.sql.*;

import com.cs321.Workflow;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;



public class Screen {

    

    private int screenID;
    protected DependentForm form;

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

    protected Connection conn;
    protected Statement stmt;
    protected ResultSet rs;

    public Screen(){
        screenID = -1;
        form = null;
    }

    public int getID(){
        return screenID;
    }
    public DependentForm getDependentForm(){
        return form;
    }

    public void setID(int screenID){
        this.screenID = screenID;
    }
    public void setDependentForm(DependentForm form){
        this.form = form;
    }

    public void initialize(){
        try {
            conn = DriverManager.getConnection(App.DB_URL, App.USER, App.PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void clearScreen(){
        
    }

}
