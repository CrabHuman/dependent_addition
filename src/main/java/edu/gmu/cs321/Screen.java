package edu.gmu.cs321;

import java.sql.*;
import java.io.IOException;
import javafx.fxml.FXML;

public class Screen {

    static final String DB_URL = "jdbc:mysql://localhost:3306/cs321";
    static final String USER = "guest";
    static final String PASS = "Password1";

    private int screenID;
    protected DependentForm form;

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
      
    }

}
