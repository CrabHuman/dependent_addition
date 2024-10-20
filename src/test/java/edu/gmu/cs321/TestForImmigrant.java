package edu.gmu.cs321;
// import java.util.Date;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestForImmigrant{
    @Test
    public 
    void TestImmigrant(){
        Immigrant imm = new Immigrant(null, null, 0, null);
        if(imm.hasDependents()==false){
            System.out.println("Test 1 Immigrant is successful");
            return;
        }else{
            System.out.println("Test 1 Immigrant Test not successful");
        }

        // Date dob = new Date();
        // Immigrant imm  = new Immigrant("Lonzo","Ball",02,dob);
        
        // assertFalse(imm.hasDependents());

        // imm.addDependent(new);
    }
}
