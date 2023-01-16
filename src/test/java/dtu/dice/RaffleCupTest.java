package dtu.dice;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RaffleCupTest {

    private final int NUMBER_OF_ROLLS = 2;
    private int[] ourRolls;
    private int sum;
    private boolean rolledDouble = false;
    private int numberOfDoubles = 0;
    private Die die = new Die();

    @Test
    void roll() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();

        assertEquals(2, raffleCup.getOurRolls().length);
    }

    @Test
    void turnSum() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();

        int[] lastRoll = {5, 2};
        raffleCup.turnSum(lastRoll);
        assertEquals(7, lastRoll[0] + lastRoll[1]);



    }

    @Test
    void getOurRolls() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();
        System.out.println(raffleCup.getOurRolls()[0]);
        System.out.println(raffleCup.getOurRolls()[1]);
        assertEquals(true, raffleCup.getOurRolls()[0] >= 1 && raffleCup.getOurRolls()[0] <= 6);
        assertEquals(true, raffleCup.getOurRolls()[1] >= 1 && raffleCup.getOurRolls()[1] <= 6);
    }

    @Test
    void getSum() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();
        raffleCup.turnSum(raffleCup.getOurRolls());
        System.out.println(raffleCup.getSum());
        assertEquals(true, raffleCup.getSum() >= 2 && raffleCup.getSum() <= 12);
    }

    @Test
    void setSum() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();
        raffleCup.turnSum(raffleCup.getOurRolls());
        raffleCup.setSum(10);
        assertEquals(10, raffleCup.getSum());
    }

    @Test
    void setOurRolls() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();
        raffleCup.turnSum(raffleCup.getOurRolls());
        int[] lastRoll = {5, 2};
        raffleCup.setOurRolls(lastRoll);
        assertEquals(5, raffleCup.getOurRolls()[0]);
        assertEquals(2, raffleCup.getOurRolls()[1]);
    }

    @Test
    void isRolledDouble() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();
        raffleCup.turnSum(raffleCup.getOurRolls());
        int[] lastRoll = {3, 3};
        raffleCup.setOurRolls(lastRoll);
        raffleCup.rolledDouble();
        assertEquals( true, raffleCup.isRolledDouble());
    }

    @Test
    void setRolledDouble() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();
        raffleCup.turnSum(raffleCup.getOurRolls());
        int[] lastRoll = {3, 3};
        raffleCup.setOurRolls(lastRoll);
        raffleCup.rolledDouble();
        raffleCup.setRolledDouble(false);
        assertEquals(false, raffleCup.isRolledDouble());
    }

    @Test
    void getNumberOfDoubles() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();
        raffleCup.turnSum(raffleCup.getOurRolls());
        int[] lastRoll = {3, 3};
        raffleCup.setOurRolls(lastRoll);
        raffleCup.rolledDouble();
        assertEquals(1, raffleCup.getNumberOfDoubles());

        raffleCup.roll();
        raffleCup.turnSum(raffleCup.getOurRolls());
        raffleCup.setOurRolls(lastRoll);
        raffleCup.rolledDouble();
        assertEquals(2, raffleCup.getNumberOfDoubles());
    }

    @Test
    void setNumberOfDoubles() {
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.roll();
        raffleCup.turnSum(raffleCup.getOurRolls());
        int[] lastRoll = {3, 3};
        raffleCup.setOurRolls(lastRoll);
        raffleCup.rolledDouble();
        raffleCup.setNumberOfDoubles(2);
        assertEquals(2, raffleCup.getNumberOfDoubles());
    }
}