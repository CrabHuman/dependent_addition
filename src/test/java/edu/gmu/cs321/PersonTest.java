package edu.gmu.cs321
import java.util.Date;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    @Test
    public void testPersonConstructor(){
        Person testPerson = new Person("Bob","Bryant",656);
        assertEquals("Bob",testPerson.getFirstName());
        assertEquals("Bryant",testPerson.getLastName());
        assertEquals(656, testPerson.getID());
        //testPerson = null;.
        boolean testConstructor = testPerson != null;
        assertTrue(testConstructor);
    }
}
public class TestForImmigrant{
    @Test
    public void testImmigrant(){
        Date dob = new Date();
        Immigrant imm  = new Immigrant("Lonzo","Ball",02);
    }
}
