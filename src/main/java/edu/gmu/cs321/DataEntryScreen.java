package edu.gmu.cs321;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class DataEntryScreen extends Screen {
    @FXML
    private void testButtonMethod() throws IOException {
        App.setRoot("primary");
    }
}