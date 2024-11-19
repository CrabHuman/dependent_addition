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
    protected TextField fxParentFirstName;
    @FXML
    protected TextField fxParentLastName;
    @FXML
    protected TextField fxParentID;
    @FXML
    protected TextField fxParentDateOfBirth;
    @FXML
    protected TextField fxParentAddress;
    @FXML
    protected TextField fxParentPhoneNumber;
    @FXML
    protected TextField fxParentEmail;

    @FXML
    protected TextField fxDependentFirstName;
    @FXML
    protected TextField fxDependentLastName;
    @FXML
    protected TextField fxDependentID;
    @FXML
    protected TextField fxDependentDateOfBirth;
    @FXML
    protected TextField fxDependentAddress;
    @FXML
    protected TextField fxDependentPhoneNumber;
    @FXML
    protected TextField fxDependentEmail;
    @FXML
    protected TextField fxDependentParentID;

    protected Connection conn;
    protected Statement stmt;
    protected ResultSet rs;

    // screen constructor
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
