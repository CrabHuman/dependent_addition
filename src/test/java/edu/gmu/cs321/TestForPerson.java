package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestForPerson {
    @Test
    public void PersonTester(){
        Person p = new Person(null,null,0);
            assertNull(p.getFirstName());
            assertNull(p.getLastName());
            assertNotEquals(653,p.getID());
        
        // assertEquals("Bob",testPerson.getFirstName());
        // assertEquals("Bryant",testPerson.getLastName());
        // assertEquals(656, testPerson.getID());
        // //testPerson = null;.
        // boolean testConstructor = testPerson != null;
        // assertTrue(testConstructor);
    }
}