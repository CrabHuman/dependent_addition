package edu.gmu.cs321;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ImmigrantTest{
    // variable declaration
    static Immigrant immigrant;
    static Immigrant empty;
    static Immigrant fill;

    // variable initialization
    @BeforeAll
    static void setUp(){
        immigrant = new Immigrant("Bob", "Bryant", 655, new Date(1000000000L), "Courtlane Dr", 1112223333L, "bb@b.com" );
        empty = new Immigrant();
        fill = new Immigrant("Carl", "Bumps",882);
    }
    
    // confirmation of class inheritance through type checking
    @Test
    void dependentInstanceTester(){
        assertTrue(immigrant instanceof Immigrant);
        assertTrue(immigrant instanceof Person);
    }

    // detailed constructor's date of birth argument == created object's dateOfBirth attribute
    @Test
    void DoBTester(){
        assertEquals(new Date(1000000000L),immigrant.getDateOfBirth());
    }

    // detailed constructor's address argument == created object's address attribute
    @Test
    void addressTester(){
        assertEquals("Courtlane Dr",immigrant.getAddress());
    }

    // detailed constructor's phoneNumber argument == created object's phoneNumber attribute
    @Test
    void phoneNumberTester(){
        assertEquals(1112223333L, immigrant.getPhoneNumber());
    }

    // detailed constructor's email argument == created object's email attribute
    @Test
    void emailTester(){
        assertEquals("bb@b.com", immigrant.getEmail());
    }

    // default constructed Immigrant's dateOfBirth attribute == null
    @Test
    void defaultDoBTester(){
        assertNull(empty.getDateOfBirth());
    }

    // default constructed Immigrant's address attribute == null
    @Test
    void defaultAddressTester(){
        assertNull(empty.getAddress());
    }

    // default constructed Immigrant's phoneNumber attribute == -1
    @Test
    void defaultPhoneNumberTester(){
        assertEquals(-1,empty.getPhoneNumber());
    }

    // default constructed Immigrant's email attribute == null
    @Test
    void defaultEmailTester(){
        assertNull(empty.getEmail());
    }

    // default constructed Immigrant's dateOfBirth attribute is set using setDateOfBirth and tested as the param value
    @Test
    void setDoBTester(){
        fill.setDateOfBirth(new Date(2000L));
        assertEquals(new Date(2000L),fill.getDateOfBirth());
    }

    // default constructed Immigrant's address attribute is set using setAddress and tested as the param value
    @Test
    void setAddressTester(){
        fill.setAddress("Terraceloop Rd");
        assertEquals("Terraceloop Rd",fill.getAddress());
    }

    // default constructed Immigrant's phoneNumber attribute is set using setPhoneNumber and tested as the param value
    @Test
    void setPhoneNumberTester(){
        fill.setPhoneNumber(9998887777L);
        assertEquals(9998887777L,fill.getPhoneNumber());
    }

    // default constructed Immigrant's email attribute is set using setEmail and tested as the param value
    @Test
    void setEmailTester(){
        fill.setEmail("cal@cal.com");
        assertEquals("cal@cal.com",fill.getEmail());
    }

}
