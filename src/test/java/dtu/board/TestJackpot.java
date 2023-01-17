package dtu.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestJackpot {

    @Test
    void testGetMethods() {
        //Variable
        final String NAME = "JackpotTest";
        final String NAME2 = "Det er JackpotTest2";
        final int AMOUNT = 2000;
        final int AMOUNT2 = 4000;


        Jackpot jackpot = new Jackpot();
        jackpot.setName(NAME);
        //Tester ID
        assertEquals(NAME, jackpot.getName());

        jackpot.setName(NAME2);
        assertEquals(NAME2, jackpot.getName());

        //Tester Amount
        jackpot.setAmount(AMOUNT);
        assertEquals(AMOUNT, jackpot.getAmount());

        jackpot.setAmount(AMOUNT2);
        assertEquals(AMOUNT2, jackpot.getAmount());
    }

    @Test
    void testLabelAndType() {
        Jackpot jackpot = new Jackpot();
        //Variable
        final String LABEL = "Du er landet på "+ jackpot.getName()+" .";
        final String TYPE = "parking";

        //Tester label
        assertEquals(LABEL, jackpot.landedLabel());
        //Tester tyoe
        assertEquals(TYPE, jackpot.type());
    }

    @Test
    void testJackpotWin() {
        //Variable
        final int ID = 4;
        final int ID2 = 38;
        final String NAME = "TaxTest";
        final String NAME2 = "IndkomstTest";
        final int AMOUNT = 2000;

        Jackpot jackpot = new Jackpot();
        jackpot.setAmount(AMOUNT);
        jackpot.jackpotWin();

        //Tester at jackpotWins er rigtig
        assertEquals(0,jackpot.getAmount(),"Tester jackpotWin fjerner penge");
    }

}