package edu.gmu.cs321;
import java.util.Date;

public class Dependent extends Immigrant{
    private Immigrant parent;

    public Dependent(){
        super();
    }

    public Dependent(String firstName, String lastName, int personID, Date dateOfBirth, String address, long phoneNumber, String email) {
        super(firstName, lastName, personID, dateOfBirth, address, phoneNumber, email);
    }

    public Dependent(String firstName, String lastName, int personID, Date dateOfBirth, String address, long phoneNumber, String email, Immigrant parent) {
        super(firstName, lastName, personID, dateOfBirth, address, phoneNumber, email);
        this.parent=parent;
    }
    public Immigrant getParent(){
        return parent;
    }

    public void setParent(Immigrant parent){
        this.parent = parent;
    }


}