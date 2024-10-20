package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DependentFormTest
{
    @Test
    public void DependentFormConstructor()
    {
        DependentForm df = new DependentForm();
        assertNull(df.getDependent());
        assertEquals(-1, df.getFormID());
        assertNull(df.getParent());
    }
}