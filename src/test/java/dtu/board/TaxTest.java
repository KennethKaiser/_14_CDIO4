package dtu.board;

import dtu.controllers.BoardController;
import dtu.controllers.ControllerHandler;
import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxTest {

    @Test
    void testTaxGetMethods() {
        //Variable
        final int ID = 4;
        final int ID2 = 38;
        final String NAME = "TaxTest";
        final String NAME2 = "IndkomstTest";
        final int AMOUNT = 2000;
        final int AMOUNT2 = 4000;

        Tax tax = new Tax(ID,NAME,AMOUNT);
        Tax tax2 = new Tax(ID2,NAME2,AMOUNT2);

        //Tester ID
        assertEquals(ID, tax.getID());
        assertEquals(ID2, tax2.getID());
        //Tester Name
        assertEquals(NAME, tax.getName());
        assertEquals(NAME2, tax2.getName());
        //Test amount
        assertEquals(AMOUNT, tax.getAmount());
        assertEquals(AMOUNT2, tax2.getAmount());
    }

}