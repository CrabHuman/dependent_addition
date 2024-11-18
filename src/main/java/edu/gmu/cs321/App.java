package edu.gmu.cs321;

import java.sql.*;


import com.cs321.Workflow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    static final String DB_URL = "jdbc:mysql://localhost:3306/cs321";
    static final String USER = "guest";
    static final String PASS = "Password1";
    static final String QUERY = "SELECT age FROM People";;

    private static Workflow workflow;
    private static Scene scene;
    private static Scene scene2;
    private static Screen screen = new Screen();

    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 900, 480);
        stage.setScene(scene);
        stage.show();
        
        //Seperate Screen For Data Entry
        /*
        scene2=new Scene(creation(),300,300);
        Stage destage=new Stage();
        destage.setTitle("Data Entry");
        destage.setScene(scene2);
        destage.show();
        */
    }
    

    static void setRoot(String fxml) throws IOException {
        switch(fxml){
            case "approval" :
            screen = new ApprovalScreen();
            break;
            case "review":
            screen = new ReviewScreen();
            break;
            case "dataEntry":
            screen = new DataEntryScreen();
            break;
            default:
            screen = new Screen();
        }
        scene.setRoot(loadFXML(fxml));
        
    }
    //creation method for data entry
    private static Parent creation(){
        return new StackPane(new Text("Data Entry Main Screen"));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("age"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        launch();
    }

}