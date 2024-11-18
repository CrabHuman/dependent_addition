package edu.gmu.cs321;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DataEntryScreen extends Screen {
    @FXML
    private void testButtonMethod() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
        App.setRoot("primary");  
    }

    


}