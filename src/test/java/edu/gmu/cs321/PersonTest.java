package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;


public class PersonTest {
    // variable declaration
    static Person person;
    static Person empty;
    static Person fill;

    // variable initialization
    @BeforeAll
    static void setUp(){
        person = new Person("Bob", "Bryant", 656);
        empty = new Person();
        fill = new Person();
    }
    
    // confirmation of class type of created Person objects
    @Test
    void dependentInstanceTester(){
        assertTrue(person instanceof Person);
    }

    // detailed constructed firstName argument == created object's firstName attribute
    @Test
    void firstNameTester(){
        assertEquals("Bob",person.getFirstName());
    }

    // detailed constructed lastName argument == created object's lastName attribute
    @Test
    void lastNameTester(){
        assertEquals("Bryant",person.getLastName());
    }

    // detailed constructed personID argument == created object's personID attribute
    @Test
    void personIDTester(){
        assertEquals(656, person.getID());
    }

    // return of getFullName == (object's firstName) + " " + (object's lastName)
    @Test
    void fullNameTester(){
        assertEquals("Bob Bryant", person.getFullName());
    }

    // default constructed Person object's firstName attribute == null
    @Test
    void defaultFirstNameTester(){
        assertNull(empty.getFirstName());
    }

    // default constructed Person object's lastName attribute == null
    @Test
    void defaultLastNameTester(){
        assertNull(empty.getLastName());
    }

    // default constructed Person object's personID attribute == -1
    @Test
    void defaultPersonIDTester(){
        assertEquals(-1,empty.getID());
    }

    // return of  getFullName == null if both firstName AND lastName == null
    @Test
    void defaultFullNameTester(){
        assertNull(empty.getFullName());
    }

    // default constructed Person object's firstName attribute is set using setFirstName then checked as the argument
    @Test
    void setFirstNameTester(){
        fill.setFirstName("Andy");
        assertEquals("Andy",fill.getFirstName());
    }

    // default constructed Person object's lastName attribute is set using setLastName then checked as the argument
    @Test
    void setLastNameTester(){
        fill.setLastName("Bandy");
        assertEquals("Bandy",fill.getLastName());
    }

    // default constructed Person object's personID attribute is set using setPersonID then checked as the argument
    @Test
    void setPersonIDTester(){
        fill.setPersonID(133);
        assertEquals(133,fill.getID());
    }

    // default constructed Person object's firstName and lastName attributes are set using setFirstName and
    // setLastName, then full name of the object is checked as the parameters of setFirstName and setLastName
    // separated by " "
    @Test
    void setFullNameTester(){
        assertEquals("Andy Bandy",fill.getFullName());
    }
}

