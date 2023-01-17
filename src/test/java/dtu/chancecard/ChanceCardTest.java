package dtu.chancecard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChanceCardTest {

    @Test
    void testGetterNSetter() {
        final int ID = 2;
        final String DESC = "A new testing card description, unlike the previous";
       ChanceCard chanceCard = new ChanceCard(0,"a testing card, for unit-testing");

        assertEquals(0, chanceCard.getId(), "expect 0, is: "+ chanceCard.getId());
        assertEquals("a testing card, for unit-testing", chanceCard.getDesc(), "testing first desc");


       chanceCard.setId(ID);
       chanceCard.setDesc(DESC);

        assertEquals(ID, chanceCard.getId(), "expect 2, is: "+ chanceCard.getId());
        assertEquals(DESC, chanceCard.getDesc(), "testing new desc to: "+ chanceCard.getDesc());


    }
}