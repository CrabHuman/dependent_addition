package edu.gmu.cs321;

public class DataEntry extends Stage
{
    boolean allFieldsFilled;

    public DataEntry()
    {
        this.allFieldsFilled = false;
    }

    public boolean validateFields()
    {
        return false;
    }

    public boolean sendFormForReview()
    {
        return false;
    }
}
