package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class DependentTest{
    @Test
    void testDependent(){
        Dependent d = new Dependent();
            assertNull(d.getParent());
            
        // }else
        // {
        //     !assertEquals(null);
        //     System.out.println("The test for dependent was NOT successful");
        // }
    }
}