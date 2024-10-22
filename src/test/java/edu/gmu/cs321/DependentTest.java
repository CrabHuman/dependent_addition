package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
public class DependentTest{
    // variable declaration
    static Immigrant immigrant;
    static Dependent dependent;
    static Dependent empty;
    static Dependent fill;

    // variable initialization
    @BeforeAll
    static void setUp(){
        immigrant = new Immigrant("Bob", "Bryant", 655, new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com" );
        dependent = new Dependent("Peach", "Jam", 585, new Date(800000L), "Courtlane Dr",1112223333L,"bb@b.com", immigrant);
        empty = new Dependent();
        fill = new Dependent("Carl", "Bumps",882,new Date(2000L),"Terraceloop Rd",9998887777L,"cal@cal.com");
    }
    
    // confirmation of data type of objects through class inheritance
    @Test
    void dependentInstanceTester(){
        assertTrue(dependent instanceof Dependent);
        assertTrue(dependent instanceof Immigrant);
        assertTrue(dependent instanceof Person);
    }

    // detailed constructor's parent argument == Dependent's object's parent attribute
    @Test
    void parentTester(){
        assertEquals(immigrant, dependent.getParent());
    }

    // default constructed Dependent object's parent attribute == null
    @Test
    void defaultParentTester(){
        assertNull(empty.getParent());
    }

    // param of setParent on a default constructed Dependent object is confirmed as the object's parent attribute
    @Test
    void setParentTester(){
        fill.setParent(immigrant);
        assertEquals(immigrant, fill.getParent());
    }
}