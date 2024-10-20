package edu.gmu.cs321;
import java.util.Date;

public class Dependent extends Immigrant{
private Immigrant parent;

    public Dependent(String firstName, String lastName, int personID, Date dateOfBirth, Immigrant parent) {
        super(firstName, lastName, personID, dateOfBirth);
        this.parent=parent;
        //TODO Auto-generated constructor stub
    }
    public Immigrant getParent(){
        return parent;
    }
    public static Dependent newDependent(String firstName, String lastName, int personID,Date dateOfBirth, Immigrant parent ){
        return new Dependent(firstName, lastName, personID, dateOfBirth,parent);

    }

}