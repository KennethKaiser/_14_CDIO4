import dtu.game.GameActions;
import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static dtu.game.GameActions.movePlayer;
import static dtu.game.GameActions.movePlayerChanceCard;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TC3_MovePlayerTest {

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
        player.setPosition(START_POS);

        movePlayer(player, MOVE);

        assertTrue((player.getPosition() == EX_M), "expected (" + EX_M + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_M);
    }

    @Test
    void testMoving12Forward() {
        player.setPosition(START_POS);

        movePlayer(player, BIG_MOVE);

        assertTrue((player.getPosition() == EX_BIGM), "expected (" + EX_BIGM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_BIGM);
    }

    @Test
    void testMovingPastStartForward() {
        player.setPosition(START_POS);

        movePlayer(player, BIGGER_MOVE);

        assertTrue((player.getPosition() == EX_BIGGM), "expected (" + EX_BIGGM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_BIGGM);
    }

    @Test
    void testMoving0() {
        player.setPosition(START_POS);

        movePlayer(player, NO_MOVE);

        assertTrue((player.getPosition() == EX_NM), "expected (" + EX_NM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_NM);
    }

    @Test
    void testMoving4Backward() {
        player.setPosition(START_POS);

        movePlayer(player, BACK_MOVE);

        assertTrue((player.getPosition() == EX_BAM), "expected (" + EX_BAM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_BAM);
    }

    @Test
    void testMovingPastStartBackward() {
        player.setPosition(START_POS);

        movePlayer(player, B_BACK_MOVE);

        assertTrue((player.getPosition() == EX_BBAM), "expected (" + EX_BBAM + ") should be eaquel to players current placement: " + player.getPosition());
        System.out.println("player position is: " + player.getPosition() + ", expected placement is " + EX_BBAM);
    }

    @Test
    void testMoveChanceCardIDgreaterPlayerPos() {
        player.setPosition(30);
        movePlayerChanceCard(player, 38);
        boolean expected = false;
        if (player.getPosition() == 38) {
            expected = true;
        }
        assertEquals(expected, true, "expecting 8, as it should move 8 forward");
    }

    @Test
    void testMoveChanceCardIDlessPlayerPos(){
        boolean expected = false;
        player.setPosition(38);
        movePlayerChanceCard(player, 30);
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
        GameActions gameActions = new GameActions();

        boolean expected1 = false;
        boolean expected2 = false;
        boolean expected3 = false;
        boolean expected4 = false;
        boolean expected5 = false;

        Player player1 = new Player(0, "Nicklas", 4000, "Black");
        Player player2 = new Player(1, "Nicklas", 4000, "Black");
        Player player3 = new Player(2, "Nicklas", 4000, "Black");
        Player player4 = new Player(3, "Nicklas", 4000, "Black");
        Player player5 = new Player(4, "Nicklas", 4000, "Black");

        player1.setPosition(36);
        player2.setPosition(4);
        player3.setPosition(14);
        player4.setPosition(24);
        player5.setPosition(34);



        gameActions.nearestFerry(player1);
        System.out.println(player1.getPosition());

        if (player1.getPosition()==5) {
            expected1 = true;

        }
        assertEquals(true, expected1);



        gameActions.nearestFerry(player2);
        System.out.println(player2.getPosition());

        if (player2.getPosition()==5) {
            expected2 = true;

        }
        assertEquals(true, expected2);



        gameActions.nearestFerry(player3);
        System.out.println(player3.getPosition());

        if (player3.getPosition()==15) {
            expected3 = true;

        }
        assertEquals(true, expected3);



        gameActions.nearestFerry(player4);
        System.out.println(player4.getPosition());

        if (player4.getPosition()==25) {
            expected4 = true;

        }
        assertEquals(true, expected4);



        gameActions.nearestFerry(player5);
        System.out.println(player5.getPosition());

        if (player5.getPosition()==35) {
            expected5 = true;

        }
        assertEquals(true, expected5);


    }
}
