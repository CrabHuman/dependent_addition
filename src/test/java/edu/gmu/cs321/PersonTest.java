package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;


public class PersonTest {
    static Person person;
    static Person empty;
    static Person fill;

    @BeforeAll
    static void setUp(){
        person = new Person("Bob", "Bryant", 656);
        empty = new Person();
        fill = new Person();
    }
    
    @Test
    void dependentInstanceTester(){
        assertTrue(person instanceof Person);
    }

    @Test
    void firstNameTester(){
        assertEquals("Bob",person.getFirstName());
    }
    @Test
    void lastNameTester(){
        assertEquals("Bryant",person.getLastName());
    }
    @Test
    void personIDTester(){
        assertEquals(656, person.getID());
    }
    @Test
    void fullNameTester(){
        assertEquals("Bob Bryant", person.getFullName());
    }

    @Test
    void defaultFirstNameTester(){
        assertNull(empty.getFirstName());
    }
    @Test
    void defaultLastNameTester(){
        assertNull(empty.getLastName());
    }
    @Test
    void defaultPersonIDTester(){
        assertEquals(-1,empty.getID());
    }
    @Test
    void defaultFullNameTester(){
        assertNull(empty.getFullName());
    }


    @Test
    void setFirstNameTester(){
        fill.setFirstName("Andy");
        assertEquals("Andy",fill.getFirstName());
    }
    @Test
    void setLastNameTester(){
        fill.setLastName("Bandy");
        assertEquals("Bandy",fill.getLastName());
    }
    @Test
    void setPersonIDTester(){
        fill.setPersonID(133);
        assertEquals(133,fill.getID());
    }
    @Test
    void setFullNameTester(){
        assertEquals("Andy Bandy",fill.getFullName());
    }
}

