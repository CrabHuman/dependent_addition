package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
public class PersonTest {
    Person person;

    @BeforeEach
    void setUp(){
        person = new Person("Bob", "Bryant", 656);
    }
    
    @Test
    void ExampleTester(){
        //person = new Person("Bob", "Bryant", 656);
        assertEquals("Bob",person.getFirstName());
        assertEquals("Bryant",person.getLastName());
        assertEquals(656, person.getID());
    }

    @Test
    void DefaultTester(){
        person = new Person();
        assertNull(person.getFirstName());
        assertNull(person.getLastName());
        assertEquals(-1,person.getID());
        
    }
}

