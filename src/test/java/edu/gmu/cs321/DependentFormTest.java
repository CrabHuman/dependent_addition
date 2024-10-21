package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;

public class DependentFormTest
{
    static Immigrant parent;
    static Dependent dependent;
    static DependentForm form;
    static DependentForm empty;
    static DependentForm fill;

    @BeforeAll
    static void setUp(){
        parent = new Immigrant("Bob", "Bryant", 655, new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com" );
        dependent = new Dependent("Peach", "Jam", 585, new Date(800000L), "Courtlane Dr",1112223333L,"bb@b.com", parent);
        form = new DependentForm(parent, dependent, 321);
        empty = new DependentForm();
        fill = new DependentForm();
    }

    @Test
    void formInstanceTester(){
        assertTrue(form instanceof DependentForm);
    }

    @Test
    void parentTester(){
        assertEquals(parent, form.getParent());
    }
    @Test
    void dependentTester(){
        assertEquals(dependent, form.getDependent());
    }
    @Test
    void formIDTester(){
        assertEquals(321, form.getID());
    }


    @Test
    void defaultParentTester(){
        assertNull(empty.getParent());
    }
    @Test
    void defaultDependentTester(){
        assertNull(empty.getDependent());
    }
    @Test
    void defaultFormIDTester(){
        assertEquals(-1, empty.getID());
    }


    @Test
    void setParentTester(){
        fill.setParent(parent);
        assertEquals(parent, fill.getParent());
    }
    @Test
    void setDependentTester(){
        fill.setDependent(dependent);
        assertEquals(dependent, fill.getDependent());
    }
    @Test
    void setFormIDTester(){
        fill.setID(999);
        assertEquals(999, fill.getID());
    }

}