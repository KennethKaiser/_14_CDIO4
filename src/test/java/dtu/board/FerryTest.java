package dtu.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FerryTest {

    @Test
    void getMethods() {
        Ferry ferry = new Ferry(0, "test", 69, 1000, 2000, 3000,4000,5000);

        assertEquals(0, ferry.getID());
        ferry.setID(1);
        assertEquals(1, ferry.getID());
        assertEquals("test", ferry.getName());
        ferry.setName("test1");
        assertEquals("test1", ferry.getName());
        assertEquals(69, ferry.getFamilie());
        ferry.setFamilie(50);
        assertEquals(50, ferry.getFamilie());
        ferry.setPrice(69);
        assertEquals(69, ferry.getPrice());
        ferry.setRent1(50);
        assertEquals(50, ferry.getRent1());
        ferry.setRent2(99);
        assertEquals(99, ferry.getRent2());
        ferry.setRent3(666);
        assertEquals(666, ferry.getRent3());
        ferry.setRent4(333);
        assertEquals(333, ferry.getRent4());
    }
}