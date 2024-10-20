package edu.gmu.cs321;

public class DependantForm 
{
    private Immigrant parent;
    //private Dependent dependent;
    private int formID;

    public DependantForm()
    {
        this.formID = -1;
        this.parent = null;
        //this.Dependent = null;
    }

    public Immigrant getParent() 
    {
        return this.parent;
    }

    /**public Dependant getDependant()
    {
        return this.dependent;
    }*/

    public int getFormID()
    {
        return this.formID;
    }
}
