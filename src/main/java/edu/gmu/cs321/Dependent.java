package edu.gmu.cs321;
import java.util.Date;

public class Dependent extends Immigrant{
    //Class Attribute
    private Immigrant parent;
    //Inheritance Super Constructor
    public Dependent(){
        super();
    }
    //Dependent constructor that inherits fields from immigrant class
    public Dependent(String firstName, String lastName, int personID, Date dateOfBirth, String address, long phoneNumber, String email) {
        super(firstName, lastName, personID, dateOfBirth, address, phoneNumber, email);
    }
     //Second Consturctor that inherits fields for immigrant class with parent parameter
    public Dependent(String firstName, String lastName, int personID, Date dateOfBirth, String address, long phoneNumber, String email, Immigrant parent) {
        super(firstName, lastName, personID, dateOfBirth, address, phoneNumber, email);
        this.parent=parent;
    }
    //Parent getter
    public Immigrant getParent(){
        return parent;
    }
    //Parent Setter
    public void setParent(Immigrant parent){
        this.parent = parent;
    }


}