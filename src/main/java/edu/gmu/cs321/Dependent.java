package edu.gmu.cs321;
import java.util.Date;

public class Dependent extends Immigrant{
    private Immigrant parent;

    public Dependent(String firstName, String lastName, int personID, Date dateOfBirth, Immigrant parent) {
        super(firstName, lastName, personID, dateOfBirth);
        this.parent=parent;
    }
    public Immigrant getParent(){
        return parent;
        // return parent;
    }

    public void setParent(Immigrant parent){
        this.parent = parent;
    }

    //public static Dependent newDependent(String firstName, String lastName, int personID,Date dateOfBirth, Immigrant parent ){
        //return null;
        // return new Dependent(firstName, lastName, personID, dateOfBirth,parent);

    //}

}