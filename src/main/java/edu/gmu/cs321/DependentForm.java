package edu.gmu.cs321;
//Dependent Form Class
public class DependentForm 
{
    //Class Attributes
    private Immigrant parent;
    private Dependent dependent;
    private int formID;
    //No parameter constructor
    public DependentForm()
    {
        this.formID = -1;
        this.parent = null;
        this.dependent = null;
    }
    //Parameter Constructor
    public DependentForm(Immigrant parent, Dependent dependent, int formID){
        this.parent = parent;
        this.dependent = dependent;
        this.formID = formID;
    }
    //Getters
    public Immigrant getParent() 
    {
        return this.parent;
    }
    public Dependent getDependent()
    {
        return this.dependent;
    }
    public int getID()
    {
        return this.formID;
    }
    //Setters
    public void setParent(Immigrant parent){
        this.parent = parent;
    }
    public void setDependent(Dependent dependent){
        this.dependent = dependent;
    }
    public void setID(int formID){
        this.formID = formID;
    }

}
