package edu.gmu.cs321;

public class Stage {
    private DependentForm form;

    public Stage()
    {
        this.form = null;
    }

    public DependentForm getDependentForm()
    {
        return this.form;
    }

    public int nextForm()
    {
        //fetch next DependentForm from Workflow
        return 1;
    }

    public int saveForm()
    {
        return 1;
    }
}
