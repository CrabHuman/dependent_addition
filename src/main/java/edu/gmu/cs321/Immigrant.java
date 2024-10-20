package edu.gmu.cs321;
import java.util.Date;
import java.util.LinkedList;
public class Immigrant extends Person{
    private Date dateOfBirth;
    private LinkedList<Dependent> dependentList;

    public Immigrant(String firstName, String lastName, int personID, Date dateOfBirth ){
        super(firstName, lastName, personID);
        this.dateOfBirth=dateOfBirth;
        this.dependentList=new LinkedList<>();
    }
    public Date gtetDateofBirth(){
        return dateOfBirth;
    }
    public boolean hasDependents(){
        return !dependentList.isEmpty();
    }
    public void displayDependants(){
        if(dependentList.isEmpty()){
            System.out.println("There are no dependents");
        }else{
            System.out.println("These are the dependents");
            for(Dependent i: dependentList){
                System.out.println(i.getFirstName());
                System.out.println("\n");
                System.out.println(i.getLastName());
            }
        }
    }
    public void addDependent(Dependent dependent){
        dependentList.add(dependent);
    }
}
