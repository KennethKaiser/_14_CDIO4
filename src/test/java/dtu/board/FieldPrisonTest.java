package dtu.board;

import dtu.controllers.BoardController;
import dtu.controllers.PlayerViewController;
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
    void testGoPrisonFunction() {
        //expected
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

        GoPrison.moveToPrison(playerHandler.getPlayers()[0]);

        //Tester at spilleren er flyttet til prison
        assertEquals(PRISON, playerHandler.getPlayers()[0].getPosition(),"expect player to have be moved to: " + PRISON + ". Player is at: " + playerHandler.getPlayers()[0].getPosition());
        //Tester at spilleren anses som fængslet
        assertEquals(true,playerHandler .getPlayers()[0].isJail(),"expect GoPrison to have type: " + true + ". GoPrison has type: " + playerHandler .getPlayers()[0].isJail());
    }

}