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

    @Test
    void testLabelAndType() {
        Tax tax = new Tax(4,"TaxTest",2000);
        TaxField taxField = new TaxField(tax);
        //Variable
        final String LABEL = "Du er landet på "+ tax.getName()+".";
        final String TYPE = "tax";

        //Tester label
        assertEquals(LABEL, taxField.landedLabel());
        //Tester tyoe
        assertEquals(TYPE, taxField.type());
    }

    @Test
    void testTaxGetTax() {
        //Variable
        final int ID = 4;
        final int ID2 = 38;
        final String NAME = "TaxTest";
        final String NAME2 = "IndkomstTest";
        final int AMOUNT = 2000;
        final int AMOUNT2 = 4000;

        Tax tax = new Tax(ID, NAME, AMOUNT);
        TaxField taxField = new TaxField(tax);
        Tax tax2 = new Tax(ID2, NAME2, AMOUNT2);
        TaxField taxField2 = new TaxField(tax2);

        //Tester at getTax er rigtig
        assertEquals(tax, taxField.getTax());
        assertEquals(tax2, taxField2.getTax());
    }

    @Test
    void testTaxing() {
        //Variable
        final int ID = 4;
        final int ID2 = 38;
        final String NAME = "TaxTest";
        final String NAME2 = "IndkomstTest";
        final int AMOUNT = 4000;
        final int AMOUNT2 = 2000;
        final int START_MONEY = 50000;
        final int RENT1 = (START_MONEY - AMOUNT);
        final int RENT2 = (START_MONEY - AMOUNT2);
        final int RENT3 = (START_MONEY - (START_MONEY/10));
        Jackpot jackpot = new Jackpot();
        jackpot.setAmount(100);
        jackpot.addToJackpot(200);
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.setJackpot(jackpot);
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");
        playerHandler.initializePlayerInPlayers(3, "test", START_MONEY, "green");

        Tax tax = new Tax(ID, NAME, AMOUNT);
        TaxField taxField = new TaxField(tax);
        Tax tax2 = new Tax(ID2, NAME2, AMOUNT2);
        TaxField taxField2 = new TaxField(tax2);

        assertEquals(START_MONEY, playerHandler.getPlayers()[0].getMoney(),
                "1Forventer spilleren har: "+ START_MONEY +". Spilleren har: "+ playerHandler.getPlayers()[0].getMoney());

        playerHandler.incomeTax(playerHandler.getPlayers()[0],true);

        assertEquals(RENT1, playerHandler.getPlayers()[0].getMoney(),
                "2Forventer spilleren har: "+ RENT1 +". Spilleren har: "+ playerHandler.getPlayers()[0].getMoney());

        playerHandler.otherTaxField(playerHandler.getPlayers()[1]);

        assertEquals(RENT2, playerHandler.getPlayers()[1].getMoney(),
                "3Forventer spilleren har: "+ RENT2 +". Spilleren har: "+ playerHandler.getPlayers()[1].getMoney());

        playerHandler.incomeTax(playerHandler.getPlayers()[2],false);

        assertEquals(RENT3, playerHandler.getPlayers()[2].getMoney(),
                "4Forventer spilleren har: "+ RENT3 +". Spilleren har: "+ playerHandler.getPlayers()[2].getMoney());
    }

    @Test
    void testTaxing2() {
        //Variable
        final int ID = 4;
        final int ID2 = 38;
        final String NAME = "TaxTest";
        final String NAME2 = "IndkomstTest";
        final int AMOUNT = 4000;
        final int AMOUNT2 = 2000;
        final int START_MONEY = 50000;
        final int RENT1 = (START_MONEY - AMOUNT);
        final int RENT2 = (START_MONEY - AMOUNT2);
        final int RENT3 = (START_MONEY - (START_MONEY/10));
        Jackpot jackpot = new Jackpot();
        jackpot.setAmount(100);
        jackpot.addToJackpot(200);
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.setJackpot(jackpot);
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");
        playerHandler.initializePlayerInPlayers(3, "test", START_MONEY, "green");

        Tax tax = new Tax(ID, NAME, AMOUNT);
        TaxField taxField = new TaxField(tax);
        taxField.setPlayerHandler(playerHandler);
        Tax tax2 = new Tax(ID2, NAME2, AMOUNT2);
        TaxField taxField2 = new TaxField(tax2);
        taxField2.setPlayerHandler(playerHandler);

        assertEquals(START_MONEY, playerHandler.getPlayers()[0].getMoney(),
                "1Forventer spilleren har: "+ START_MONEY +". Spilleren har: "+ playerHandler.getPlayers()[0].getMoney());

        taxField.taxing(playerHandler.getPlayers()[0], true);

        assertEquals(RENT1, playerHandler.getPlayers()[0].getMoney(),
                "2Forventer spilleren har: "+ RENT1 +". Spilleren har: "+ playerHandler.getPlayers()[0].getMoney());

        taxField2.taxing(playerHandler.getPlayers()[1], false);

        assertEquals(RENT2, playerHandler.getPlayers()[1].getMoney(),
                "3Forventer spilleren har: "+ RENT2 +". Spilleren har: "+ playerHandler.getPlayers()[1].getMoney());

        taxField.taxing(playerHandler.getPlayers()[2], false);

        assertEquals(RENT3, playerHandler.getPlayers()[2].getMoney(),
                "4Forventer spilleren har: "+ RENT3 +". Spilleren har: "+ playerHandler.getPlayers()[2].getMoney());
    }

}