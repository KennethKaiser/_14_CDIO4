package dtu.players;

import dtu.board.PropertyHandler;
import dtu.players.Player;
import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TC3_MovePlayerTest {

    PlayerHandler playerHandler = new PlayerHandler();

    //Ændring af værdi
   final int STARTM = 4000;
   final int START_POS = 20;
   //variable for mængde at flytte sig
   final int MOVE = 4;
   final int BIG_MOVE = 12;
   final int BIGGER_MOVE = 30;
   final int NO_MOVE = 0;
   final int BACK_MOVE = -4;
   final int B_BACK_MOVE = -30;
   //Variable for forventet placering
    final int EX_M = START_POS + MOVE;
    final int EX_BIGM = START_POS + BIG_MOVE;
    final int EX_BIGGM = (START_POS + BIGGER_MOVE) - 40;
    final int EX_NM = START_POS;
    final int EX_BAM = START_POS + BACK_MOVE;
    final int EX_BBAM = (START_POS + B_BACK_MOVE) + 40;

    Player player = new Player(1, "Nicklas",STARTM,"Black");

    @Test
    void testMoving4Forward() {

        playerHandler.newSetPosition(player, START_POS);

        playerHandler.movePlayer(player, MOVE);

        assertTrue((player.getPosition() == EX_M), "expected (" + EX_M + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_M);
    }

    @Test
    void testMoving12Forward() {

        playerHandler.newSetPosition(player, START_POS);

        playerHandler.movePlayer(player, BIG_MOVE);

        assertTrue((player.getPosition() == EX_BIGM), "expected (" + EX_BIGM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_BIGM);
    }

    @Test
    void testMovingPastStartForward() {
        playerHandler.newSetPosition(player, START_POS);


        playerHandler.movePlayer(player, BIGGER_MOVE);

        assertTrue((player.getPosition() == EX_BIGGM), "expected (" + EX_BIGGM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_BIGGM);
    }

    @Test
    void testMoving0() {
        playerHandler.newSetPosition(player, START_POS);

        playerHandler.movePlayer(player, NO_MOVE);

        assertTrue((player.getPosition() == EX_NM), "expected (" + EX_NM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_NM);
    }

    @Test
    void testMoving4Backward() {

        playerHandler.newSetPosition(player, START_POS);

        playerHandler.movePlayer(player, BACK_MOVE);

        assertTrue((player.getPosition() == EX_BAM), "expected (" + EX_BAM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_BAM);
    }

    @Test
    void testMovingPastStartBackward() {
        playerHandler.newSetPosition(player, START_POS);

        playerHandler.movePlayer(player, B_BACK_MOVE);

        assertTrue((player.getPosition() == EX_BBAM), "expected (" + EX_BBAM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_BBAM);
    }

    @Test
    void testMoveChanceCardIDgreaterPlayerPos() {

        playerHandler.newSetPosition(player, 30);
        playerHandler.movePlayerChanceCard(player, 38);
        boolean expected = false;
        if (player.getPosition() == 38) {
            expected = true;
        }
        assertEquals(expected, true, "expecting 8, as it should move 8 forward");
    }

    @Test
    void testMoveChanceCardIDlessPlayerPos(){
        boolean expected = false;
        playerHandler.newSetPosition(player, 38);
        playerHandler.movePlayerChanceCard(player, 30);
        if (player.getPosition() == 30) {
            expected = true;
        }
        assertEquals(expected, true, "Expecting player to be on position 30");
    }

    /**
     * Test of nearestFerry method, of class GameActions.
     */
    @Test
    void testNearestFerry() {
        PropertyHandler propertyHandler = new PropertyHandler();

        Player player1 = new Player(0, "Nicklas", 4000, "Black");
        Player player2 = new Player(1, "Nicklas", 4000, "Black");
        Player player3 = new Player(2, "Nicklas", 4000, "Black");
        Player player4 = new Player(3, "Nicklas", 4000, "Black");
        Player player5 = new Player(4, "Nicklas", 4000, "Black");

        playerHandler.newSetPosition(player1, 36);
        playerHandler.newSetPosition(player2, 4);
        playerHandler.newSetPosition(player3, 14);
        playerHandler.newSetPosition(player4, 24);
        playerHandler.newSetPosition(player5, 34);



        playerHandler.nearestFerry(player1);
        assertEquals(5, player1.getPosition());

        playerHandler.nearestFerry(player2);
        assertEquals(5, player2.getPosition());

        playerHandler.nearestFerry(player3);
        assertEquals(15, player3.getPosition());

        playerHandler.nearestFerry(player4);
        assertEquals(25, player4.getPosition());

        playerHandler.nearestFerry(player5);
        assertEquals(35, player5.getPosition());


    }
}
