package dtu.dice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestrolledDouble {

    @Test
    void TestrolledDouble() {

        RaffleCup raffleCup = new RaffleCup();

        raffleCup.roll();
        raffleCup.setOurRolls(new int[]{1, 1});
        raffleCup.rolledDouble();
        System.out.println(raffleCup.getNumberOfDoubles());
        System.out.println(raffleCup.getOurRolls()[0]);
        System.out.println(raffleCup.getOurRolls()[1]);

        raffleCup.roll();
        raffleCup.setOurRolls(new int[]{2, 2});
        raffleCup.rolledDouble();
        System.out.println(raffleCup.getNumberOfDoubles());
        System.out.println(raffleCup.getOurRolls()[0]);
        System.out.println(raffleCup.getOurRolls()[1]);
        assertEquals(true, raffleCup.rolledDouble());
    }

    @Test
    void TestrolledDoubleFail() {

        RaffleCup raffleCup = new RaffleCup();

        raffleCup.roll();
        raffleCup.setOurRolls(new int[]{2, 1});
        raffleCup.rolledDouble();
        System.out.println(raffleCup.getNumberOfDoubles());
        System.out.println(raffleCup.getOurRolls()[0]);
        System.out.println(raffleCup.getOurRolls()[1]);

        raffleCup.roll();
        raffleCup.setOurRolls(new int[]{1, 2});
        raffleCup.rolledDouble();
        System.out.println(raffleCup.getNumberOfDoubles());
        System.out.println(raffleCup.getOurRolls()[0]);
        System.out.println(raffleCup.getOurRolls()[1]);
        assertEquals(false, raffleCup.rolledDouble());
    }
}