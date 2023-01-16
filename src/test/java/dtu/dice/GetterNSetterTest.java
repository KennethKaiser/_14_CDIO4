package dtu.dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetterNSetterTest {

    @Test
    void almen() {
        //Variable
        final int SUM = 11;

        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();
        raffleCup.setSum(SUM);
        assertEquals(SUM, raffleCup.getSum(), "Expect sum to be: "+ SUM +". sum is: "+ raffleCup.getSum());
    }

    @Test
    void NumberOfRolls() {
        //Variable
        final int NUMBER_OF_ROLL = 2;

        RaffleCup raffleCup = new RaffleCup();

        assertEquals(NUMBER_OF_ROLL, raffleCup.getNUMBER_OF_ROLLS(),"Expect Number to always be: 2. number is: "+raffleCup.getNUMBER_OF_ROLLS());
    }

    @Test
    void RolledDouble() {
        final int NUMBER = 3;

        RaffleCup raffleCup = new RaffleCup();
        raffleCup.setRolledDouble(true);

        assertEquals(true, raffleCup.isRolledDouble(),"Expect rolled double to be true. is: "+raffleCup.isRolledDouble());

        raffleCup.setNumberOfDoubles(NUMBER);
        assertEquals(NUMBER,raffleCup.getNumberOfDoubles(),"Expect number of doubles to be 3. is: "+ raffleCup.getNumberOfDoubles());
    }

    @Test
    void Die() {
        Die dieTest = new Die();
        RaffleCup raffleCup = new RaffleCup();

        raffleCup.setDie(dieTest);

        assertEquals(dieTest, raffleCup.getDie(),
                "Expect die to be: "+ dieTest +". Die is: "+raffleCup.getDie());
 }

}