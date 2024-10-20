package edu.gmu.cs321;

public class DependentForm 
{
    private Immigrant parent;
    private Dependent dependent;
    private int formID;

    public DependentForm()
    {
        this.formID = -1;
        this.parent = null;
        this.dependent = null;
    }

    public DependentForm(int formID, Immigrant parent, Dependent dependent){
        this.formID = formID;
        this.parent = parent;
        this.dependent = dependent;
    }

    public Immigrant getParent() 
    {
        return this.parent;
    }

    public Dependent getDependent()
    {
        return this.dependent;
    }

    public int getFormID()
    {
        return this.formID;
    }

    public void setParent(Immigrant parent){
        this.parent = parent;
    }

    public void setDependent(Dependent dependent){
        this.dependent = dependent;
    }

    public void setFormID(int formID){
        this.formID = formID;
    }

}
