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

    public Immigrant getParent() 
    {
        return null; //this.parent;
    }

    public Dependent getDependent()
    {
        return null; //this.dependent;
    }

    public int getFormID()
    {
        return -1; //this.formID;
    }
}
