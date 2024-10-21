package edu.gmu.cs321;

public class DependentForm 
{
    //object composition
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
    //Parent getter
    public Immigrant getParent() 
    {
        return this.parent;
    }
    //Dependent Getter
    public Dependent getDependent()
    {
        return this.dependent;
    }
    //ID Getter
    public int getID()
    {
        return this.formID;
    }
    //Parent Setter
    public void setParent(Immigrant parent){
        this.parent = parent;
    }
    //Dependent Setter
    public void setDependent(Dependent dependent){
        this.dependent = dependent;
    }
    //ID Setter
    public void setID(int formID){
        this.formID = formID;
    }

}
