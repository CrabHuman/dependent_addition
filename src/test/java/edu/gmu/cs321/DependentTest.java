package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
public class DependentTest{
    static Immigrant immigrant;
    static Dependent dependent;
    static Dependent empty;
    static Dependent fill;

    @BeforeAll
    static void setUp(){
        immigrant = new Immigrant("Bob", "Bryant", 655, new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com" );
        dependent = new Dependent("Peach", "Jam", 585, new Date(800000L), "Courtlane Dr",1112223333L,"bb@b.com", immigrant);
        empty = new Dependent();
        fill = new Dependent("Carl", "Bumps",882,new Date(2000L),"Terraceloop Rd",9998887777L,"cal@cal.com");
    }
    
    @Test
    void dependentInstanceTester(){
        assertTrue(dependent instanceof Dependent);
        assertTrue(dependent instanceof Immigrant);
        assertTrue(dependent instanceof Person);
    }

    @Test
    void parentTester(){
        assertEquals(immigrant, dependent.getParent());
    }

    @Test
    void defaultParentTester(){
        assertNull(empty.getParent());
    }

    @Test
    void setParentTester(){
        fill.setParent(immigrant);
        assertEquals(immigrant, fill.getParent());
    }
}