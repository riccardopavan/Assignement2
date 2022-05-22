////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;
    String name;
    int age;

    @BeforeEach
    public void setUp() {
        name = "Carlo";
        age = 47;

        user = new User(name, age);
    }

    @Test
    public void testGetName() {
        assertEquals(name, user.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(age, user.getAge());
    }

    @Test
    public void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, age));
    }

    @Test
    public void testAgeNegative() {
        assertThrows(IllegalArgumentException.class, () -> new User(name, -1));
    }

    @Test
    public void testNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new User("", age));
    }
}
