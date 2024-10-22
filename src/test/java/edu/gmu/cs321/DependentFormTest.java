package edu.gmu.cs321;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;

public class DependentFormTest
{
    // variable declaration
    static Immigrant parent;
    static Dependent dependent;
    static DependentForm form;
    static DependentForm empty;
    static DependentForm fill;

    // variable initialization
    @BeforeAll
    static void setUp(){
        parent = new Immigrant("Bob", "Bryant", 655, new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com" );
        dependent = new Dependent("Peach", "Jam", 585, new Date(800000L), "Courtlane Dr",1112223333L,"bb@b.com", parent);
        form = new DependentForm(parent, dependent, 321);
        empty = new DependentForm();
        fill = new DependentForm();
    }

    // confirmation of class type of created DependentForm objects
    @Test
    void formInstanceTester(){
        assertTrue(form instanceof DependentForm); // (form is an object of class DependentForm) == true
    }

    // getParent() returns the value set as the parent argument in the detailed constructor
    @Test
    void parentTester(){
        assertEquals(parent, form.getParent()); // parent (set by constructor) == getParent return
    }

    // getDependent() returns the value set as the dependent argument in the detailed constructor
    @Test
    void dependentTester(){
        assertEquals(dependent, form.getDependent());   // dependent (set by constructor) == getDependent return
    }
    
    // getID() returns the value set as the formID argument in the detailed constructor
    @Test
    void formIDTester(){
        assertEquals(321, form.getID());        // formID (set by constructor) == getID return
    }

    // uninitialized parent attribute of a DependentForm object created through the default constructor == null
    @Test
    void defaultParentTester(){
        assertNull(empty.getParent());  // DependentForm object.parent (default constructed) == null
    }

    // uninitialized dependent attribute of a DependentForm object created through the default constructor ==  null.
    @Test
    void defaultDependentTester(){
        assertNull(empty.getDependent());   // DependentForm object.dependent (default constructed) == null
    }

    // uninitialized formID attribute of a DependentForm object created through the default constructor == -1
    @Test
    void defaultFormIDTester(){
        assertEquals(-1, empty.getID());    // DependentForm object.formID (default constructed) == -1
    }

    // setParent() method assigns its parameter as the DependentForm object's parent attribute
    @Test
    void setParentTester(){
        fill.setParent(parent);     // DependentForm object.parent (default constructed) = parent (param)
        assertEquals(parent, fill.getParent()); // parent (param) == DependentForm object.parent (set by setParent) 
    }

    // setDependent() method assigns its parameter as the DependentForm object's dependent attribute
    @Test
    void setDependentTester(){
        fill.setDependent(dependent);   // DependentForm object.dependent (default constructed) = dependent (param)
        assertEquals(dependent, fill.getDependent());   // dependent (param) == DependentForm 
                                                        //object.dependent (set by setDependent)
    }

    // setID() method assigns its parameter as the DependentForm object's formID
    @Test
    void setFormIDTester(){
        fill.setID(999);    // DependentForm object.formID (default constructed) = 999 (param)
        assertEquals(999, fill.getID());    // 999 (param) == DependentForm object.formID (set by setID)
    }

}