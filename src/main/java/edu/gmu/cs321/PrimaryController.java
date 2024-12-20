package edu.gmu.cs321;

import java.io.IOException;
import javafx.fxml.FXML;

// primary controller class built in for swapping between the classes
public class PrimaryController {

    @FXML
    private void switchToDataEntry() throws IOException {
        App.setRoot("dataEntry");
    }
    @FXML
    private void switchToReview() throws IOException {
        App.setRoot("review");
    }
    @FXML
    private void switchToApproval() throws IOException {
        App.setRoot("approval");
    }
}
