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

    public static final String DB_URL = "jdbc:mysql://localhost:3306/cs321";
    public static final String USER = "guest";
    public static final String PASS = "Password1";
    static final String QUERY = "SELECT age FROM People WHERE id = 100";
    //static final String DEL_IMM = "DROP TABLE Immigrant";
    static final String DEL_FRM = "DROP TABLE DependentForm";
    
    static final String CREAT_FRM = """
    CREATE TABLE DependentForm(formID int not null, immigrantID int not null, 
    firstName varchar(255), lastName varchar(255), dateOfBirth long not null, address varchar(255), 
    phoneNumber long not null, email varchar(255),dependentID int not null, DPfirstName varchar(255), 
    DPlastName varchar(255), DPdateOfBirth long not null, DPaddress varchar(255), DPphoneNumber long not null, 
    DPemail varchar(255));
    """;
    //static final String CREAT_FRM = "CREATE TABLE DependentForm(parentID int not null, dependentID int not null);";
    
    //static final String JOIN_PARENT = "DROP TABLE Immigrant";
    //static final String JOIN_DEPENDENT = "DROP TABLE Immigrant";
    
    public static Workflow workflow;
    private static Scene scene;
    private static Scene scene2;
    private static Screen screen;

    
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
        Connection conn;
        Statement stmt;
        ResultSet rs;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //rs = stmt.executeQuery(QUERY);
           
            
            /*try {
                stmt.executeUpdate(DEL_IMM);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }*/
            try {
                stmt.executeUpdate(DEL_FRM);
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            //stmt.executeUpdate(CREAT_IMM);
            stmt.executeUpdate(CREAT_FRM);
            workflow = new Workflow();

            DependentForm form = new DependentForm(new Immigrant("Bob", "Bryant", 655, 
            new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com"),
            new Dependent("Peach", "Jam", 585, new Date(800000L),
            "Courtlane Dr",1112223333L,"bb@b.com", null),
            994
            );
            form.getDependent().setParent(form.getParent());

            
            try {
                stmt.execute("INSERT INTO DependentForm VALUES("+ form.getID() + ", " + form.getParent().getID()  + 
                ", '" + form.getParent().getFirstName() + "','" + form.getParent().getLastName() + 
                "', " + form.getParent().getDateOfBirth().getTime() + ", '" + form.getParent().getAddress() + 
                "', " + form.getParent().getPhoneNumber() + ", '" + form.getParent().getEmail() + "', " 
                + form.getDependent().getID()  + 
                ", '" + form.getDependent().getFirstName() + "','" + form.getDependent().getLastName() + 
                "', " + form.getDependent().getDateOfBirth().getTime() + ", '" + form.getDependent().getAddress() + 
                "', " + form.getDependent().getPhoneNumber() + ", '" + form.getDependent().getEmail() + "');" );
    
                App.workflow.AddWFItem(form.getID(), "Approve");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                

            launch();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

}