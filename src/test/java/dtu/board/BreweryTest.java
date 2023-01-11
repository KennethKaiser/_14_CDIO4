package dtu.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreweryTest {

    @Test
    void getMethods() {
        Brewery brewery = new Brewery(0, "test", 69, 1000, 2000, 3000);
        assertEquals("test", brewery.getName());
        brewery.setName("test1");
        assertEquals("test1", brewery.getName());
        assertEquals(69, brewery.getFamily());
        brewery.setFamily(50);
        assertEquals(50, brewery.getFamily());
        brewery.setPrice(69);
        assertEquals(69, brewery.getPrice());
        brewery.setRent1(50);
        assertEquals(50, brewery.getRent1());
        brewery.setRent2(99);
        assertEquals(99, brewery.getRent2());
    }
}