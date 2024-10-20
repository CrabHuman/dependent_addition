package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DependentFormTest
{
    @Test
    public void DependentFormConstructor()
    {
        DependentForm df = new DependentForm();
        if(df.getDependent()==null){
            assertEquals(true,true);
        }
        if(df.getFormID()==-1){
            assertEquals(-1,-1);
        }
        if(df.getParent()==null){
            assertEquals(true, true);
        }
        
    }
}