package edu.gmu.cs321;

import java.io.IOException;
import javafx.fxml.FXML;

public class ReviewScreen extends Screen {

    @FXML
    private void saveForm() throws IOException {
        
        App.setRoot("primary");
    }
    
    @FXML
    private void submitForm() throws IOException {
        
        App.setRoot("primary");
    }

    @FXML
    private void backToPrimary() throws IOException {
        
        App.setRoot("primary");
    }

    @FXML
    private void pauseForm() throws IOException {
        
        App.setRoot("primary");
    }

    @FXML
    private void loadNextForm() throws IOException {
        
        App.setRoot("primary");
    }
}