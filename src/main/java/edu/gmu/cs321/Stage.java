package edu.gmu.cs321;

public class Stage {
    private DependantForm form;

    public Stage()
    {
        this.form = null;
    }

    public DependantForm getDependantForm()
    {
        return this.form;
    }

    public int nextForm()
    {
        //fetch next DependantForm from Workflow
        return 1;
    }

    public int saveForm()
    {
        return 1;
    }
}
