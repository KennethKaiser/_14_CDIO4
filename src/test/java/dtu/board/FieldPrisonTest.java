package dtu.board;

import dtu.controllers.BoardController;
import dtu.controllers.PlayerViewController;
import dtu.dice.RaffleCup;
import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldPrisonTest {

    @Test
    void testGoPrisonLabelAndType() {
        //expected
        final String LABEL = "Du ryger direkte i fængsel!";
        final String TYPE = "jail";
        BoardController boardController = new BoardController();
        Board board = new Board();

        GoPrisonField GoPrison = (GoPrisonField) board.getCurrentBoard()[30];

        //Tester at FieldProperty kan give label og type
        assertEquals(LABEL, GoPrison.landedLabel(),"expect GoPrison to have label: " + LABEL + ". GoPrison has: " + GoPrison.landedLabel());
        assertEquals(TYPE,GoPrison.type(),"expect GoPrison to have type: " + TYPE + ". GoPrison has type: " + GoPrison.type());
    }

    @Test
    void testPrisonLabelAndType() {
        //expected
        final String LABEL = "Du er ryger direkte i fængsel.";
        final String TYPE = "jail";
        BoardController boardController = new BoardController();
        Board board = new Board();

        DummyField dummy = (DummyField) board.getCurrentBoard()[10];
        PrisonField prisonField = new PrisonField(dummy.getDummy());

        //Tester at FieldProperty kan give label og type
        assertEquals(LABEL, prisonField.landedLabel(),"expect Prison to have label: " + LABEL + ". Prison has: " + prisonField.landedLabel());
        assertEquals(TYPE,prisonField.type(),"expect Prison to have type: " + TYPE + ". Prison has type: " + prisonField.type());
    }

    @Test
    void testPrisonBailFunction() {
        //variabel
        final int START_MONEY = 10000;
        final int PRISON = 10;
        //expected
        final int BAIL = (START_MONEY - 1000);
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");

        GoPrisonField GoPrison = (GoPrisonField) board.getCurrentBoard()[30];

        DummyField dummy = (DummyField) board.getCurrentBoard()[10];
        PrisonField prisonField = new PrisonField(dummy.getDummy());

        playerHandler.newSetPosition(playerHandler.getPlayers()[0], 10);
        playerHandler.getPlayers()[0].setJail(true);

        //Tester at spilleren først anses som at være fængslet
        assertEquals(true,playerHandler.getPlayers()[0].isJail(),"expect player prison status to be: " + true + ". player has: " + playerHandler .getPlayers()[0].isJail());


        prisonField.bailOut(playerHandler.getPlayers()[0]);

        //Tester at spilleren har mistet penge
        assertEquals(BAIL, playerHandler.getPlayers()[0].getMoney(),"expect player to after bail have money: " + BAIL + ". Player has money: " + playerHandler.getPlayers()[0].getMoney());
        //Tester at spilleren anses som ikke længere at være fængslet
        assertEquals(false,playerHandler.getPlayers()[0].isJail(),"expect player prison status to be: " + false + ". player has: " + playerHandler .getPlayers()[0].isJail());
    }

    @Test
    void testPrisonCardFunction() {
        //variabel
        final int START_MONEY = 10000;
        final int PRISON = 10;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");

        GoPrisonField GoPrison = (GoPrisonField) board.getCurrentBoard()[30];

        DummyField dummy = (DummyField) board.getCurrentBoard()[10];
        PrisonField prisonField = new PrisonField(dummy.getDummy());

        playerHandler.getPlayers()[0].setGetOutOfJailCard(true);
        playerHandler.newSetPosition(playerHandler.getPlayers()[0], 10);
        playerHandler.getPlayers()[0].setJail(true);

        //Tester at spilleren først anses som at være fængslet
        assertEquals(true,playerHandler.getPlayers()[0].isJail(),"expect player prison status to be: " + true + ". player has: " + playerHandler .getPlayers()[0].isJail());


        prisonField.cardOut(playerHandler.getPlayers()[0]);

        //Tester at spilleren ikke har mistet penge
        assertEquals(START_MONEY, playerHandler.getPlayers()[0].getMoney(),"expect player to still have money as: " + START_MONEY + ". Player has money: " + playerHandler.getPlayers()[0].getMoney());
        //Tester at spilleren anses som ikke længere at være fængslet
        assertEquals(false,playerHandler.getPlayers()[0].isJail(),"expect player prison status to be: " + false + ". player has: " + playerHandler .getPlayers()[0].isJail());
       //Tester at spilleren har mistet kortet
        assertEquals(false,playerHandler.getPlayers()[0].isGetOutOfJailCard(),"expect player prison status to be: " + false + ". player has: " + playerHandler .getPlayers()[0].isJail());

    }

    @Test
    void testPrisonNoCardFunction() {
        //variabel
        final int START_MONEY = 10000;
        final int PRISON = 10;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");

        GoPrisonField GoPrison = (GoPrisonField) board.getCurrentBoard()[30];

        DummyField dummy = (DummyField) board.getCurrentBoard()[10];
        PrisonField prisonField = new PrisonField(dummy.getDummy());

        playerHandler.getPlayers()[0].setGetOutOfJailCard(false);
        playerHandler.newSetPosition(playerHandler.getPlayers()[0], 10);
        playerHandler.getPlayers()[0].setJail(true);

        //Tester at spilleren først anses som at være fængslet
        assertEquals(true,playerHandler.getPlayers()[0].isJail(),"expect player prison status to be: " + true + ". player has: " + playerHandler .getPlayers()[0].isJail());


        prisonField.cardOut(playerHandler.getPlayers()[0]);

        //Tester at spilleren ikke har mistet penge
        assertEquals(START_MONEY, playerHandler.getPlayers()[0].getMoney(),"expect player to still have money as: " + START_MONEY + ". Player has money: " + playerHandler.getPlayers()[0].getMoney());
        //Tester at spilleren anses som stadig at være i fængslet
        assertEquals(true,playerHandler.getPlayers()[0].isJail(),"expect player prison status to be: " + true + ". player has: " + playerHandler .getPlayers()[0].isJail());
        //Tester at spilleren stadig ikke har kortet
        assertEquals(false,playerHandler.getPlayers()[0].isGetOutOfJailCard(),"expect player prison status to be: " + false + ". player has: " + playerHandler .getPlayers()[0].isJail());

    }

    /*
    @Test
    void testPrisonDoubleFunction() {
        //variabel
        final int START_MONEY = 10000;
        final int PRISON = 10;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        RaffleCup raffleCup = new RaffleCup();

        int[] dobbelt = {3,3};
        raffleCup.setOurRolls(dobbelt);

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");

        GoPrisonField GoPrison = (GoPrisonField) board.getCurrentBoard()[30];

        DummyField dummy = (DummyField) board.getCurrentBoard()[10];
        PrisonField prisonField = new PrisonField(dummy.getDummy());

        playerHandler.getPlayers()[0].setPosition(10);
        playerHandler.getPlayers()[0].setJail(true);

        prisonField.doubleOut(playerHandler.getPlayers()[0]);

        //Tester at spilleren først anses som at være fængslet
        assertEquals(true,playerHandler.getPlayers()[0].isJail(),"expect player prison status to be: " + true + ". player has: " + playerHandler .getPlayers()[0].isJail());


        prisonField.cardOut(playerHandler.getPlayers()[0]);

        //Tester at spilleren ikke har mistet penge
        assertEquals(START_MONEY, playerHandler.getPlayers()[0].getMoney(),"expect player to still have money as: " + START_MONEY + ". Player has money: " + playerHandler.getPlayers()[0].getMoney());
        //Tester at spilleren anses som ikke længere at være fængslet
        assertEquals(false,playerHandler.getPlayers()[0].isJail(),"expect player prison status to be: " + false + ". player has: " + playerHandler .getPlayers()[0].isJail());
        //Tester at spilleren har mistet kortet
        assertEquals(false,playerHandler.getPlayers()[0].isGetOutOfJailCard(),"expect player prison status to be: " + false + ". player has: " + playerHandler .getPlayers()[0].isJail());

    }

     */

}