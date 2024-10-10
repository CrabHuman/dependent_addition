package edu.gmu.cs321;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    @Test
    public void testPersonConstructor(){
        Person testPerson = new Person("Bob");
        //testPerson = null;
        boolean testConstructor = testPerson != null;
        assertTrue(testConstructor);
    }
}
