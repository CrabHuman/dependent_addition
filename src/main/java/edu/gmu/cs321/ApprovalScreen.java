package edu.gmu.cs321;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ApprovalScreen extends Screen {

    @FXML
    private TextField fxAddress;

    public void initialize(){
        form.getParent().setAddress("wow");
        fxAddress.setText("foo");
        System.out.println("bar");
    }
    

    @FXML
    private void testButtonMethod() throws IOException {
        
        App.setRoot("primary");
    }
}