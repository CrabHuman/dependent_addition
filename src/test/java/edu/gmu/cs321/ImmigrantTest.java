package edu.gmu.cs321;
import java.util.Date;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ImmigrantTest{
    static Immigrant immigrant;
    static Immigrant empty;
    static Immigrant fill;

    @BeforeAll
    static void setUp(){
        immigrant = new Immigrant("Bob", "Bryant", 655, new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com" );
        empty = new Immigrant();
        fill = new Immigrant("Carl", "Bumps",882);
    }
    
    @Test
    void DoBTester(){
        assertEquals(new Date(1000000000L),immigrant.getDateOfBirth());
    }
    @Test
    void addressTester(){
        assertEquals("Courtlane Dr",immigrant.getAddress());
    }
    @Test
    void phoneNumberTester(){
        assertEquals(1112223333L, immigrant.getPhoneNumber());
    }
    @Test
    void emailTester(){
        assertEquals("bb@b.com", immigrant.getEmail());
    }

    @Test
    void defaultDoBTester(){
        assertNull(empty.getDateOfBirth());
    }
    @Test
    void defaultAddressTester(){
        assertNull(empty.getAddress());
    }
    @Test
    void defaultPhoneNumberTester(){
        assertEquals(-1,empty.getPhoneNumber());
    }
    @Test
    void defaultEmailTester(){
        assertNull(empty.getEmail());
    }

    @Test
    void setDoBTester(){
        fill.setDateOfBirth(new Date(2000L));
        assertEquals(new Date(2000L),fill.getDateOfBirth());
    }
    @Test
    void setAddressTester(){
        fill.setAddress("Terraceloop Rd");
        assertEquals("Terraceloop Rd",fill.getAddress());
    }
    @Test
    void setPhoneNumberTester(){
        fill.setPhoneNumber(9998887777L);
        assertEquals(9998887777L,fill.getPhoneNumber());
    }
    @Test
    void setEmailTester(){
        fill.setEmail("dan@dan.com");
        assertEquals("dan@dan.com",fill.getEmail());
    }

}
